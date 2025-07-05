/**
 * Copyright (c) 2025 Apoorv Gupta
 * All rights reserved.
 */
package com.apoorvgupta.newsshots

import android.app.Application
import com.apoorvgupta.core.logger.AppLogger
import dagger.hilt.android.HiltAndroidApp

/**
 * Main application class.
 *
 * This class serves as the entry point for the Newsshots Android application.
 * It extends the Android Application class, allowing initialization and setup
 * logic to be executed when the application starts.
 *
 * The @HiltAndroidApp annotation is used to enable Hilt for dependency injection.
 * Hilt is a dependency injection library for Android that simplifies the process
 * of managing dependencies and performing dependency injection in Android apps.
 *
 * @author Apoorv Gupta
 */
@HiltAndroidApp
class MyApplication : Application() {
    /**
     * Called when the application is starting.
     *
     * This method is overridden to provide a hook for initialization logic.
     * Any setup or initialization code specific to the application can be
     * placed here.
     */
    override fun onCreate() {
        super.onCreate()
        // Additional initialization logic can be added here
        // Based upon Variants and BUILD_TYPE we can enable Logging
        AppLogger.enableLogging()
    }
}
