# MAD Lab - Android Projects (24CS2021)

Mobile Application Development using Android: practice lab **Questions 1-13** and **Experiments 10-11**.
Every folder is a **complete, standalone Android Studio project** (Kotlin + Jetpack Compose) - open it, press Run, done.
Each project's own README explains how to run it, what you will see, how it works, and how to build it from scratch.

## Start here (5 minutes)

1. **Install** Git and Android Studio (first time only - see [Setup](#first-time-setup) below).
2. **Clone** (sign in to GitHub when asked - the repo is private):
   ```bash
   git clone https://github.com/Joseph-VJ/MAD-Lab-Android-Projects.git
   ```
3. **Open ONE project folder** in Android Studio: **File > Open** > pick e.g. `q03-product-navigation` > **OK**. Do not open the repo root.
4. **Wait** for the Gradle sync to finish (needs internet the first time).
5. **Run:** pick an emulator or phone, press the green **Run** button.

## Pick a project

| # | Project (click for its README) | What it teaches | Needs |
|---|--------------------------------|-----------------|-------|
| Q1 | [**q01-food-ordering**](q01-food-ordering) | Explicit Intents, data passing, animations | - |
| Q2 | [**q02-announcement-feed**](q02-announcement-feed) | Sealed classes, LazyColumn with mixed item types | - |
| Q3 | [**q03-product-navigation**](q03-product-navigation) | Navigation Compose, passing data between screens | - |
| Q4 | [**q04-contact-directory**](q04-contact-directory) | Reusable composable, Snackbar, coroutines | - |
| Q5 | [**q05-workmanager-sync**](q05-workmanager-sync) | WorkManager periodic background work | - |
| Q6 | [**q06-product-navigation-screens**](q06-product-navigation-screens) | Navigation Compose (same as Q3, for screenshots) | - |
| Q7 | [**q07-reading-list-room-datastore**](q07-reading-list-room-datastore) | Room database + DataStore preferences | - |
| Q8 | [**q08-retrofit-comments**](q08-retrofit-comments) | Retrofit REST API + JSON, loading indicator | Internet |
| Q9 | [**q09-firestore-feedback**](q09-firestore-feedback) | Cloud Firestore, real-time list | Firebase project |
| Q10 | [**q10-tip-calculator-tests**](q10-tip-calculator-tests) | JUnit + Compose UI tests, deliberate bug | Emulator for UI tests |
| Q11 | [**q11-shopping-cart-tests**](q11-shopping-cart-tests) | JUnit + Compose UI tests, deliberate bug | Emulator for UI tests |
| Q12 | [**q12-firebase-auth-navigation**](q12-firebase-auth-navigation) | Firebase Auth + protected screen + navigation | Firebase project |
| Q13 | [**q13-firestore-event-registration**](q13-firestore-event-registration) | Firestore, dropdown, real-time list + count | Firebase project |
| Exp 10 | [**exp10-firebase-authentication**](exp10-firebase-authentication) | Firebase Authentication (Email/Password) | Firebase project |
| Exp 11 | [**exp11-notes-testing**](exp11-notes-testing) | JUnit + Compose UI testing | Emulator for UI tests |

*Firebase projects:* create your own free Firebase project and drop its `google-services.json` into the project's `app` folder - each README has a 6-step guide. Until then the app opens and shows a red "Firebase is not configured" message.

---

## First-time setup

| # | What | How |
|---|------|-----|
| 1 | **Git** | <https://git-scm.com/downloads>, install with defaults. |
| 2 | **Android Studio** (latest stable) | <https://developer.android.com/studio>. Open it and finish the first-run wizard (installs the Android SDK; the JDK is bundled). |
| 3 | **Android 15 (API 35) SDK** | Android Studio > **More Actions > SDK Manager > SDK Platforms** > tick **Android 15.0 (API 35)** > **Apply**. |
| 4 | **GitHub sign-in** | `gh auth login` (GitHub CLI) or sign in via the browser window that opens on your first clone. |
| 5 | **A device** | **Emulator:** **Tools > Device Manager > Create Device** > Pixel > system image API 34+. **Phone:** enable *Developer options* and *USB debugging*, connect by USB, tap *Allow*. |

## Running tests (Q10, Q11, Exp 11)

- **Unit tests** (no emulator): right-click the test file > **Run**, or `./gradlew testDebugUnitTest`.
- **UI tests** (emulator or phone running): right-click the test file > **Run**, or `./gradlew connectedDebugAndroidTest`.
- **Deliberate-bug exercise (Q10, Q11):** `git log --oneline` shows the buggy commit first (tests fail) and then the fix commit (tests pass). Each project README also explains how to reproduce it.

## Pinned versions

Gradle 8.11.1, Android Gradle Plugin 8.7.3, Kotlin 2.1.0, Compose BOM 2024.12.01, Firebase BoM 33.7.0, compileSdk/targetSdk 35, minSdk 24, JDK 17+.
Works with Android Studio Ladybug (2024.2) and newer.

## Troubleshooting

<details>
<summary><b>Click to open the common fixes</b></summary>

| Problem | Fix |
|---------|-----|
| `SDK location not found` | Android Studio creates `local.properties` itself when you open the folder. For command-line builds set `ANDROID_HOME`, or create `local.properties` with `sdk.dir=C:/Users/YOU/AppData/Local/Android/Sdk`. |
| `Failed to find Build Tools` / platform 35 missing | SDK Manager > SDK Platforms > Android 15.0 (API 35) > Apply. |
| JDK / `Unsupported class file major version` | **File > Settings > Build, Execution, Deployment > Build Tools > Gradle > Gradle JDK** > bundled *jbr-17* (or newer). |
| Sync cannot download anything | Check internet/proxy, then **File > Sync Project with Gradle Files**. |
| "Android Gradle Plugin Upgrade Assistant" popup | Ignore it (**Remind me later**). |
| Emulator will not start | Enable virtualization in the BIOS; on Windows turn on *Windows Hypervisor Platform*; or use a real phone. |
| `Permission denied: ./gradlew` (Linux/macOS) | `chmod +x gradlew` |
| Clone asks for a password and fails | Run `gh auth login` or sign in via the browser prompt; passwords no longer work on GitHub. |
| "Not a Gradle project" | You opened the repo root. Open one project folder instead. |

</details>
