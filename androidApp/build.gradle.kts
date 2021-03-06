plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
}

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.2.1")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.7-1.4-M3")
    implementation("androidx.core:core-ktx:1.3.1")
}

android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "com.cyberinsane.kmm_jetflix.androidApp"
        minSdkVersion(24)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}