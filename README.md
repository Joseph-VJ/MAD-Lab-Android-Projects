# MAD Lab - Android Projects (24CS2021)

Mobile Application Development using Android: practice lab Questions 1-13 and Experiments 10-11. Each folder is a
**complete, standalone Android Studio project** (Kotlin + Jetpack Compose) with its own Gradle wrapper, manifest,
dependencies, tests where required, and a README with the steps for that project.

## Projects

| # | Folder | Description |
|---|--------|-------------|
| Q1 | [`q01-food-ordering`](q01-food-ordering) | Food Ordering (Explicit Intents + Animations) |
| Q2 | [`q02-announcement-feed`](q02-announcement-feed) | Announcement Feed (multiple item types) |
| Q3 | [`q03-product-navigation`](q03-product-navigation) | Shopping App (Navigation Compose) |
| Q4 | [`q04-contact-directory`](q04-contact-directory) | Contact Directory (reusable row + Snackbar) |
| Q5 | [`q05-workmanager-sync`](q05-workmanager-sync) | Background Sync (WorkManager periodic work) |
| Q6 | [`q06-product-navigation-screens`](q06-product-navigation-screens) | Shopping App - list and detail screens (Navigation Compose) |
| Q7 | [`q07-reading-list-room-datastore`](q07-reading-list-room-datastore) | Reading List (Room + DataStore) |
| Q8 | [`q08-retrofit-comments`](q08-retrofit-comments) | Comments List (Retrofit REST API) |
| Q9 | [`q09-firestore-feedback`](q09-firestore-feedback) | Feedback Collector (Cloud Firestore) *(needs Firebase setup)* |
| Q10 | [`q10-tip-calculator-tests`](q10-tip-calculator-tests) | Tip Calculator (JUnit + Compose UI tests) |
| Q11 | [`q11-shopping-cart-tests`](q11-shopping-cart-tests) | Shopping Cart (JUnit + Compose UI tests) |
| Q12 | [`q12-firebase-auth-navigation`](q12-firebase-auth-navigation) | Firebase Auth with protected Home screen *(needs Firebase setup)* |
| Q13 | [`q13-firestore-event-registration`](q13-firestore-event-registration) | Event Registration (Cloud Firestore) *(needs Firebase setup)* |
| Exp 10 | [`exp10-firebase-authentication`](exp10-firebase-authentication) | Experiment 10 - Firebase Authentication *(needs Firebase setup)* |
| Exp 11 | [`exp11-notes-testing`](exp11-notes-testing) | Experiment 11 - Testing with JUnit and Compose UI tests |

---

## Complete setup on a new computer

### Step 1 - Install the tools (one time)

| Tool | Notes |
|------|-------|
| **Git** | <https://git-scm.com/downloads> |
| **Android Studio** (latest stable) | <https://developer.android.com/studio>. It bundles the JDK (17+), so you do not install Java separately. |
| **Android SDK Platform 35** | Open Android Studio, finish the first-run wizard, then **More Actions > SDK Manager > SDK Platforms > tick Android 15.0 (API 35) > Apply**. |
| An emulator or a phone | Emulator: **Tools > Device Manager > Create Device** (Pixel, system image API 34 or newer). Phone: enable *Developer options* + *USB debugging* and connect by USB. |

### Step 2 - Clone this repository

The repository is private, so sign in to GitHub first (`gh auth login`, or accept the browser sign-in that Git
Credential Manager opens on the first clone).

```bash
git clone https://github.com/Joseph-VJ/MAD-Lab-Android-Projects.git
cd MAD-Lab-Android-Projects
```

(Android Studio alternative: **File > New > Project from Version Control**, paste the URL, sign in to GitHub.)

### Step 3 - Open one project

**File > Open** > choose **one project folder** (for example `q03-product-navigation`), not the repository root
> **OK** > **Trust Project**.

### Step 4 - Gradle sync

Android Studio downloads Gradle 8.11.1, the Android Gradle Plugin and all libraries automatically. Internet is needed the
first time and it can take a few minutes. Wait for *BUILD SUCCESSFUL* in the Build tab. If it offers the *Android
Gradle Plugin Upgrade Assistant*, ignore it.

### Step 5 - Firebase projects only (Q9, Q12, Q13, Exp 10)

These four need *your own* Firebase project; see the **Firebase setup** section of that project's README (create the
project, register the Android app with the exact package name, download `google-services.json` into the `app` folder,
enable Email/Password or Firestore test mode, sync). Until then the app opens and shows a red "Firebase is not
configured" message. Never commit a real `google-services.json` to a public repository.

### Step 6 - Run

Choose the emulator or phone in the toolbar and press the green **Run** button. Command line, from inside the
project folder (`gradlew.bat` on Windows, with a device running):

```bash
./gradlew installDebug
```

### Step 7 - Tests (Q10, Q11, Exp 11)

- Unit tests (no emulator): right-click the test file > **Run**, or `./gradlew testDebugUnitTest`.
- Compose UI tests (emulator or phone running): right-click the test file > **Run**, or `./gradlew connectedDebugAndroidTest`.
- Q10 and Q11 contain the deliberate-bug exercise. Run `git log --oneline` in the repo: the history first has the buggy
  version (tests fail) and then the commit that fixes it.

## Pinned versions

Gradle 8.11.1, Android Gradle Plugin 8.7.3, Kotlin 2.1.0, Compose BOM 2024.12.01, Firebase BoM 33.7.0, compileSdk/targetSdk 35,
minSdk 24, JDK 17+. Compatible with Android Studio Ladybug (2024.2) and newer.

## Troubleshooting

| Problem | Fix |
|---------|-----|
| `SDK location not found` | Android Studio creates `local.properties` itself when you open the project folder. If you build from the command line, set `ANDROID_HOME` to your SDK path or create `local.properties` containing `sdk.dir=C:/Users/YOU/AppData/Local/Android/Sdk` (adjust the path, use forward slashes). |
| `Failed to find Build Tools` / platform 35 missing | SDK Manager > SDK Platforms > Android 15.0 (API 35) > Apply. |
| JDK / `Unsupported class file major version` errors | **File > Settings > Build, Execution, Deployment > Build Tools > Gradle > Gradle JDK** > select the bundled *jbr-17* (or newer). |
| Sync cannot download dependencies | Check internet/proxy, then **File > Sync Project with Gradle Files**. |
| Emulator will not start | Enable virtualization in the BIOS; on Windows turn on *Windows Hypervisor Platform*; or use a real phone. |
| `Permission denied: ./gradlew` (Linux/macOS) | `chmod +x gradlew` |
| Clone asks for a password and fails | The repo is private: run `gh auth login` or sign in via the browser prompt; passwords no longer work for GitHub. |
