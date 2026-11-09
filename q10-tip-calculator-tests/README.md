# Tip Calculator (JUnit + Compose UI tests)

> **Question 10** - 24CS2021 Mobile Application Development using Android
>
> Tip calculator with the logic in a separate class, JUnit unit tests, a Compose UI test, and a deliberate bug found by a failing test and fixed.

| | |
|---|---|
| Folder | `q10-tip-calculator-tests` |
| Package / application id | `com.example.labapp.q10` |
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
2. **Open this project only:** Android Studio > **File > Open** > choose `MAD-Lab-Android-Projects/q10-tip-calculator-tests` > **OK** > **Trust Project**.
   (Do not open the repo root - each project is separate.)
3. **Wait** for Gradle to finish (status bar at the bottom; the first sync downloads everything and needs internet).
4. **Run:** choose an emulator or your phone in the top toolbar and press the green **Run** button. Done.

---

## What you will see

```text
+------------------------------+
| Bill amount [ 200 ]          |
| [10%] [15%] [20%]            |
| Tip: 40.00                   |   <- after tapping 20%
| Total: 240.00                |
+------------------------------+
Unit tests:  TipCalculatorTest  3 of 3 passed  (green)
UI test:     TipScreenTest      1 of 1 passed  (needs emulator)
```

### Try it yourself

1. Run the app: type 200, tap 20%: Tip 40.00 and Total 240.00.
2. Unit tests: right-click `TipCalculatorTest` > Run (or `./gradlew testDebugUnitTest`).
3. UI test: start an emulator, right-click `TipScreenTest` > Run (or `./gradlew connectedDebugAndroidTest`).
4. Bug demo: change the tip line to `bill * percent / 10` and run `TipCalculatorTest`: all 3 tests fail (expected 20.0 but was 200.0). Change it back to `/ 100`: all pass.

---

## How it works

- **Logic in its own class** - `TipCalculator` has `tip()` and `total()`; the screen just calls it. This makes the maths easy to unit-test without any UI.
- **JUnit unit tests** (`TipCalculatorTest`, in `src/test`) run on your computer in seconds - no emulator.
- **Compose UI test** (`TipScreenTest`, in `src/androidTest`) types 200, taps *20%* and checks the text `Tip: 40.00` / `Total: 240.00`. `testTag("bill")` lets the test find the field.
- **The deliberate bug** (required by the question): in `TipCalculator.kt` change `bill * percent / 100` to `bill * percent / 10` -> run `TipCalculatorTest` -> all 3 tests turn **red** (`expected 20.0 but was 200.0`) -> change it back to `/ 100` -> all **green**. The git history of this repo shows exactly that (`git log --oneline`).

### Files in this project

| File (click to open) | What it is |
|------|-----------|
| [`MainActivity.kt`](app/src/main/java/com/example/labapp/MainActivity.kt) | The app screen(s) |
| [`TipCalculator.kt`](app/src/main/java/com/example/labapp/TipCalculator.kt) | Logic class used by the screen |
| [`TipCalculatorTest.kt`](app/src/test/java/com/example/labapp/TipCalculatorTest.kt) | JUnit unit test (runs on your computer) |
| [`TipScreenTest.kt`](app/src/androidTest/java/com/example/labapp/TipScreenTest.kt) | Compose UI test (needs an emulator or phone) |

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
3. Right-click the package folder > **New > Kotlin Class/File**, name it `TipCalculator`, and paste [its code](app/src/main/java/com/example/labapp/TipCalculator.kt).
4. Create the unit test: in `app/src/test/java/com/example/labapp` add `TipCalculatorTest.kt` and paste [its code](app/src/test/java/com/example/labapp/TipCalculatorTest.kt).
5. Create the UI test: in `app/src/androidTest/java/com/example/labapp` add `TipScreenTest.kt` and paste [its code](app/src/androidTest/java/com/example/labapp/TipScreenTest.kt).
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
| Opened the wrong folder / "not a Gradle project" | Close it and open the project folder `q10-tip-calculator-tests` itself, not the parent. |

</details>
