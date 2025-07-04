/**
 * Copyright (c) 2025 Apoorv Gupta
 * All rights reserved.
 */

// Plugin management configuration for Gradle build scripts
pluginManagement {
    repositories {
        google() // Google Maven repository
        mavenCentral() // Maven Central repository
        gradlePluginPortal() // Gradle Plugin Portal repository
    }
}

// Dependency resolution management for Gradle build scripts
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google() // Google Maven repository
        mavenCentral() // Maven Central repository
        maven(url = "https://jitpack.io")
    }
}

// Root project configuration
rootProject.name = "newsshots"

// Project inclusion configuration
include(":app") // Main application module
include(":feature-home") // Feature module for Home
include(":feature-search") // Feature module for Search
include(":feature-bookmark") // Feature module for Bookmark
include(":capabilities") // Capabilities module
include(":core") // Core module
