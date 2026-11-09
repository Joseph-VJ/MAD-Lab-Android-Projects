# Reading List (Room + DataStore)

**Question 7** - 24CS2021 Mobile Application Development using Android

Save books in a Room database, delete with an icon, and switch between Title A-Z / Newest First with a Switch whose state is stored in DataStore.

- Application id / package: `com.example.labapp.q07`
- Kotlin + Jetpack Compose (Material 3), Android Gradle Plugin 8.7.3, Kotlin 2.1.0, minSdk 24, compileSdk 35

## Open and run

1. Clone the repository. In Android Studio choose **File > Open** and select this folder (`q07-reading-list-room-datastore`), not the repo root.
2. Wait for the Gradle sync to finish (everything downloads automatically; internet is needed the first time).
3. Pick an emulator (Device Manager > Create Device) or a phone with USB debugging and press the green **Run** button.
   Command line: `./gradlew assembleDebug` (`gradlew.bat` on Windows).

If Android Studio offers an "Android Gradle Plugin Upgrade Assistant", you can safely ignore it.

## How to use the app

1. Run the app, type a title and author, tap **Save Book** (add 3 books).
2. Use the switch to change between Title A-Z and Newest First. Tap the bin icon to delete a book.
3. Swipe the app away and reopen it: the list opens in the order you chose last time (stored in DataStore).
