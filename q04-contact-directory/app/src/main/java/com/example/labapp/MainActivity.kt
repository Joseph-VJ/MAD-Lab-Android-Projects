package com.example.labapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.*
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(b: Bundle?) {
        super.onCreate(b)
        setContent { MaterialTheme { Surface(Modifier.fillMaxSize()) { Directory() } } }
    }
}

data class Emp(val name: String, val role: String, val phone: String)

val emps = listOf(
    Emp("Arun Kumar", "Android Developer", "98400 11111"),
    Emp("Meena S", "UI Designer", "98400 22222"),
    Emp("Ravi P", "Tester", "98400 33333"),
    Emp("Divya R", "Project Manager", "98400 44444")
)

@Composable
fun EmpRow(e: Emp, onClick: () -> Unit) {
    Card(Modifier.fillMaxWidth().padding(6.dp).clickable(onClick = onClick)) {
        Column(Modifier.padding(16.dp)) {
            Text(e.name, style = MaterialTheme.typography.titleMedium)
            Text("${e.role} | ${e.phone}")
        }
    }
}

@Composable
fun Directory() {
    val snack = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(snackbarHost = { SnackbarHost(snack) }) { pad ->
        LazyColumn(Modifier.padding(pad)) {
            items(emps) { e -> EmpRow(e) { scope.launch { snack.showSnackbar(e.name) } } }
        }
    }
}
