/**
 * Copyright (c) 2025 Apoorv Gupta
 * All rights reserved.
 */

// Apply necessary plugins for Android library development, Kotlin, Dagger Hilt
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.jetbrains.kotlin.serialization)
    alias(libs.plugins.jetbrains.kotlin.kapt)
    alias(libs.plugins.compose.compiler)
}

// Android library configuration
android {
    namespace = "com.apoorvgupta.newsshots.capabilities"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
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
        compose = true // Enable Jetpack Compose
    }

    composeOptions {
        kotlinCompilerExtensionVersion = BuildConfig.kotlinCompilerExtensionVersion
    }

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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }
}

// Dependencies configuration
dependencies {
    // Core Module Integration in capabilities
    implementation(project(":core"))

    // UI dependencies
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.tooling)
    implementation(libs.androidx.material3)

    // Pagination
    implementation(libs.androidx.pagination)

    // Navigation
    implementation(libs.androidx.navigation.compose)
    implementation(libs.kotlinx.serialization)

    // Image Loader dependency
    implementation(libs.coil.compose)

    // Testing dependencies
    testImplementation(libs.junit)

    // Mocking library for testing
    testImplementation(libs.mockk)

    // Dagger Hilt for dependency injection
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    // Retrofit for networking
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)

    // Accompanist Web-View
    implementation(libs.accompanist.webView)

    // AndroidX Browser
    implementation(libs.androidx.browser)

    // DraftJS Content
    implementation(libs.draftjscompose)
}
