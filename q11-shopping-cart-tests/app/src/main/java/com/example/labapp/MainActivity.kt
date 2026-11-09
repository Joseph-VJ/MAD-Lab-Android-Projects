package com.example.labapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.testTag

class MainActivity : ComponentActivity() {
    override fun onCreate(b: Bundle?) {
        super.onCreate(b)
        setContent { MaterialTheme { Surface(Modifier.fillMaxSize()) { CartScreen() } } }
    }
}

@Composable
fun CartScreen() {
    val logic = remember { PricingLogic() }
    val names = listOf("Shirt", "Shoes", "Cap")
    val prices = listOf(500, 1500, 200)
    val qty = remember { mutableStateListOf(0, 0, 0) }
    var code by remember { mutableStateOf("") }
    val sub = logic.subtotal(prices, qty)

    Column(Modifier.systemBarsPadding().padding(16.dp)) {
        names.indices.forEach { i ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("${names[i]} Rs.${prices[i]}", Modifier.weight(1f))
                Button({ qty[i] = logic.decrement(qty[i]) }) { Text("-") }
                Text("${qty[i]}", Modifier.padding(8.dp).testTag("qty$i"))
                Button({ qty[i] = qty[i] + 1 }) { Text("+") }
            }
        }
        Text("Subtotal: Rs.$sub", Modifier.testTag("sub"))
        OutlinedTextField(code, { code = it }, Modifier.testTag("code"),
            label = { Text("Discount code") })
        if (code.isNotEmpty())
            Text(if (logic.isValid(code)) "Total: Rs.${logic.total(sub, code)}"
            else "Invalid code")
    }
}
