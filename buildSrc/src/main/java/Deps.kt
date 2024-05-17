/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

/**
 * Object containing dependency versions for the project.
 *
 * @author Apoorv Gupta
 */
object Deps {
    // Gradle
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"

    // Core dependencies
    const val kore_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    const val navigation_compose = "androidx.navigation:navigation-compose:${Versions.navigation_compose}"
    const val navigation_runtime_ktx = "androidx.navigation:navigation-runtime-ktx:${Versions.navigation_runtime_ktx}"
    const val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle_runtime}"
    const val activity_compose = "androidx.activity:activity-compose:${Versions.activity_compose}"

    // Compose dependencies
    const val compose_bom = "androidx.compose:compose-bom:${Versions.compose_bom}"
    const val compose_ui = "androidx.compose.ui:ui"
    const val compose_ui_graphics = "androidx.compose.ui:ui-graphics:${Versions.compose}"
    const val ui_tooling_preview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val material3 = "androidx.compose.material3:material3:${Versions.material}"

    // Testing dependencies
    const val junit = "junit:junit:${Versions.junit}"
    const val test_ext_junit = "androidx.test.ext:junit:${Versions.test_ext_junit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val ui_test_junit4 = "androidx.compose.ui:ui-test-junit4"
    const val ui_tooling = "androidx.compose.ui:ui-tooling"
    const val ui_test_manifest = "androidx.compose.ui:ui-test-manifest"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val kotlinx_coroutines_test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinx_coroutines_test}"

    // Networking dependencies
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit_gson}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLogging}"

    // Dagger and Hilt dependencies
    const val hilt_android = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hilt_compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    const val hilt_android_compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hilt_compiler_android = "androidx.hilt:hilt-compiler:${Versions.hilt_compiler}"
    const val hilt_navigation_compose = "androidx.hilt:hilt-navigation-compose:${Versions.hilt_compiler}"

    // Other dependencies
    const val test_compose_bom = "androidx.compose:compose-bom:${Versions.test_compose_bom}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val viewmodel_lifecycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewmodel_ktx}"

    // Timber
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    // Splash Screen
    const val splash_screen = "androidx.core:core-splashscreen:${Versions.splash_screen}"

    // Android Security Crypto
    const val security_crypto = "androidx.security:security-crypto-ktx:${Versions.security_crypto}"

    // Image Loading library
    const val glide_compose = "com.github.bumptech.glide:compose:${Versions.glide_compose}"
    const val coil_compose = "io.coil-kt:coil-compose:${Versions.coil}"

    // Accompanist Web-View
    const val accompanist_web_view = "com.google.accompanist:accompanist-webview:${Versions.accompanist_web_view}"

    // Gson
    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    // AndroidX Browser
    const val androidX_browser = "androidx.browser:browser:${Versions.androidX_browser}"

    // Google play core
    const val google_play_core = "com.google.android.play:core:${Versions.google_play_core}"

    // Lottie
    const val lottie_animation = "com.airbnb.android:lottie-compose:${Versions.lottie}"
}
