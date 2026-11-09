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
import androidx.navigation.compose.*

class MainActivity : ComponentActivity() {
    override fun onCreate(b: Bundle?) {
        super.onCreate(b)
        setContent { MaterialTheme { Surface(Modifier.fillMaxSize()) { ShopApp() } } }
    }
}

data class Product(val name: String, val price: Int, val category: String)

val products = listOf(
    Product("Laptop", 55000, "Electronics"), Product("Shoes", 2500, "Fashion"),
    Product("Novel", 300, "Books"), Product("Headphones", 1800, "Electronics")
)

@Composable
fun ShopApp() {
    val nav = rememberNavController()
    NavHost(nav, "list") {
        composable("list") {
            LazyColumn(Modifier.systemBarsPadding().padding(16.dp)) {
                itemsIndexed(products) { i, p ->
                    Card(Modifier.fillMaxWidth().padding(6.dp)
                        .clickable { nav.navigate("detail/$i") }) {
                        Column(Modifier.padding(16.dp)) {
                            Text(p.name, style = MaterialTheme.typography.titleMedium)
                            Text("Rs.${p.price} | ${p.category}")
                        }
                    }
                }
            }
        }
        composable("detail/{i}") { e ->
            val p = products[e.arguments!!.getString("i")!!.toInt()]
            Column(Modifier.systemBarsPadding().padding(24.dp)) {
                Text("Product Detail", style = MaterialTheme.typography.headlineMedium)
                Text("Name: ${p.name}")
                Text("Price: Rs.${p.price}")
                Text("Category: ${p.category}")
            }
        }
    }
}
