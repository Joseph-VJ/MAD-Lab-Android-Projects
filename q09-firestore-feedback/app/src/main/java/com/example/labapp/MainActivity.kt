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
import com.google.firebase.Firebase
import com.google.firebase.app
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.firestore

class MainActivity : ComponentActivity() {
    override fun onCreate(b: Bundle?) {
        super.onCreate(b)
        setContent { MaterialTheme { Surface(Modifier.fillMaxSize()) { Feedback() } } }
    }
}

@Composable
fun ConfigBanner() {
    if (Firebase.app.options.apiKey == "PLACEHOLDER_API_KEY")
        Text(
            "Firebase is not configured yet. Replace app/google-services.json with your own file (see README).",
            color = MaterialTheme.colorScheme.error
        )
}

@Composable
fun Feedback() {
    val db = remember { Firebase.firestore }
    var name by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }
    var list by remember { mutableStateOf(listOf<String>()) }

    DisposableEffect(Unit) {
        val reg = db.collection("feedback").orderBy("time").addSnapshotListener { s, _ ->
            list = s?.documents?.map {
                "${it.getString("name")}: ${it.getString("comment")}"
            } ?: emptyList()
        }
        onDispose { reg.remove() }
    }
    Column(Modifier.systemBarsPadding().padding(16.dp)) {
        ConfigBanner()
        OutlinedTextField(name, { name = it }, label = { Text("Student name") })
        OutlinedTextField(text, { text = it }, label = { Text("Feedback") })
        Button({
            if (name.isNotBlank() && text.isNotBlank()) {
                db.collection("feedback").add(
                    mapOf("name" to name, "comment" to text,
                        "time" to FieldValue.serverTimestamp()))
                text = ""
            }
        }) { Text("Submit") }
        LazyColumn { items(list) { Text(it, Modifier.padding(8.dp)) } }
    }
}
