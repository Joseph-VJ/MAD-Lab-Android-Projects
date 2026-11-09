# Shopping App (Navigation Compose)

**Question 3** - 24CS2021 Mobile Application Development using Android

Product list screen and Product Detail screen, passing data with Navigation Compose.

- Application id / package: `com.example.labapp.q03`
- Kotlin + Jetpack Compose (Material 3), Android Gradle Plugin 8.7.3, Kotlin 2.1.0, minSdk 24, compileSdk 35

## Open and run

1. Clone the repository. In Android Studio choose **File > Open** and select this folder (`q03-product-navigation`), not the repo root.
2. Wait for the Gradle sync to finish (everything downloads automatically; internet is needed the first time).
3. Pick an emulator (Device Manager > Create Device) or a phone with USB debugging and press the green **Run** button.
   Command line: `./gradlew assembleDebug` (`gradlew.bat` on Windows).

If Android Studio offers an "Android Gradle Plugin Upgrade Assistant", you can safely ignore it.

## How to use the app

1. Run the app. Tap a product (for example Laptop): the Product Detail screen opens with name, price and category.
2. Press Back to return to the list.
