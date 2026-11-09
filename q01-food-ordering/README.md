# Food Ordering (Explicit Intents + Animations)

**Question 1** - 24CS2021 Mobile Application Development using Android

Activity interaction with explicit Intents, data passing between Activities, and UI animations.

- Application id / package: `com.example.labapp.q01`
- Kotlin + Jetpack Compose (Material 3), Android Gradle Plugin 8.7.3, Kotlin 2.1.0, minSdk 24, compileSdk 35

## Open and run

1. Clone the repository. In Android Studio choose **File > Open** and select this folder (`q01-food-ordering`), not the repo root.
2. Wait for the Gradle sync to finish (everything downloads automatically; internet is needed the first time).
3. Pick an emulator (Device Manager > Create Device) or a phone with USB debugging and press the green **Run** button.
   Command line: `./gradlew assembleDebug` (`gradlew.bat` on Windows).

If Android Studio offers an "Android Gradle Plugin Upgrade Assistant", you can safely ignore it.

## How to use the app

1. Run the app. Tap a food card: it expands with an animation.
2. Tap **Order Now**: the Order Summary screen opens with the item and price (animated entry).
