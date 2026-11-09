# Shopping Cart (JUnit + Compose UI tests)

**Question 11** - 24CS2021 Mobile Application Development using Android

Cart with +/- quantity buttons (never below 0), subtotal, discount code SAVE10 (10% off, anything else is Invalid code), logic in a separate class, JUnit + Compose UI tests, and a deliberate bug fixed.

- Application id / package: `com.example.labapp.q11`
- Kotlin + Jetpack Compose (Material 3), Android Gradle Plugin 8.7.3, Kotlin 2.1.0, minSdk 24, compileSdk 35

## Open and run

1. Clone the repository. In Android Studio choose **File > Open** and select this folder (`q11-shopping-cart-tests`), not the repo root.
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

1. Run the app: tap + on Shirt twice and Shoes once (Subtotal Rs.2500). Enter `SAVE10`: Total Rs.2250. Any other code: `Invalid code`. The - button stops at 0.
2. Unit tests: right-click `PricingLogicTest` > Run (or `./gradlew testDebugUnitTest`).
3. UI test: start an emulator, right-click `CartScreenTest` > Run (or `./gradlew connectedDebugAndroidTest`).
4. Bug demo: change `decrement` to `q - 1`: `quantityNeverBelowZero` fails (expected 0 but was -1). Change it back to `if (q > 0) q - 1 else 0`: all pass.
