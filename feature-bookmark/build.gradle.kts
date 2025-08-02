/**
 * Copyright (c) 2025 Apoorv Gupta
 * All rights reserved.
 */

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.jetbrains.kotlin.kapt)
    alias(libs.plugins.compose.compiler)
}

android {
    // Define the package namespace for the feature module
    namespace = "com.apoorvgupta.newsshots.bookmark"

    // Set the compile SDK version
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        // Configure default settings such as minSdk, targetSdk, and test runner
        minSdk = libs.versions.android.minSdk.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    lint {
        targetSdk = libs.versions.android.targetSdk.get().toInt()  // Optional: for lint checks
    }

    testOptions {
        targetSdk = libs.versions.android.targetSdk.get().toInt()  // Optional: for instrumented tests
    }

    buildFeatures {
        // Enable Jetpack Compose features
        compose = true
    }

    composeOptions {
        // Set the Kotlin compiler extension version for Jetpack Compose
        kotlinCompilerExtensionVersion = BuildConfig.kotlinCompilerExtensionVersion
    }

    buildTypes {
        release {
            // Enable Progaurd/R8 for release variants
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        // Set source and target compatibility to Java 17
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }
}

dependencies {
    // Core, Capabilities Integration in Feature Modules
    implementation(project(":core"))
    implementation(project(":capabilities"))

    // UI dependencies
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.activity.compose)

    // Navigation
    implementation(libs.androidx.navigation.compose)

    // Dagger Hilt for dependency injection
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    // Testing dependencies
    testImplementation(libs.junit)

    // Gson
    implementation(libs.gson)

    // Image Loading library
    implementation(libs.coil.compose)
}
