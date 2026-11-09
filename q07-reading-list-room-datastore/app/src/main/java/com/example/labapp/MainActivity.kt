package com.example.labapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import android.content.Context
import androidx.compose.foundation.lazy.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(b: Bundle?) {
        super.onCreate(b)
        setContent { MaterialTheme { Surface(Modifier.fillMaxSize()) { ReadingList() } } }
    }
}

@Entity
data class Book(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String, val author: String
)

@Dao
interface BookDao {
    @Query("SELECT * FROM Book ORDER BY title COLLATE NOCASE") fun byTitle(): Flow<List<Book>>
    @Query("SELECT * FROM Book ORDER BY id DESC") fun newest(): Flow<List<Book>>
    @Insert suspend fun add(b: Book)
    @Delete suspend fun del(b: Book)
}

@Database(entities = [Book::class], version = 1, exportSchema = false)
abstract class Db : RoomDatabase() { abstract fun dao(): BookDao }

val Context.store by preferencesDataStore("settings")
val AZ = booleanPreferencesKey("az")

@Composable
fun ReadingList() {
    val ctx = LocalContext.current
    val dao = remember { Room.databaseBuilder(ctx, Db::class.java, "books").build().dao() }
    val scope = rememberCoroutineScope()
    val az by ctx.store.data.map { it[AZ] ?: true }.collectAsState(true)
    val flow = remember(az) { if (az) dao.byTitle() else dao.newest() }
    val books by flow.collectAsState(emptyList())
    var title by remember { mutableStateOf("") }
    var author by remember { mutableStateOf("") }

    Column(Modifier.systemBarsPadding().padding(16.dp)) {
        OutlinedTextField(title, { title = it }, label = { Text("Title") })
        OutlinedTextField(author, { author = it }, label = { Text("Author") })
        Button({
            if (title.isNotBlank()) scope.launch { dao.add(Book(title = title, author = author)) }
            title = ""; author = ""
        }) { Text("Save Book") }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(if (az) "Title A-Z " else "Newest First ")
            Switch(az, { v -> scope.launch { ctx.store.edit { it[AZ] = v } } })
        }
        LazyColumn {
            items(books) { b ->
                Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween,
                    Alignment.CenterVertically) {
                    Text("${b.title} - ${b.author}")
                    IconButton({ scope.launch { dao.del(b) } }) {
                        Icon(Icons.Default.Delete, "Delete")
                    }
                }
            }
        }
    }
}
