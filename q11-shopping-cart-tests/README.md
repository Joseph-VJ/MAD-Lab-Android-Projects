# Shopping Cart (JUnit + Compose UI tests)

> **Question 11** - 24CS2021 Mobile Application Development using Android
>
> Cart with +/- quantity buttons (never below 0), subtotal, discount code SAVE10 (10% off, anything else is Invalid code), logic in a separate class, JUnit + Compose UI tests, and a deliberate bug fixed.

| | |
|---|---|
| Folder | `q11-shopping-cart-tests` |
| Package / application id | `com.example.labapp.q11` |
| Extra needed | Nothing extra |
| Tests | Unit tests: no. UI tests: emulator or phone |
| Built with | Kotlin, Jetpack Compose (Material 3), AGP 8.7.3, Kotlin 2.1.0, minSdk 24 |

---

## Quick start (about 5 minutes)

> Already have **Git** and **Android Studio**? Do the steps below.
> First time on this computer? Open [First-time setup](#first-time-setup-on-a-new-computer) first (one time only).

1. **Clone** the repo (it is private, so sign in to GitHub when asked):
   ```bash
   git clone https://github.com/Joseph-VJ/MAD-Lab-Android-Projects.git
   ```
2. **Open this project only:** Android Studio > **File > Open** > choose `MAD-Lab-Android-Projects/q11-shopping-cart-tests` > **OK** > **Trust Project**.
   (Do not open the repo root - each project is separate.)
3. **Wait** for Gradle to finish (status bar at the bottom; the first sync downloads everything and needs internet).
4. **Run:** choose an emulator or your phone in the top toolbar and press the green **Run** button. Done.

---

## What you will see

```text
+------------------------------+
| Shirt Rs.500    [-] 2 [+]    |
| Shoes Rs.1500   [-] 1 [+]    |
| Cap Rs.200      [-] 0 [+]    |
| Subtotal: Rs.2500            |
| Discount code [ SAVE10 ]     |
| Total: Rs.2250               |   <- other codes show "Invalid code"
+------------------------------+
Unit tests:  PricingLogicTest  4 of 4 passed
UI tests:    CartScreenTest    3 of 3 passed  (needs emulator)
```

### Try it yourself

1. Run the app: tap + on Shirt twice and Shoes once (Subtotal Rs.2500). Enter `SAVE10`: Total Rs.2250. Any other code: `Invalid code`. The - button stops at 0.
2. Unit tests: right-click `PricingLogicTest` > Run (or `./gradlew testDebugUnitTest`).
3. UI test: start an emulator, right-click `CartScreenTest` > Run (or `./gradlew connectedDebugAndroidTest`).
4. Bug demo: change `decrement` to `q - 1`: `quantityNeverBelowZero` fails (expected 0 but was -1). Change it back to `if (q > 0) q - 1 else 0`: all pass.

---

## How it works

- **Logic in `PricingLogic`** - `subtotal`, `decrement` (never below 0), `isValid` (only `SAVE10`) and `total` (10% off).
- **State** - `mutableStateListOf(0, 0, 0)` keeps the three quantities; changing one re-draws the screen and the subtotal.
- **JUnit tests** check each rule; **Compose UI tests** click `+`/`-` and type a code, then assert the text on screen.
- **The deliberate bug**: in `PricingLogic.kt` change `decrement` to `fun decrement(q: Int) = q - 1` -> run `PricingLogicTest` -> `quantityNeverBelowZero` fails (`expected 0 but was -1`) -> restore `if (q > 0) q - 1 else 0` -> all pass.

### Files in this project

| File (click to open) | What it is |
|------|-----------|
| [`MainActivity.kt`](app/src/main/java/com/example/labapp/MainActivity.kt) | The app screen(s) |
| [`CartScreenTest.kt`](app/src/androidTest/java/com/example/labapp/CartScreenTest.kt) | Compose UI test (needs an emulator or phone) |
| [`PricingLogic.kt`](app/src/main/java/com/example/labapp/PricingLogic.kt) | Logic class used by the screen |
| [`PricingLogicTest.kt`](app/src/test/java/com/example/labapp/PricingLogicTest.kt) | JUnit unit test (runs on your computer) |

---

## Run the tests

| Kind | Where | How to run |
|------|-------|-----------|
| **JUnit unit tests** | `app/src/test/java` | Right-click the test file > **Run**. Or `./gradlew testDebugUnitTest`. No emulator needed. |
| **Compose UI tests** | `app/src/androidTest/java` | Start an emulator (or plug in a phone), right-click the test file > **Run**. Or `./gradlew connectedDebugAndroidTest`. |

Results show in the **Run** panel at the bottom: green ticks = passed, red = failed.

---

## Build it yourself from scratch (for your lab record)

<details>
<summary><b>Click to open - step by step</b></summary>

Use this if you must create the project by hand in Android Studio instead of opening the ready-made one.

1. In Android Studio: **File > New > New Project > Empty Activity** (the Compose one). Set **Name** to anything, **Package name** to `com.example.labapp`, **Minimum SDK** to API 24, then **Finish** and wait for Gradle.
2. Open `app/src/main/java/com/example/labapp/MainActivity.kt`, select all, delete, and paste the code from [`MainActivity.kt`](app/src/main/java/com/example/labapp/MainActivity.kt). Keep the first line `package com.example.labapp`.
3. Right-click the package folder > **New > Kotlin Class/File**, name it `PricingLogic`, and paste [its code](app/src/main/java/com/example/labapp/PricingLogic.kt).
4. Create the unit test: in `app/src/test/java/com/example/labapp` add `PricingLogicTest.kt` and paste [its code](app/src/test/java/com/example/labapp/PricingLogicTest.kt).
5. Create the UI test: in `app/src/androidTest/java/com/example/labapp` add `CartScreenTest.kt` and paste [its code](app/src/androidTest/java/com/example/labapp/CartScreenTest.kt).
6. Open `app/build.gradle.kts` (Module :app) and add the lines below, then click **Sync Now**.

   Inside the existing `dependencies { }` block add:

   ```kotlin
   testImplementation("junit:junit:4.13.2")
   androidTestImplementation(platform("androidx.compose:compose-bom:2024.12.01"))
   androidTestImplementation("androidx.compose.ui:ui-test-junit4")
   androidTestImplementation("androidx.test.ext:junit:1.2.1")
   androidTestImplementation("androidx.test.espresso:espresso-core:3.7.0")
   debugImplementation("androidx.compose.ui:ui-test-manifest")
   ```

7. Pick an emulator or phone and press the green **Run** button.
8. Run the tests: right-click each test file > **Run**.

</details>

---

## First-time setup on a new computer

<details>
<summary><b>Click to open - install everything (one time)</b></summary>

| # | What | How |
|---|------|-----|
| 1 | **Git** | Download from <https://git-scm.com/downloads> and install with the default options. |
| 2 | **Android Studio** (latest stable) | Download from <https://developer.android.com/studio>, install, open it, and finish the *first-run wizard* (it installs the Android SDK). The JDK is included. |
| 3 | **Android 15 (API 35) SDK** | Android Studio > **More Actions > SDK Manager > SDK Platforms** > tick **Android 15.0 (API 35)** > **Apply**. |
| 4 | **GitHub sign-in** (repo is private) | Run `gh auth login` (GitHub CLI), or just sign in when the browser window opens on your first `git clone`. |
| 5 | **A device to run on** | **Emulator:** Android Studio > **Tools > Device Manager > Create Device** > Pixel > system image API 34 or newer > Finish. **Phone:** Settings > About phone > tap *Build number* 7 times > Developer options > turn on *USB debugging*, connect by USB and tap *Allow*. |

Prefer the command line? From inside this folder (device running; use `gradlew.bat` on Windows): `./gradlew installDebug`

</details>

---

## Troubleshooting

<details>
<summary><b>Something went wrong? Click here</b></summary>

| Problem | Fix |
|---------|-----|
| `SDK location not found` | Android Studio creates `local.properties` by itself when you open the project folder. For command-line builds set `ANDROID_HOME`, or create `local.properties` with `sdk.dir=C:/Users/YOU/AppData/Local/Android/Sdk`. |
| `Failed to find Build Tools` or platform 35 missing | SDK Manager > SDK Platforms > Android 15.0 (API 35) > Apply. |
| JDK / `Unsupported class file major version` | **File > Settings > Build, Execution, Deployment > Build Tools > Gradle > Gradle JDK** > pick the bundled *jbr-17* (or newer). |
| Sync cannot download anything | Check internet/proxy, then **File > Sync Project with Gradle Files**. |
| "Android Gradle Plugin Upgrade Assistant" popup | Ignore it (**Remind me later**). The project works as it is. |
| Emulator will not start | Turn on virtualization in the BIOS; on Windows enable *Windows Hypervisor Platform*; or use a real phone. |
| `Permission denied: ./gradlew` (Linux/macOS) | `chmod +x gradlew` |
| Clone asks for a password and fails | Passwords no longer work on GitHub. Run `gh auth login` or sign in through the browser prompt. |
| Opened the wrong folder / "not a Gradle project" | Close it and open the project folder `q11-shopping-cart-tests` itself, not the parent. |

</details>
