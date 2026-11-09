# Background Sync (WorkManager periodic work)

**Question 5** - 24CS2021 Mobile Application Development using Android

Periodic WorkManager task (15 min) that logs the time, with Start/Cancel buttons and live status.

- Application id / package: `com.example.labapp.q05`
- Kotlin + Jetpack Compose (Material 3), Android Gradle Plugin 8.7.3, Kotlin 2.1.0, minSdk 24, compileSdk 35

## Open and run

1. Clone the repository. In Android Studio choose **File > Open** and select this folder (`q05-workmanager-sync`), not the repo root.
2. Wait for the Gradle sync to finish (everything downloads automatically; internet is needed the first time).
3. Pick an emulator (Device Manager > Create Device) or a phone with USB debugging and press the green **Run** button.
   Command line: `./gradlew assembleDebug` (`gradlew.bat` on Windows).

If Android Studio offers an "Android Gradle Plugin Upgrade Assistant", you can safely ignore it.

## How to use the app

1. Run the app and tap **Start Sync**: Status shows ENQUEUED (briefly RUNNING).
2. Open Logcat and filter by `SyncWorker`: you see `Synced at ...` now and then roughly every 15 minutes.
3. Tap **Cancel Sync**: Status changes to CANCELLED. (Keep the app installed for the periodic log lines.)
