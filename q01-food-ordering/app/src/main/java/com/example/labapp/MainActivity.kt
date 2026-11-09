package com.example.labapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(b: Bundle?) {
        super.onCreate(b)
        setContent { MaterialTheme { Menu { item, price ->
            startActivity(Intent(this, SummaryActivity::class.java)
                .putExtra("item", item).putExtra("price", price))
        }}}
    }
}

class SummaryActivity : ComponentActivity() {
    override fun onCreate(b: Bundle?) {
        super.onCreate(b)
        val item = intent.getStringExtra("item")
        val price = intent.getIntExtra("price", 0)
        setContent { MaterialTheme {
            var show by remember { mutableStateOf(false) }
            LaunchedEffect(Unit) { show = true }
            Column(Modifier.systemBarsPadding().padding(24.dp)) {
                Text("Order Summary", style = MaterialTheme.typography.headlineMedium)
                AnimatedVisibility(show, enter = fadeIn() + slideInVertically()) {
                    Card(Modifier.fillMaxWidth().padding(top = 16.dp)) {
                        Text("$item - Rs.$price\nThank you for ordering!", Modifier.padding(16.dp))
                    }
                }
            }
        }}
    }
}

@Composable
fun Menu(onOrder: (String, Int) -> Unit) {
    val menu = listOf("Pizza" to 250, "Burger" to 120, "Pasta" to 180, "Biryani" to 220)
    LazyColumn(Modifier.systemBarsPadding().padding(16.dp)) {
        items(menu) { (name, price) ->
            var open by remember { mutableStateOf(false) }
            Card(Modifier.fillMaxWidth().padding(6.dp).animateContentSize()
                .clickable { open = !open }) {
                Column(Modifier.padding(16.dp)) {
                    Text("$name - Rs.$price")
                    if (open) Button({ onOrder(name, price) }) { Text("Order Now") }
                }
            }
        }
    }
}
