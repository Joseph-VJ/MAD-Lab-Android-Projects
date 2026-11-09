package com.example.labapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.testTag

class MainActivity : ComponentActivity() {
    override fun onCreate(b: Bundle?) {
        super.onCreate(b)
        setContent { MaterialTheme { Surface(Modifier.fillMaxSize()) { TipScreen() } } }
    }
}

@Composable
fun TipScreen() {
    val calc = remember { TipCalculator() }
    var bill by remember { mutableStateOf("") }
    var pct by remember { mutableStateOf(10) }
    val b = bill.toDoubleOrNull() ?: 0.0

    Column(Modifier.systemBarsPadding().padding(24.dp), Arrangement.spacedBy(8.dp)) {
        OutlinedTextField(bill, { bill = it }, Modifier.testTag("bill"),
            label = { Text("Bill amount") })
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf(10, 15, 20).forEach { p -> Button({ pct = p }) { Text("$p%") } }
        }
        Text("Tip: ${"%.2f".format(calc.tip(b, pct))}", Modifier.testTag("tip"))
        Text("Total: ${"%.2f".format(calc.total(b, pct))}", Modifier.testTag("total"))
    }
}
