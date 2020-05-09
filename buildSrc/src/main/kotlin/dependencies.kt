object Versions {
  const val minSdk = 23
  const val compileSdk = 29
  const val targetSdk = 29
  const val androidBuildTools = "29.0.2"
  const val picasso = "2.71828"
  const val kotlin = "1.3.72"
  const val ktor = "1.3.2"
  const val serialization = "0.20.0"
  const val coroutines = "1.3.5"
  const val timberAndroid = "4.7.1"
}

object AndroidX {
  const val appCompat = "1.0.2"
  const val constraintLayout = "1.1.3"
  const val material = "1.2.0-alpha05"
  const val recyclerView = "1.1.0"
}

object Coroutines {
  object Core {
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val common = "org.jetbrains.kotlinx:kotlinx-coroutines-core-common:${Versions.coroutines}"
    const val native = "org.jetbrains.kotlinx:kotlinx-coroutines-core-native:${Versions.coroutines}"
  }
}

object Ktor {
  const val android = "io.ktor:ktor-client-android:${Versions.ktor}"
  const val ios = "io.ktor:ktor-client-ios:${Versions.ktor}"

  object Core {
    const val common = "io.ktor:ktor-client-core:${Versions.ktor}"
    const val jvm = "io.ktor:ktor-client-core-jvm:${Versions.ktor}"
    const val native = "io.ktor:ktor-client-core-native:${Versions.ktor}"
  }

  object Json {
    const val common = "io.ktor:ktor-client-json:${Versions.ktor}"
    const val jvm = "io.ktor:ktor-client-json-jvm:${Versions.ktor}"
    const val native = "io.ktor:ktor-client-json-native:${Versions.ktor}"
  }

  object Logging {
    const val common = "io.ktor:ktor-client-logging:${Versions.ktor}"
    const val jvm = "io.ktor:ktor-client-logging-jvm:${Versions.ktor}"
    const val native = "io.ktor:ktor-client-logging-native:${Versions.ktor}"
  }

  object Serialization {
    const val common = "io.ktor:ktor-client-serialization:${Versions.ktor}"
    const val jvm = "io.ktor:ktor-client-serialization-jvm:${Versions.ktor}"
    const val native = "io.ktor:ktor-client-serialization-native:${Versions.ktor}"
  }
}

object Serialization {
  const val runtime =
    "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.serialization}"
  const val runtimeNative =
    "org.jetbrains.kotlinx:kotlinx-serialization-runtime-native:${Versions.serialization}"
}

