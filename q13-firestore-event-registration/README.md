# Event Registration (Cloud Firestore)

> **Question 13** - 24CS2021 Mobile Application Development using Android
>
> Register participants (name, email, event dropdown) into the Firestore collection `registrations` with a server timestamp; real-time list and total count.

| | |
|---|---|
| Folder | `q13-firestore-event-registration` |
| Package / application id | `com.example.labapp.q13` |
| Extra needed | Firebase project (free) |
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
2. **Open this project only:** Android Studio > **File > Open** > choose `MAD-Lab-Android-Projects/q13-firestore-event-registration` > **OK** > **Trust Project**.
   (Do not open the repo root - each project is separate.)
3. **Wait** for Gradle to finish (status bar at the bottom; the first sync downloads everything and needs internet).
4. **Set up Firebase (once, about 5 minutes)** - this app needs your own free Firebase project. Follow [Firebase setup](#firebase-setup-needed-for-this-project) below, then sync again.
5. **Run:** choose an emulator or your phone in the top toolbar and press the green **Run** button. Done.

---

## What you will see

```text
+------------------------------+
| Total registrations: 3       |
| Name  [____________]         |
| Email [____________]         |
| Event [ Hackathon      v ]   |   <- dropdown: Hackathon / Workshop / Quiz
| [ Register ]                 |
| Asha (asha@x.com) - Quiz     |
| Ravi (ravi@x.com) - Workshop |
+------------------------------+
```

### Try it yourself

1. Do the Firebase setup first (below), with a Firestore database in **test mode**.
2. Run the app, enter name and email, pick Hackathon / Workshop / Quiz and tap **Register**.
3. The entry appears in the list and **Total registrations** goes up at once. Check Firebase console > Firestore > `registrations`.

---

## How it works

- **Firestore collection `registrations`** - each Register tap adds one document with `name`, `email`, `event` and a server `time`.
- **Real-time list + total** - `addSnapshotListener` fills `list`; the heading shows `list.size`, so the count rises the moment a document is added.
- **Dropdown** - `ExposedDropdownMenuBox` + `ExposedDropdownMenu` with the three events; the chosen event is saved in `event`.
- **Needs your Firebase project** with Firestore in test mode - see *Firebase setup* below.

### Files in this project

| File (click to open) | What it is |
|------|-----------|
| [`MainActivity.kt`](app/src/main/java/com/example/labapp/MainActivity.kt) | The app screen(s) |

---

## Firebase setup (needed for this project)

This app needs **your own free Firebase project**. The repo ships a *placeholder* `app/google-services.json`, so the project builds and opens, but until you replace it the app shows a red "Firebase is not configured" message and sign-in / database calls fail.

1. Open <https://console.firebase.google.com> > **Create a project** (you can turn Google Analytics off).
2. On the project page click the **Android icon** (*Add app*). For **Android package name** type exactly `com.example.labapp.q13` > **Register app**.
3. Click **Download google-services.json**.
4. In Android Studio switch the left panel from *Android* to **Project** view and copy that file into the `app` folder, replacing the placeholder `app/google-services.json`.
5. In the left menu: **Build > Firestore Database > Create database > Start in test mode > Enable**.
6. Android Studio: **File > Sync Project with Gradle Files**, then **Run**.

> Never push your real `google-services.json` to a public repository.

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
       id("com.google.gms.google-services")   // also add it as "apply false" in the top-level build.gradle.kts
   }
   ```

   Inside the existing `dependencies { }` block add:

   ```kotlin
   implementation(platform("com.google.firebase:firebase-bom:33.7.0"))
   implementation("com.google.firebase:firebase-firestore")
   ```

4. Open `app/src/main/AndroidManifest.xml`. Above `<application ...>`:

   ```xml
   <uses-permission android:name="android.permission.INTERNET" />
   ```
5. Do the **Firebase setup** section above (package name must match yours).
6. Pick an emulator or phone and press the green **Run** button.

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
| Opened the wrong folder / "not a Gradle project" | Close it and open the project folder `q13-firestore-event-registration` itself, not the parent. |

</details>
