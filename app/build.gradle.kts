import java.io.FileInputStream
import java.util.Properties
import java.util.regex.Pattern

/**
 * Copyright (c) 2025 Apoorv Gupta
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
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        // Application ID
        applicationId = BuildConfig.applicationId
        // Minimum SDK version
        minSdk = libs.versions.android.minSdk.get().toInt()
        // Target SDK version
        targetSdk = libs.versions.android.targetSdk.get().toInt()
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
        val props = when {
            currentBuildFlavour.contains("uat") -> getProps("./src/configuration/uat.props")
            currentBuildFlavour.contains("qa") -> getProps("./src/configuration/qa.props")
            currentBuildFlavour.contains("prod") -> getProps("./src/configuration/prod.props")
            currentBuildFlavour.contains("dev") -> getProps("./src/configuration/dev.props")
            else -> emptyMap()
        }

        for ((key, value) in props) {
            buildConfigField("String", key, "\"$value\"")
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
        release {
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

    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
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

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
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
    implementation(platform(libs.androidx.compose.bom))
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

fun getProps(path: String): Map<String, String> {
    val props = Properties()
    FileInputStream(project.file(path)).use { fis ->
        props.load(fis)
    }
    return props.entries.associate {
        it.key.toString() to it.value.toString()
    }
}