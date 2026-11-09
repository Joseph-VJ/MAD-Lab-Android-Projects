package com.example.labapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MainActivity : ComponentActivity() {
    override fun onCreate(b: Bundle?) {
        super.onCreate(b)
        setContent { MaterialTheme { Surface(Modifier.fillMaxSize()) { Comments() } } }
    }
}

data class Comment(val name: String, val email: String)

interface Api { @GET("comments") suspend fun comments(): List<Comment> }

val api: Api = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
    .addConverterFactory(GsonConverterFactory.create()).build().create(Api::class.java)

@Composable
fun Comments() {
    var list by remember { mutableStateOf<List<Comment>?>(null) }
    LaunchedEffect(Unit) { list = try { api.comments() } catch (e: Exception) { emptyList() } }
    val l = list
    if (l == null) {
        Box(Modifier.fillMaxSize(), Alignment.Center) { CircularProgressIndicator() }
    } else {
        LazyColumn(Modifier.systemBarsPadding()) {
            items(l) { c ->
                Column(Modifier.padding(12.dp)) {
                    Text(c.name, fontWeight = FontWeight.Bold)
                    Text(c.email)
                }
            }
        }
    }
}
