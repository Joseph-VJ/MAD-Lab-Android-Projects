# Tip Calculator (JUnit + Compose UI tests)

**Question 10** - 24CS2021 Mobile Application Development using Android

Tip calculator with the logic in a separate class, JUnit unit tests, a Compose UI test, and a deliberate bug found by a failing test and fixed.

- Application id / package: `com.example.labapp.q10`
- Kotlin + Jetpack Compose (Material 3), Android Gradle Plugin 8.7.3, Kotlin 2.1.0, minSdk 24, compileSdk 35

## Open and run

1. Clone the repository. In Android Studio choose **File > Open** and select this folder (`q10-tip-calculator-tests`), not the repo root.
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

1. Run the app: type 200, tap 20%: Tip 40.00 and Total 240.00.
2. Unit tests: right-click `TipCalculatorTest` > Run (or `./gradlew testDebugUnitTest`).
3. UI test: start an emulator, right-click `TipScreenTest` > Run (or `./gradlew connectedDebugAndroidTest`).
4. Bug demo: change the tip line to `bill * percent / 10` and run `TipCalculatorTest`: all 3 tests fail (expected 20.0 but was 200.0). Change it back to `/ 100`: all pass.
