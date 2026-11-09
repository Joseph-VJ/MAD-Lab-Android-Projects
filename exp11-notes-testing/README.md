# Experiment 11 - Testing with JUnit and Compose UI tests

**Experiment 11** - 24CS2021 Mobile Application Development using Android

Test an Android app with JUnit unit tests and Jetpack Compose UI tests.

- Application id / package: `com.example.notetestingapp`
- Kotlin + Jetpack Compose (Material 3), Android Gradle Plugin 8.7.3, Kotlin 2.1.0, minSdk 24, compileSdk 35

## Open and run

1. Clone the repository. In Android Studio choose **File > Open** and select this folder (`exp11-notes-testing`), not the repo root.
2. Wait for the Gradle sync to finish (everything downloads automatically; internet is needed the first time).
3. Pick an emulator (Device Manager > Create Device) or a phone with USB debugging and press the green **Run** button.
   Command line: `./gradlew assembleDebug` (`gradlew.bat` on Windows).

If Android Studio offers an "Android Gradle Plugin Upgrade Assistant", you can safely ignore it.

## Tests

| Kind | Location | How to run |
|------|----------|-----------|
| JUnit unit tests | `app/src/test/java` | `./gradlew testDebugUnitTest` (no emulator needed) |
| Compose UI tests | `app/src/androidTest/java` | start an emulator, then `./gradlew connectedDebugAndroidTest` |

## How to use the app

1. Run the app: tap **Add Note** with an empty box to see the red `Please enter a note`; type a note and tap **Add Note** to see `Saved Note: ...`.
2. Unit tests: right-click `NoteValidatorTest` > Run. Result: 3 of 3 passed (no emulator needed).
3. UI tests: start an emulator, right-click `NoteScreenTest` > Run. Result: 2 of 2 passed.
