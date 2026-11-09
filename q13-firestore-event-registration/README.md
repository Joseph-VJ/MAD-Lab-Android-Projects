# Event Registration (Cloud Firestore)

**Question 13** - 24CS2021 Mobile Application Development using Android

Register participants (name, email, event dropdown) into the Firestore collection `registrations` with a server timestamp; real-time list and total count.

- Application id / package: `com.example.labapp.q13`
- Kotlin + Jetpack Compose (Material 3), Android Gradle Plugin 8.7.3, Kotlin 2.1.0, minSdk 24, compileSdk 35

## Open and run

1. Clone the repository. In Android Studio choose **File > Open** and select this folder (`q13-firestore-event-registration`), not the repo root.
2. Wait for the Gradle sync to finish (everything downloads automatically; internet is needed the first time).
3. Pick an emulator (Device Manager > Create Device) or a phone with USB debugging and press the green **Run** button.
   Command line: `./gradlew assembleDebug` (`gradlew.bat` on Windows).

If Android Studio offers an "Android Gradle Plugin Upgrade Assistant", you can safely ignore it.


## Firebase setup (required once - the app cannot talk to Firebase without your own project)

This repo contains a **placeholder** `app/google-services.json` so the project builds and opens cleanly.
Until you replace it, the app shows a red "Firebase is not configured" message and sign-in / Firestore calls fail.

1. Go to <https://console.firebase.google.com> > **Add project**.
2. Project settings > **Add app > Android**. Package name must be exactly `com.example.labapp.q13`. Download `google-services.json`.
3. Replace `app/google-services.json` with the downloaded file (Android Studio: switch the left panel to **Project** view, put it inside the `app` folder).
4. Build > **Firestore Database** > Create database > **Start in test mode**.
5. Sync Gradle and run.

> Do not push your real `google-services.json` to a public repository.

## How to use the app

1. Do the Firebase setup first (below), with a Firestore database in **test mode**.
2. Run the app, enter name and email, pick Hackathon / Workshop / Quiz and tap **Register**.
3. The entry appears in the list and **Total registrations** goes up at once. Check Firebase console > Firestore > `registrations`.
