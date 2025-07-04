import java.util.Properties
import java.io.FileInputStream
import java.util.regex.Pattern
import kotlin.text.lowercase

/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.jetbrains.kotlin.kapt)
    alias(libs.plugins.compose.compiler)
}

// For the Release build, setup Keystore properties here.
val keystorePropertiesFile = rootProject.file("keystore.properties")
val keystoreProperties = Properties().apply {
    load(FileInputStream(keystorePropertiesFile))
}

// Apply custom configurations from app-flavours.gradle file
apply(from = "app-flavours.gradle")

android {
    // Set the namespace for the application
    namespace = "com.apoorvgupta.newsshots"
    // Set the compile SDK version
    compileSdk = BuildConfig.compileSdk

    defaultConfig {
        // Application ID
        applicationId = BuildConfig.applicationId
        // Minimum SDK version
        minSdk = BuildConfig.minSdk
        // Target SDK version
        targetSdk = BuildConfig.targetSdk
        // Version code and version name
        versionCode = BuildConfig.versionCode
        versionName = BuildConfig.versionName

        // Test instrumentation runner for unit tests
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        // Enable vector drawables using the support library
        vectorDrawables {
            useSupportLibrary = true
        }

        var currentBuildFlavour = getCurrentFlavor() // Changed to var
        if (currentBuildFlavour.isEmpty()) {
            currentBuildFlavour = "qa"
            // set default value to avoid compilation issue of UnresolvedReference HEAP_ENV_ID, etc.
        }
        println("Current Flavour $currentBuildFlavour") // Changed to string template
        when { // Used when for cleaner conditional logic
            currentBuildFlavour.contains("uat") -> {
                getProps("./src/configuration/uat.props").forEach { (key, value) -> // Destructured entry
                    buildConfigField("String", key.toString(), "\"${value.toString()}\"")
                }
            }
            currentBuildFlavour.contains("qa") -> {
                getProps("./src/configuration/qa.props").forEach { (key, value) ->
                    buildConfigField("String", key.toString(), "\"${value.toString()}\"")
                }
            }
            currentBuildFlavour.contains("prod") -> {
                getProps("./src/configuration/prod.props").forEach { (key, value) ->
                    buildConfigField("String", key.toString(), "\"${value.toString()}\"")
                }
            }
            currentBuildFlavour.contains("dev") -> {
                getProps("./src/configuration/dev.props").forEach { (key, value) ->
                    buildConfigField("String", key.toString(), "\"${value.toString()}\"")
                }
            }
        }
    }

    signingConfigs {
        // This is not the main keystore file which uses to publish app on PlayStore.
        create("release") { // Use create for named configurations
            storeFile = file(keystoreProperties["storeFile"].toString())
            keyAlias = keystoreProperties["keyAlias"].toString()
            keyPassword = keystoreProperties["keyPassword"].toString()
            storePassword = keystoreProperties["storePassword"].toString()
        }
    }

    buildTypes {
        getByName("release") {
            isDebuggable = false // is prefix for boolean
            // Enable Progaurd/R8 for release variants
            isMinifyEnabled = true
            // Shrink Resources for release variants
            isShrinkResources = true
            // Specify ProGuard files
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            // Specify App Signing Config
            signingConfig = signingConfigs.getByName("release")
        }
    }

    compileOptions {
        // Set Java source and target compatibility to version 17
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        // Set JVM target version
        jvmTarget = BuildConfig.jvmTarget // Assuming BuildConfig.jvmTarget is a String
    }

    buildFeatures {
        // Enable Compose support
        compose = true
        //Enable Build Configs
        buildConfig = true
    }

    composeOptions {
        // Set the Kotlin compiler extension version for Compose
        kotlinCompilerExtensionVersion = BuildConfig.kotlinCompilerExtensionVersion
    }

    packagingOptions {
        resources {
            // Exclude specific resources from packaging
            excludes += "/META-INF/{AL2.0,LGPL2.1}" // Remains largely the same
        }
    }
}

dependencies {

    // Core, Capabilities, Feature Modules Integration in the main app
    implementation(project(":core"))
    implementation(project(":capabilities"))
    implementation(project(":feature-home"))
    implementation(project(":feature-search"))
    implementation(project(":feature-bookmark"))

    // Material design dependency
    implementation(libs.androidx.material3)

    // Navigation
    implementation(libs.androidx.navigation.compose)

    // Dagger Hilt
    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)

    // Firebase
    implementation(libs.splash.screen)

    kapt(libs.hilt.android.compiler)
}

// Function definitions must be placed at the top level or within an object/class.
// They are moved outside the `android {}` or other configuration blocks.

fun getCurrentFlavor(): String {
    // In Kotlin, 'gradle' is an implicit receiver of type Project for build scripts.
    // For accessing Gradle start parameters, you'd typically get it from the Project services.
    // However, directly accessing 'getGradle()' like in Groovy might need to be:
    // val gradle = (project as org.gradle.api.invocation.Gradle).gradle
    // But it's usually better to get services directly from the project if possible.
    // For task requests, you can use:
    val tskReqStr = project.gradle.startParameter.taskRequests.toString()

    val pattern = when {
        tskReqStr.contains("assemble") -> Pattern.compile("assemble(\\w+)(Release|Debug)")
        tskReqStr.contains("bundle") -> Pattern.compile("bundle(\\w+)(Release|Debug)")
        tskReqStr.contains("test") -> Pattern.compile("test(\\w+)(Release|Debug)")
        tskReqStr.contains("sonarqube") -> Pattern.compile("sonarqube") // This pattern might not capture a flavor
        else -> Pattern.compile("generate(\\w+)(Release|Debug)")
    }

    val matcher = pattern.matcher(tskReqStr)

    return if (matcher.find() && matcher.groupCount() >= 2) {
        // For sonarqube, group(1) might not exist or be relevant as a flavor.
        // Consider how sonarqube task naming interacts here.
        if (tskReqStr.contains("sonarqube") && matcher.groupCount() < 1) "" // Handle sonarqube case if no group
        else matcher.group(1).lowercase()
    } else {
        ""
    }
}

fun getProps(path: String): Properties {
    val props = Properties()
    // In Kotlin DSL, 'file(path)' typically becomes 'project.file(path)'
    FileInputStream(project.file(path)).use { fis -> // Use 'use' for autoclosable
        props.load(fis)
    }
    return props
}
