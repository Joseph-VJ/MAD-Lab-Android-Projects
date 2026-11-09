# Announcement Feed (multiple item types)

**Question 2** - 24CS2021 Mobile Application Development using Android

A LazyColumn feed built from a data source, with a different composable per announcement type (notice, urgent alert, image, action).

- Application id / package: `com.example.labapp.q02`
- Kotlin + Jetpack Compose (Material 3), Android Gradle Plugin 8.7.3, Kotlin 2.1.0, minSdk 24, compileSdk 35

## Open and run

1. Clone the repository. In Android Studio choose **File > Open** and select this folder (`q02-announcement-feed`), not the repo root.
2. Wait for the Gradle sync to finish (everything downloads automatically; internet is needed the first time).
3. Pick an emulator (Device Manager > Create Device) or a phone with USB debugging and press the green **Run** button.
   Command line: `./gradlew assembleDebug` (`gradlew.bat` on Windows).

If Android Studio offers an "Android Gradle Plugin Upgrade Assistant", you can safely ignore it.

## How to use the app

1. Run the app. The feed shows a notice, a red URGENT alert, an image item and an item with a Submit button.
2. Add more announcements by adding items to the `feed` list.
