# Feedback Collector (Cloud Firestore)

**Question 9** - 24CS2021 Mobile Application Development using Android

Submit feedback to the Firestore collection `feedback` with a server timestamp and show all feedback in a real-time list.

- Folder: `q09-firestore-feedback`  |  Application id / package: `com.example.labapp.q09`
- Kotlin + Jetpack Compose (Material 3), Android Gradle Plugin 8.7.3, Kotlin 2.1.0, minSdk 24, compileSdk 35

---

## Run this project on a new computer (complete steps)

### 0. One-time installs (skip what you already have)

| Tool | Where to get it |
|------|-----------------|
| **Git** | <https://git-scm.com/downloads> |
| **Android Studio** (latest stable; includes the JDK) | <https://developer.android.com/studio> |

Open Android Studio once and finish its first-run wizard (it installs the Android SDK). Then install SDK Platform 35:
**More Actions (or the gear icon) > SDK Manager > SDK Platforms > tick "Android 15.0 (API 35)" > Apply**.
Details and troubleshooting for the whole repo: see the [root README](../README.md).

### 1. Clone the repository

The repository is private, so sign in to GitHub first: either run `gh auth login` (GitHub CLI) or use
Git Credential Manager (the browser sign-in window opens automatically on the first clone).

```bash
git clone https://github.com/Joseph-VJ/MAD-Lab-Android-Projects.git
```

Android Studio alternative: **File > New > Project from Version Control**, paste the URL above, pick a folder, and
sign in to GitHub when asked. If it then opens the repo root, do step 2 anyway.

### 2. Open ONLY this project's folder

In Android Studio: **File > Open** > browse to `MAD-Lab-Android-Projects/q09-firestore-feedback` > **OK**
(choose **Trust Project** if asked). Do **not** open the repository root; every project is a separate Gradle project.

### 3. Let Gradle sync finish

The first sync downloads Gradle 8.11.1, the plugins and the libraries automatically, so it needs internet and can take
a few minutes. Wait until the bottom status bar shows no progress and the **Build** tab says *BUILD SUCCESSFUL*.
Android Studio may offer an *Android Gradle Plugin Upgrade Assistant*: click **Remind me later / ignore**; the project
works as it is.

### 4. Firebase setup (required once - this app needs your own Firebase project)

The repo ships a **placeholder** `app/google-services.json` so the project builds and opens. Until you replace it the
app shows a red "Firebase is not configured" message and sign-in / database calls fail. To connect your own project:

1. Open <https://console.firebase.google.com> and click **Create a project** (Google Analytics can be turned off).
2. On the project page click the **Android icon** (*Add app*). For **Android package name** type exactly `com.example.labapp.q09`, then **Register app**.
3. Click **Download google-services.json**.
4. In Android Studio switch the left panel from *Android* to **Project** view, and copy the downloaded file into the
   `app` folder, replacing the placeholder `app/google-services.json`.
5. In the left menu: **Build > Firestore Database > Create database > Start in test mode > Enable**.
6. Back in Android Studio: **File > Sync Project with Gradle Files**.

> Never push your real `google-services.json` to a public repository.


### 5. Run the app

1. Pick a device in the toolbar dropdown:
   - **Emulator:** **Tools > Device Manager > Create Device** > Pixel (any) > a system image (API 34 or newer) > Finish, then press its play button; or
   - **Real phone:** enable *Developer options* and *USB debugging*, connect by USB, and accept the prompt on the phone.
2. Press the green **Run** button (Shift+F10). The app installs and opens.

Command line instead (from inside this folder; use `gradlew.bat` on Windows). A device or emulator must be running:

```bash
./gradlew installDebug
```

## How to use the app

1. Do the Firebase setup first (below), with a Firestore database in **test mode**.
2. Run the app, enter a student name and feedback, tap **Submit**. It appears in the list immediately.
3. Firebase console > Firestore shows the documents with a `time` field.

## If something goes wrong

| Problem | Fix |
|---------|-----|
| `SDK location not found` | Open **File > Settings > Languages & Frameworks > Android SDK** and note the path, or just let Android Studio create `local.properties` (it does so automatically when you open the folder). |
| `Failed to find Build Tools` / platform 35 missing | **SDK Manager > SDK Platforms > Android 15.0 (API 35) > Apply**. |
| Gradle sync fails with `Unsupported class file major version` or a JDK error | **File > Settings > Build, Execution, Deployment > Build Tools > Gradle > Gradle JDK** and select the bundled *jbr-17* (or newer) JDK. |
| Sync fails to download anything | Check your internet or proxy, then **File > Sync Project with Gradle Files**. |
| Emulator will not start | Enable virtualization in the BIOS; on Windows turn on *Windows Hypervisor Platform*; or test on a real phone. |
| `Permission denied` for `./gradlew` on Linux/macOS | `chmod +x gradlew` |
