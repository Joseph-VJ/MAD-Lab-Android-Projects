# Experiment 11 - Testing with JUnit and Compose UI tests

> **Experiment 11** - 24CS2021 Mobile Application Development using Android
>
> Test an Android app with JUnit unit tests and Jetpack Compose UI tests.

| | |
|---|---|
| Folder | `exp11-notes-testing` |
| Package / application id | `com.example.notetestingapp` |
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
2. **Open this project only:** Android Studio > **File > Open** > choose `MAD-Lab-Android-Projects/exp11-notes-testing` > **OK** > **Trust Project**.
   (Do not open the repo root - each project is separate.)
3. **Wait** for Gradle to finish (status bar at the bottom; the first sync downloads everything and needs internet).
4. **Run:** choose an emulator or your phone in the top toolbar and press the green **Run** button. Done.

---

## What you will see

```text
  EMPTY NOTE -> ERROR            VALID NOTE -> SAVED
+----------------------+      +----------------------+
| Notes App            |      | Notes App            |
| [ Enter a note    ]  |      | [ Enter a note    ]  |
| [   Add Note      ]  |      | [   Add Note      ]  |
| Please enter a note  | red  | Saved Note: Lab record
+----------------------+      +----------------------+
Unit tests: NoteValidatorTest 3 of 3 passed | UI tests: NoteScreenTest 2 of 2 passed
```

### Try it yourself

1. Run the app: tap **Add Note** with an empty box to see the red `Please enter a note`; type a note and tap **Add Note** to see `Saved Note: ...`.
2. Unit tests: right-click `NoteValidatorTest` > Run. Result: 3 of 3 passed (no emulator needed).
3. UI tests: start an emulator, right-click `NoteScreenTest` > Run. Result: 2 of 2 passed.

---

## How it works

- **Logic function** `isValidNote(note)` = `note.isNotBlank()`; it is tested with 3 JUnit tests (valid, empty, blank).
- **Compose UI tests** - `createComposeRule()` launches `NoteScreen()`, `onNodeWithTag("noteInput").performTextInput(...)` types, `onNodeWithText("Add Note").performClick()` taps, `assertIsDisplayed()` checks the result.
- **`testTag`** is how the tests find the text field and the saved-note text.
- Unit tests need **no emulator**; UI tests need an emulator or phone.

### Files in this project

| File (click to open) | What it is |
|------|-----------|
| [`MainActivity.kt`](app/src/main/java/com/example/notetestingapp/MainActivity.kt) | The app screen(s) |
| [`NoteScreenTest.kt`](app/src/androidTest/java/com/example/notetestingapp/NoteScreenTest.kt) | Compose UI test (needs an emulator or phone) |
| [`NoteValidatorTest.kt`](app/src/test/java/com/example/notetestingapp/NoteValidatorTest.kt) | JUnit unit test (runs on your computer) |

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

1. In Android Studio: **File > New > New Project > Empty Activity** (the Compose one). Set **Name** to anything, **Package name** to `com.example.notetestingapp`, **Minimum SDK** to API 24, then **Finish** and wait for Gradle.
2. Open `app/src/main/java/com/example/notetestingapp/MainActivity.kt`, select all, delete, and paste the code from [`MainActivity.kt`](app/src/main/java/com/example/notetestingapp/MainActivity.kt). Keep the first line `package com.example.notetestingapp`.
3. Create the unit test: in `app/src/test/java/com/example/notetestingapp` add `NoteValidatorTest.kt` and paste [its code](app/src/test/java/com/example/notetestingapp/NoteValidatorTest.kt).
4. Create the UI test: in `app/src/androidTest/java/com/example/notetestingapp` add `NoteScreenTest.kt` and paste [its code](app/src/androidTest/java/com/example/notetestingapp/NoteScreenTest.kt).
5. Open `app/build.gradle.kts` (Module :app) and add the lines below, then click **Sync Now**.

   Inside the existing `dependencies { }` block add:

   ```kotlin
   testImplementation("junit:junit:4.13.2")
   androidTestImplementation(platform("androidx.compose:compose-bom:2024.12.01"))
   androidTestImplementation("androidx.compose.ui:ui-test-junit4")
   androidTestImplementation("androidx.test.ext:junit:1.2.1")
   androidTestImplementation("androidx.test.espresso:espresso-core:3.7.0")
   debugImplementation("androidx.compose.ui:ui-test-manifest")
   ```

6. Pick an emulator or phone and press the green **Run** button.
7. Run the tests: right-click each test file > **Run**.

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
| Opened the wrong folder / "not a Gradle project" | Close it and open the project folder `exp11-notes-testing` itself, not the parent. |

</details>
