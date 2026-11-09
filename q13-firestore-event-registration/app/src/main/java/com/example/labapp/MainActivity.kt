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
        setContent { MaterialTheme { Surface(Modifier.fillMaxSize()) { Register() } } }
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Register() {
    val db = remember { Firebase.firestore }
    val events = listOf("Hackathon", "Workshop", "Quiz")
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var event by remember { mutableStateOf(events[0]) }
    var open by remember { mutableStateOf(false) }
    var list by remember { mutableStateOf(listOf<String>()) }

    DisposableEffect(Unit) {
        val reg = db.collection("registrations").orderBy("time").addSnapshotListener { s, _ ->
            list = s?.documents?.map {
                "${it.getString("name")} (${it.getString("email")}) - ${it.getString("event")}"
            } ?: emptyList()
        }
        onDispose { reg.remove() }
    }
    Column(Modifier.systemBarsPadding().padding(16.dp)) {
        ConfigBanner()
        Text("Total registrations: ${list.size}", style = MaterialTheme.typography.titleLarge)
        OutlinedTextField(name, { name = it }, label = { Text("Name") })
        OutlinedTextField(email, { email = it }, label = { Text("Email") })
        ExposedDropdownMenuBox(open, { open = it }) {
            OutlinedTextField(event, {}, Modifier.menuAnchor(MenuAnchorType.PrimaryNotEditable),
                readOnly = true, label = { Text("Event") })
            ExposedDropdownMenu(open, { open = false }) {
                events.forEach { e -> DropdownMenuItem({ Text(e) }, { event = e; open = false }) }
            }
        }
        Button({
            if (name.isNotBlank() && email.isNotBlank()) {
                db.collection("registrations").add(mapOf("name" to name, "email" to email,
                    "event" to event, "time" to FieldValue.serverTimestamp()))
                name = ""; email = ""
            }
        }) { Text("Register") }
        LazyColumn { items(list) { Text(it, Modifier.padding(8.dp)) } }
    }
}
