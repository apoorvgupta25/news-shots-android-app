/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

/**
 * Object containing build time configurations.
 *
 * @author Apoorv Gupta
 */
object BuildConfig {
    // Android build configuration
    const val compileSdk = 35
    const val minSdk = 29
    const val targetSdk = 35
    const val versionCode = 4
    const val versionName = "1.0.1"

    // Kotlin and JVM configuration
    const val jvmTarget = "17"
    const val kotlinCompilerExtensionVersion = "1.5.13"

    const val applicationId = "com.apoorvgupta.newsshots"
    const val appName = "News Shots App"
}

// Object representing configurations specific to the UAT flavor
object UAT {
    const val versionName = "1.0.0"
    const val prefix = "UAT-"
    const val suffix = "-UAT"
    const val dimensions = "app"
    const val extension = "${BuildConfig.applicationId}.uat"
    const val appName = "${BuildConfig.appName}$suffix"
}

// Object representing configurations specific to the QA flavor
object QA {
    const val versionName = "1.0.0"
    const val prefix = "QA"
    const val suffix = "-QA"
    const val dimensions = "app"
    const val extension = "${BuildConfig.applicationId}.qa"
    const val appName = "${BuildConfig.appName}$suffix"
}

// Object representing configurations specific to the DEV flavor
object DEV {
    const val versionName = "1.0.0"
    const val prefix = "DEV-"
    const val suffix = "-DEV"
    const val dimensions = "app"
    const val extension = "${BuildConfig.applicationId}.dev"
    const val appName = "${BuildConfig.appName}$suffix"
}

// Object representing configurations specific to the PROD flavor
object PROD {
    const val versionName = "1.0.0"
    const val prefix = ""
    const val suffix = ""
    const val dimensions = "app"
    const val extension = BuildConfig.applicationId
    const val appName = "${BuildConfig.appName}$suffix"
}
