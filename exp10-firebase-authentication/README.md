# Experiment 10 - Firebase Authentication

**Experiment 10** - 24CS2021 Mobile Application Development using Android

Authenticate users with Firebase Authentication (Email/Password) and show a protected signed-in state.

- Application id / package: `com.example.firebaseauthapp`
- Kotlin + Jetpack Compose (Material 3), Android Gradle Plugin 8.7.3, Kotlin 2.1.0, minSdk 24, compileSdk 35

## Open and run

1. Clone the repository. In Android Studio choose **File > Open** and select this folder (`exp10-firebase-authentication`), not the repo root.
2. Wait for the Gradle sync to finish (everything downloads automatically; internet is needed the first time).
3. Pick an emulator (Device Manager > Create Device) or a phone with USB debugging and press the green **Run** button.
   Command line: `./gradlew assembleDebug` (`gradlew.bat` on Windows).

If Android Studio offers an "Android Gradle Plugin Upgrade Assistant", you can safely ignore it.


## Firebase setup (required once - the app cannot talk to Firebase without your own project)

This repo contains a **placeholder** `app/google-services.json` so the project builds and opens cleanly.
Until you replace it, the app shows a red "Firebase is not configured" message and sign-in / Firestore calls fail.

1. Go to <https://console.firebase.google.com> > **Add project**.
2. Project settings > **Add app > Android**. Package name must be exactly `com.example.firebaseauthapp`. Download `google-services.json`.
3. Replace `app/google-services.json` with the downloaded file (Android Studio: switch the left panel to **Project** view, put it inside the `app` folder).
4. Build > **Authentication** > Get started > Sign-in method > **Email/Password** > Enable.
5. Sync Gradle and run.

> Do not push your real `google-services.json` to a public repository.

## How to use the app

1. Do the Firebase setup first (below), with **Email/Password** sign-in enabled.
2. Enter an email and a password of 6+ characters, tap **Register**: you see `Welcome! You are signed in.` with a Sign Out button.
3. Tap **Sign Out**, then **Login** with the same details: signed in again. A wrong password shows `Failed. Check credentials.`
