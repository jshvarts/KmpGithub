plugins {
  id("com.android.application")
  kotlin("android")
  kotlin("android.extensions")
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
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
    }
  }

  packagingOptions {
    exclude("META-INF/*.kotlin_module")
  }
}

dependencies {
  implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
  implementation(kotlin("stdlib-jdk7", Versions.kotlin))
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}")
  implementation("androidx.appcompat:appcompat:${AndroidX.appCompat}")
  implementation("androidx.constraintlayout:constraintlayout:${AndroidX.constraintLayout}")
  implementation("androidx.recyclerview:recyclerview:${AndroidX.recyclerView}")
  implementation("com.google.android.material:material:${AndroidX.material}")
  implementation("androidx.swiperefreshlayout:swiperefreshlayout:${AndroidX.swipeToRefreshLayout}")
  implementation("com.jakewharton.timber:timber:${Versions.timberAndroid}")
  implementation("com.squareup.picasso:picasso:${Versions.picasso}")

  implementation(project(":shared"))
}
