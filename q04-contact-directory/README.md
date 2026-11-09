# Contact Directory (reusable row + Snackbar)

**Question 4** - 24CS2021 Mobile Application Development using Android

Scrollable employee list from a data source; each row is a reusable composable; tapping a row shows the name in a Snackbar.

- Application id / package: `com.example.labapp.q04`
- Kotlin + Jetpack Compose (Material 3), Android Gradle Plugin 8.7.3, Kotlin 2.1.0, minSdk 24, compileSdk 35

## Open and run

1. Clone the repository. In Android Studio choose **File > Open** and select this folder (`q04-contact-directory`), not the repo root.
2. Wait for the Gradle sync to finish (everything downloads automatically; internet is needed the first time).
3. Pick an emulator (Device Manager > Create Device) or a phone with USB debugging and press the green **Run** button.
   Command line: `./gradlew assembleDebug` (`gradlew.bat` on Windows).

If Android Studio offers an "Android Gradle Plugin Upgrade Assistant", you can safely ignore it.

## How to use the app

1. Run the app and scroll the list.
2. Tap any row: a Snackbar with that employee's name appears at the bottom.
