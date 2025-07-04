/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

// Apply necessary plugins for Android library development, Kotlin
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.jetbrains.kotlin.kapt)
}

// Android library configuration
android {
    namespace = "com.apoorvgupta.newsshots.core" // Package namespace for the library
    compileSdk = BuildConfig.compileSdk

    // Default configuration for the Android library
    defaultConfig {
        minSdk = BuildConfig.minSdk
    }

    lint {
        targetSdk = BuildConfig.targetSdk  // Optional: for lint checks
    }

    testOptions {
        targetSdk = BuildConfig.targetSdk  // Optional: for instrumented tests
    }

    // Configuration for different build types (e.g., release)
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
    }

    // Compilation options for the Android library
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    // Kotlin compiler options
    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }

    // Packaging options to exclude specific resources
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

// Dependencies configuration
dependencies {
    // Timber
    implementation(libs.timber)

    // Testing dependencies
    testImplementation(libs.junit)

    // Dagger Hilt for dependency injection
    implementation(libs.hilt.navigation.compose)
    kapt(libs.hilt.android.compiler)
}