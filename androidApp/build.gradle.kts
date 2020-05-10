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
  implementation(Coroutines.android)
  implementation(AndroidX.appCompat)
  implementation(AndroidX.constraintLayout)
  implementation(AndroidX.recyclerView)
  implementation(material)
  implementation(AndroidX.swipeToRefreshLayout)
  implementation(timber)
  implementation(picasso)

  implementation(project(":shared"))
}
