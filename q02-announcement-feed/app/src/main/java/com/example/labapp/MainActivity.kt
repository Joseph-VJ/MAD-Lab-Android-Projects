package com.example.labapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(b: Bundle?) {
        super.onCreate(b)
        setContent { MaterialTheme { Surface(Modifier.fillMaxSize()) { Feed() } } }
    }
}

sealed class Ann
class Notice(val text: String) : Ann()
class Alert(val text: String) : Ann()
class Pic(val caption: String) : Ann()
class Action(val text: String, val btn: String) : Ann()

val feed = listOf(
    Notice("Office closed on Friday"), Alert("Server maintenance at 10 PM!"),
    Pic("Team outing photo"), Action("Submit your timesheet", "Submit"),
    Notice("Town hall at 4 PM")
)

@Composable
fun Feed() {
    LazyColumn(
        Modifier.systemBarsPadding().padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(feed) { a ->
            val m = Modifier.fillMaxWidth()
            when (a) {
                is Notice -> Card(m) { Text(a.text, Modifier.padding(16.dp)) }
                is Alert -> Card(m, colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.errorContainer)) {
                    Text("URGENT: ${a.text}", Modifier.padding(16.dp),
                        fontWeight = FontWeight.Bold)
                }
                is Pic -> Card(m) { Column(Modifier.padding(16.dp)) {
                    Image(Icons.Default.Info, null, Modifier.size(80.dp)); Text(a.caption) } }
                is Action -> Card(m) {
                    Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                        Text(a.text, Modifier.weight(1f)); Button({}) { Text(a.btn) }
                    }
                }
            }
        }
    }
}
