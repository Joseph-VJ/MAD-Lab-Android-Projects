# Food Ordering (Explicit Intents + Animations)

> **Question 1** - 24CS2021 Mobile Application Development using Android
>
> Activity interaction with explicit Intents, data passing between Activities, and UI animations.

| | |
|---|---|
| Folder | `q01-food-ordering` |
| Package / application id | `com.example.labapp.q01` |
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
2. **Open this project only:** Android Studio > **File > Open** > choose `MAD-Lab-Android-Projects/q01-food-ordering` > **OK** > **Trust Project**.
   (Do not open the repo root - each project is separate.)
3. **Wait** for Gradle to finish (status bar at the bottom; the first sync downloads everything and needs internet).
4. **Run:** choose an emulator or your phone in the top toolbar and press the green **Run** button. Done.

---

## What you will see

```text
  MENU SCREEN                 AFTER TAPPING A CARD        ORDER SUMMARY SCREEN
+----------------------+    +----------------------+    +----------------------+
| Pizza - Rs.250       |    | Pizza - Rs.250       |    | Order Summary        |
| Burger - Rs.120      |    | +------------------+ |    | +------------------+ |
| Pasta - Rs.180       | -> | |  [ Order Now ]   | | -> | | Pizza - Rs.250   | |
| Biryani - Rs.220     |    | +------------------+ |    | | Thank you for    | |
|                      |    | Burger - Rs.120      |    | | ordering!        | |
+----------------------+    +----------------------+    +----------------------+
 (card grows with animation)                             (card fades + slides in)
```

### Try it yourself

1. Run the app. Tap a food card: it expands with an animation.
2. Tap **Order Now**: the Order Summary screen opens with the item and price (animated entry).

---

## How it works

- **Explicit Intent** - `Intent(this, SummaryActivity::class.java)` names the exact Activity to open.
- **Passing data** - `putExtra("item", ...)` on the sender, `intent.getStringExtra("item")` / `getIntExtra` on the receiver.
- **Manifest** - every Activity must be declared in `AndroidManifest.xml` (`SummaryActivity` is). Forgetting this crashes the app when you tap *Order Now*.
- **Animation 1** - `Modifier.animateContentSize()` smoothly grows the card when it expands to show *Order Now*.
- **Animation 2** - `AnimatedVisibility(show, enter = fadeIn() + slideInVertically())` animates the summary card in; `LaunchedEffect(Unit) { show = true }` triggers it once on open.

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
3. Open `app/src/main/AndroidManifest.xml`. Inside `<application ...>`:

   ```xml
   <activity android:name=".SummaryActivity" />
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
| Opened the wrong folder / "not a Gradle project" | Close it and open the project folder `q01-food-ordering` itself, not the parent. |

</details>
