package com.example.firebaseauthapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.Firebase
import com.google.firebase.app
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.auth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MaterialTheme { Surface(Modifier.fillMaxSize()) { LoginScreen() } } }
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
fun LoginScreen() {
    val auth = remember { Firebase.auth }
    var email by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var user by remember { mutableStateOf(auth.currentUser) }
    var msg by remember { mutableStateOf("") }

    val done = OnCompleteListener<AuthResult> { task ->
        user = auth.currentUser
        msg = if (task.isSuccessful) "Success" else "Failed. Check credentials."
    }

    Column(Modifier.systemBarsPadding().padding(24.dp), Arrangement.spacedBy(12.dp)) {
        ConfigBanner()
        if (user != null) {
            Text("Welcome! You are signed in.")
            Button({ auth.signOut(); user = null; msg = "Signed out" }) { Text("Sign Out") }
        } else {
            OutlinedTextField(email, { email = it }, label = { Text("Email") })
            OutlinedTextField(pass, { pass = it }, label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation())
            Button({
                auth.signInWithEmailAndPassword(email.trim(), pass).addOnCompleteListener(done)
            }) { Text("Login") }
            Button({
                auth.createUserWithEmailAndPassword(email.trim(), pass).addOnCompleteListener(done)
            }) { Text("Register") }
        }
        Text(msg)
    }
}
