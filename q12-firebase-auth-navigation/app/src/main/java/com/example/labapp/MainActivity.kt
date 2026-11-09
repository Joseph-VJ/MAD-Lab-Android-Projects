package com.example.labapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.navigation.compose.*
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.Firebase
import com.google.firebase.app
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.auth

class MainActivity : ComponentActivity() {
    override fun onCreate(b: Bundle?) {
        super.onCreate(b)
        setContent { MaterialTheme { Surface(Modifier.fillMaxSize()) { AuthApp() } } }
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
fun AuthApp() {
    val auth = remember { Firebase.auth }
    val nav = rememberNavController()
    NavHost(nav, if (auth.currentUser != null) "home" else "login") {
        composable("login") {
            LoginScreen { nav.navigate("home") { popUpTo("login") { inclusive = true } } }
        }
        composable("home") {
            val user = auth.currentUser
            if (user == null) {
                LaunchedEffect(Unit) {
                    nav.navigate("login") { popUpTo("home") { inclusive = true } }
                }
            } else {
                Column(Modifier.systemBarsPadding().padding(24.dp), Arrangement.spacedBy(12.dp)) {
                    Text("Home", style = MaterialTheme.typography.headlineMedium)
                    Text("Logged in as: ${user.email}")
                    Button({
                        auth.signOut()
                        nav.navigate("login") { popUpTo("home") { inclusive = true } }
                    }) { Text("Logout") }
                }
            }
        }
    }
}

@Composable
fun LoginScreen(onSuccess: () -> Unit) {
    val auth = remember { Firebase.auth }
    var email by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var msg by remember { mutableStateOf("") }
    val done = OnCompleteListener<AuthResult> {
        if (it.isSuccessful) onSuccess() else { msg = "Failed. Check credentials." }
    }
    Column(Modifier.systemBarsPadding().padding(24.dp), Arrangement.spacedBy(12.dp)) {
        ConfigBanner()
        OutlinedTextField(email, { email = it }, label = { Text("Email") })
        OutlinedTextField(pass, { pass = it }, label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation())
        Button({
            auth.signInWithEmailAndPassword(email.trim(), pass).addOnCompleteListener(done)
        }) { Text("Login") }
        Button({
            auth.createUserWithEmailAndPassword(email.trim(), pass).addOnCompleteListener(done)
        }) { Text("Register") }
        Text(msg)
    }
}
