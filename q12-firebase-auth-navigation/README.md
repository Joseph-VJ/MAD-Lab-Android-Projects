# Firebase Auth with protected Home screen

**Question 12** - 24CS2021 Mobile Application Development using Android

Email/Password login and register, protected Home screen showing the user's email with Logout, redirect to Login when signed out, and straight to Home when reopened while signed in.

- Application id / package: `com.example.labapp.q12`
- Kotlin + Jetpack Compose (Material 3), Android Gradle Plugin 8.7.3, Kotlin 2.1.0, minSdk 24, compileSdk 35

## Open and run

1. Clone the repository. In Android Studio choose **File > Open** and select this folder (`q12-firebase-auth-navigation`), not the repo root.
2. Wait for the Gradle sync to finish (everything downloads automatically; internet is needed the first time).
3. Pick an emulator (Device Manager > Create Device) or a phone with USB debugging and press the green **Run** button.
   Command line: `./gradlew assembleDebug` (`gradlew.bat` on Windows).

If Android Studio offers an "Android Gradle Plugin Upgrade Assistant", you can safely ignore it.


## Firebase setup (required once - the app cannot talk to Firebase without your own project)

This repo contains a **placeholder** `app/google-services.json` so the project builds and opens cleanly.
Until you replace it, the app shows a red "Firebase is not configured" message and sign-in / Firestore calls fail.

1. Go to <https://console.firebase.google.com> > **Add project**.
2. Project settings > **Add app > Android**. Package name must be exactly `com.example.labapp.q12`. Download `google-services.json`.
3. Replace `app/google-services.json` with the downloaded file (Android Studio: switch the left panel to **Project** view, put it inside the `app` folder).
4. Build > **Authentication** > Get started > Sign-in method > **Email/Password** > Enable.
5. Sync Gradle and run.

> Do not push your real `google-services.json` to a public repository.

## How to use the app

1. Do the Firebase setup first (below), with **Email/Password** sign-in enabled.
2. Run the app, enter an email and a password of 6+ characters, tap **Register**: Home shows `Logged in as: your email`.
3. Tap **Logout**: back to Login. A wrong password shows `Failed. Check credentials.`
4. Close the app while signed in and open it again: it goes straight to Home.
