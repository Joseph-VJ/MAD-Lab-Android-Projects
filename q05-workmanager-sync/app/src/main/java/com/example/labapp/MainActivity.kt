package com.example.labapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import android.content.Context
import android.util.Log
import androidx.compose.ui.platform.LocalContext
import androidx.work.*
import java.util.Date
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {
    override fun onCreate(b: Bundle?) {
        super.onCreate(b)
        setContent { MaterialTheme { Surface(Modifier.fillMaxSize()) { SyncScreen() } } }
    }
}

class SyncWorker(c: Context, p: WorkerParameters) : Worker(c, p) {
    override fun doWork(): Result {
        Log.d("SyncWorker", "Synced at ${Date()}")
        return Result.success()
    }
}

@Composable
fun SyncScreen() {
    val wm = WorkManager.getInstance(LocalContext.current)
    val infos by wm.getWorkInfosForUniqueWorkFlow("sync").collectAsState(emptyList())
    val status = infos.firstOrNull()?.state ?: "Not started"
    Column(Modifier.systemBarsPadding().padding(24.dp), Arrangement.spacedBy(12.dp)) {
        Text("Status: $status", style = MaterialTheme.typography.titleLarge)
        Button({
            wm.enqueueUniquePeriodicWork("sync", ExistingPeriodicWorkPolicy.KEEP,
                PeriodicWorkRequestBuilder<SyncWorker>(15, TimeUnit.MINUTES).build())
        }) { Text("Start Sync") }
        Button({ wm.cancelUniqueWork("sync") }) { Text("Cancel Sync") }
    }
}
