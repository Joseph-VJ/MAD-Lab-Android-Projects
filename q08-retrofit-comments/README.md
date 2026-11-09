# Comments List (Retrofit REST API)

**Question 8** - 24CS2021 Mobile Application Development using Android

Fetch comments from https://jsonplaceholder.typicode.com/comments with Retrofit, show a progress indicator while loading, then list name and email.

- Application id / package: `com.example.labapp.q08`
- Kotlin + Jetpack Compose (Material 3), Android Gradle Plugin 8.7.3, Kotlin 2.1.0, minSdk 24, compileSdk 35

## Open and run

1. Clone the repository. In Android Studio choose **File > Open** and select this folder (`q08-retrofit-comments`), not the repo root.
2. Wait for the Gradle sync to finish (everything downloads automatically; internet is needed the first time).
3. Pick an emulator (Device Manager > Create Device) or a phone with USB debugging and press the green **Run** button.
   Command line: `./gradlew assembleDebug` (`gradlew.bat` on Windows).

If Android Studio offers an "Android Gradle Plugin Upgrade Assistant", you can safely ignore it.

## How to use the app

1. The emulator or phone needs internet.
2. Run the app: a progress circle shows first, then the list of comments (name and email).
