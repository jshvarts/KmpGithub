plugins {
  id("com.android.application")
  kotlin("android")
}

android {
  compileSdkVersion(Versions.compileSdk)

  defaultConfig {
    applicationId = "com.jshvarts.kmp"
    minSdkVersion(Versions.minSdk)
    targetSdkVersion(Versions.targetSdk)
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    named("release") {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }

  packagingOptions {
    exclude("META-INF/*.kotlin_module")
  }
}

dependencies {
  implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}")
  implementation("androidx.appcompat:appcompat:${AndroidX.appCompatVersion}")
  implementation("com.google.android.material:material:${AndroidX.materialVersion}")
  implementation("com.jakewharton.timber:timber:${Versions.timberAndroid}")

  implementation(project(":shared"))
}
