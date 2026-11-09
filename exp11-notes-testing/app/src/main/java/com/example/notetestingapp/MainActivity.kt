package com.example.notetestingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MaterialTheme { Surface(Modifier.fillMaxSize()) { NoteScreen() } } }
    }
}

fun isValidNote(note: String) = note.isNotBlank()

@Composable
fun NoteScreen() {
    var note by remember { mutableStateOf("") }
    var saved by remember { mutableStateOf("") }
    var error by remember { mutableStateOf(false) }

    Column(Modifier.systemBarsPadding().padding(24.dp), Arrangement.spacedBy(16.dp)) {
        Text("Notes App", style = MaterialTheme.typography.headlineMedium)
        OutlinedTextField(
            note, { note = it; error = false },
            Modifier.fillMaxWidth().testTag("noteInput"),
            label = { Text("Enter a note") }, isError = error
        )
        Button(
            { if (isValidNote(note)) { saved = note; note = "" } else { error = true } },
            Modifier.fillMaxWidth()
        ) { Text("Add Note") }
        if (error) Text("Please enter a note", color = MaterialTheme.colorScheme.error)
        if (saved.isNotEmpty()) Text("Saved Note: $saved", Modifier.testTag("savedNote"))
    }
}
