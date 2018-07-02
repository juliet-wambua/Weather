# Weather App

## About
An app that implements firebase to login and store weather forecast data obtained from the Open Weather API for the next five days. The data is organised in daily three hour intervals summarised into a list where each item acts as link to more detailed view.


## Requirements
- Android Studio or an android sdk
- An API-key obtained from Open weather site.
-

## Setup
    Clone this repository and import into Android Studio. Git clone [this link](https://github.com/Vinge1718/Weather).
## Configuration
    * After registratiion and obtaining your API key.
    * Add the key to the gradle.properties file located in the root directory
    * Hide your gradle.properties file from GitHub by adding it to .gitignore file.
    * The constant file contain references to our Weather request credentials. Within this file you can reference apikey from gradle.properties.
    * complie and run

## Contributions

 - Fork it
 - Create your feature branch (git checkout -b my-new-feature)
 - Commit your changes (git commit -m 'Add some feature')
 - Run the linter (ruby lint.rb').
 - Push your branch (git push origin my-new-feature)
 - Create a new Pull Request
## Known problems:
 - The Listing feature where the saved weather details are supposed to be listed down is crashing the app. the dependency upgrades that allow the use of firebase auth and firebaseUI do not implement the use of firebase-recyclerview and firebase-adapter to fetch and display the items. Work in progeress.
