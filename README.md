# MAD Lab - Android Projects (24CS2021)

Mobile Application Development using Android: practice lab Questions 1-13 and Experiments 10-11, each as a
**complete, standalone Android Studio project** (Kotlin + Jetpack Compose). Every folder has its own Gradle
wrapper, so you can open any one of them directly.

## How to use

```bash
git clone <this repository url>
```

In Android Studio: **File > Open** > pick **one project folder** (for example `q03-product-navigation`), wait for
Gradle sync, choose an emulator or phone, press **Run**. Gradle, the Android Gradle Plugin and all libraries are
downloaded automatically on the first sync (internet needed).

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

## Requirements

- Android Studio Ladybug (2024.2) or newer, with JDK 17 or newer (the bundled JDK is fine)
- Android SDK Platform 35 (Android Studio offers to install it)
- Pinned versions: Gradle 8.11.1, AGP 8.7.3, Kotlin 2.1.0, Compose BOM 2024.12.01, Firebase BoM 33.7.0

## Firebase projects (Q9, Q12, Q13, Exp 10)

These need *your own* Firebase project, which cannot be shipped in a repository. Each ships a placeholder
`app/google-services.json` so it builds and opens; the app shows a clear message until you replace it. The step by
step setup is in each project's README. Never commit a real `google-services.json` to a public repository.

## Tests (Q10, Q11, Exp 11)

- Unit tests: `./gradlew testDebugUnitTest` inside the project folder (no emulator).
- Compose UI tests: start an emulator, then `./gradlew connectedDebugAndroidTest`.
- Q10 and Q11 include the deliberate-bug exercise: the git history first contains the buggy version (failing
  tests), then the fix.
