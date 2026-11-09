# Reading List (Room + DataStore)

> **Question 7** - 24CS2021 Mobile Application Development using Android
>
> Save books in a Room database, delete with an icon, and switch between Title A-Z / Newest First with a Switch whose state is stored in DataStore.

| | |
|---|---|
| Folder | `q07-reading-list-room-datastore` |
| Package / application id | `com.example.labapp.q07` |
| Extra needed | Nothing extra |
| Tests | No tests in this project |
| Built with | Kotlin, Jetpack Compose (Material 3), AGP 8.7.3, Kotlin 2.1.0, minSdk 24 |

---

## Quick start (about 5 minutes)

> Already have **Git** and **Android Studio**? Do the steps below.
> First time on this computer? Open [First-time setup](#first-time-setup-on-a-new-computer) first (one time only).

1. **Clone** the repo (it is private, so sign in to GitHub when asked):
   ```bash
   git clone https://github.com/Joseph-VJ/MAD-Lab-Android-Projects.git
   ```
2. **Open this project only:** Android Studio > **File > Open** > choose `MAD-Lab-Android-Projects/q07-reading-list-room-datastore` > **OK** > **Trust Project**.
   (Do not open the repo root - each project is separate.)
3. **Wait** for Gradle to finish (status bar at the bottom; the first sync downloads everything and needs internet).
4. **Run:** choose an emulator or your phone in the top toolbar and press the green **Run** button. Done.

---

## What you will see

```text
+------------------------------+
| Title  [____________]        |
| Author [____________]        |
| [ Save Book ]                |
| Title A-Z  (o--)  <- Switch  |
|                              |
| Atomic Habits - James Clear [bin]
| Dune - Frank Herbert        [bin]
| Wings of Fire - APJ Kalam   [bin]
+------------------------------+
  Switch ON  = "Title A-Z"      Switch OFF = "Newest First"
```

### Try it yourself

1. Run the app, type a title and author, tap **Save Book** (add 3 books).
2. Use the switch to change between Title A-Z and Newest First. Tap the bin icon to delete a book.
3. Swipe the app away and reopen it: the list opens in the order you chose last time (stored in DataStore).

---

## How it works

- **Room** (SQLite made easy): `@Entity Book` is the table, `@Dao BookDao` has the queries, `@Database Db` ties them together.
- **Two orderings** - `byTitle()` uses `ORDER BY title COLLATE NOCASE`; `newest()` uses `ORDER BY id DESC`. Both return a `Flow`, so the list updates by itself when data changes.
- **Insert / delete** - `@Insert add(...)` and `@Delete del(...)` are `suspend` functions, launched inside a coroutine.
- **DataStore Preferences** - stores the switch value under `booleanPreferencesKey("az")`. It survives closing the app, so the list opens in the same order next time.
- **KSP** - the build uses the KSP plugin to generate Room's code (`ksp("androidx.room:room-compiler")`).

### Files in this project

| File (click to open) | What it is |
|------|-----------|
| [`MainActivity.kt`](app/src/main/java/com/example/labapp/MainActivity.kt) | The app screen(s) |

---

## Build it yourself from scratch (for your lab record)

<details>
<summary><b>Click to open - step by step</b></summary>

Use this if you must create the project by hand in Android Studio instead of opening the ready-made one.

1. In Android Studio: **File > New > New Project > Empty Activity** (the Compose one). Set **Name** to anything, **Package name** to `com.example.labapp`, **Minimum SDK** to API 24, then **Finish** and wait for Gradle.
2. Open `app/src/main/java/com/example/labapp/MainActivity.kt`, select all, delete, and paste the code from [`MainActivity.kt`](app/src/main/java/com/example/labapp/MainActivity.kt). Keep the first line `package com.example.labapp`.
3. Open `app/build.gradle.kts` (Module :app) and add the lines below, then click **Sync Now**.

   ```kotlin
   plugins {
       id("com.google.devtools.ksp") version "2.1.0-1.0.29"   // must match your Kotlin version
   }
   ```

   Inside the existing `dependencies { }` block add:

   ```kotlin
   implementation("androidx.room:room-runtime:2.6.1")
   implementation("androidx.room:room-ktx:2.6.1")
   ksp("androidx.room:room-compiler:2.6.1")
   implementation("androidx.datastore:datastore-preferences:1.1.1")
   ```

4. Pick an emulator or phone and press the green **Run** button.

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
| Opened the wrong folder / "not a Gradle project" | Close it and open the project folder `q07-reading-list-room-datastore` itself, not the parent. |

</details>
