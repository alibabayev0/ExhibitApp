
# ExhibitApp
ExhibitApp is a sample exhibit android application 📱 The project was done in 2 hrs ⏰
# About
It simply loads Phones data from API and shows it. Phones will be always loaded from remote (from API).
Dummy API is used in this app. JSON response is statically hosted [here](https://my-json-server.typicode.com/Reyst/exhibit_db/list)
## Built With  🛠
-   [Kotlin](https://kotlinlang.org/)  - First class and official programming language for Android development.
-   [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)  - For asynchronous and more.
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.

	-  [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)  - Data objects that notify views when the underlying database changes.
	-   [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)  - Stores UI-related data that isn't destroyed on UI changes.
	-   [ViewBinding](https://developer.android.com/topic/libraries/view-binding)  - Generates a binding class for each XML layout file present in that module and allows you to more easily write code that interacts with views.
- [Dependency Injection](https://developer.android.com/training/dependency-injection) -  Not used in app just provided fake functions in ApiFactory
-   [Retrofit](https://square.github.io/retrofit/)  - A type-safe HTTP client for Android and Java.
## Lint  ✅
Following Linters are used internally by super linter (enabled for this project):

-   XML:  [LibXML](http://xmlsoft.org/)
-   Kotlin:  [ktlint](https://github.com/pinterest/ktlint)
# Package Structure

```
com.uran.exhibitapp     	# App Module
.
├── ui                 		# Store Activity/View layer, VM, and adapters, etc.
│   ├── exhibit 	   		# Home Screen of app
└── util               		# Utility Classes / Kotlin extensions
.
com.uran.model         		# Models and Interface Module
.
com.uran.restexhibitsloader # Loader Module
.
└── network                 # Remote services && Retrofit API for remote end point
