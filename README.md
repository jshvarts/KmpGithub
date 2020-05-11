# Documentation

## Setting up iOS

1. Integrate [Cocoapods plugin for Kotlin Native](https://github.com/JetBrains/kotlin-native/blob/master/COCOAPODS.md) 

See `shared/build.gradle` for cocoapods plugin setup. Note that setting `version` is required:

```
// CocoaPods requires the podspec to have a version.
version = 1.0
```

Also note the `kotlin.cocoapods { ... }` block.

The Cocoapods plugin will automatically build frameworks for both debug and release variants. No need to run any custom gradlew tasks to pack for Xcode, scripts to run, etc.

If you get stuck, refer to [this commit](https://github.com/jshvarts/KmpGithub/commit/5170e416bc7259b787cd1a49e7b3faf635a24a9b)

> Note: if you prefer to run Gradle tasks to pack framework for xcode instead, refer to [these detailed instructions](https://github.com/jshvarts/KmpHelloPlatform)
  
2. Run `./gradlew :shared:podspec` from the root of the project to generate `shared/shared.podspec` which contains kotlin targets for iOS (this includes simulator and device).

3. Create XCode project in `iosApp`

4. Close XCode.

5. Inside the new project created run `pod init`

6. Edit the generated `Podfile` to point to the `shared.podspec`:

```
target 'KmpGithub' do
  # Comment the next line if you don't want to use dynamic frameworks
  use_frameworks!

  # Pods for KmpGithub
  pod 'shared', :path => '../../shared'
end
```

7. Run `pod install` inside the XCode project folder.

8. Open the project in XCode by executing `open <proj-name>.xcworkspace` from your ios project root folder.

9. Use `import shared` in your code and utilize shared Kotlin code from Swift! If there are any build errors, try building the project by running in iOS simulator. 


