/**
 * Copyright (c) 2025 Apoorv Gupta
 * All rights reserved.
 */

// Apply necessary plugins for Android library development, Kotlin
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.jetbrains.kotlin.kapt)
    alias(libs.plugins.jetbrains.kotlin.serialization)
}

// Android library configuration
android {
    namespace = "com.apoorvgupta.newsshots.core" // Package namespace for the library
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    // Default configuration for the Android library
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    lint {
        targetSdk = libs.versions.android.targetSdk.get().toInt()  // Optional: for lint checks
    }

    testOptions {
        targetSdk = libs.versions.android.targetSdk.get().toInt()  // Optional: for instrumented tests
    }

    // Configuration for different build types (e.g., release)
    buildTypes {
        release {
            // Enable Progaurd/R8 for release variants
            isMinifyEnabled = true
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
    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)
    kapt(libs.hilt.android.compiler)
    
    // DataStore
    implementation(libs.datastore.preferences)

    // Serialization
    implementation(libs.kotlinx.serialization)
}