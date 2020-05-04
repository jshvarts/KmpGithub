package com.jshvarts.kmp.shared

expect fun platformName(): String

fun createPlatformMessage(): String {
    return "Kotlin rocks on ${platformName()}"
}
