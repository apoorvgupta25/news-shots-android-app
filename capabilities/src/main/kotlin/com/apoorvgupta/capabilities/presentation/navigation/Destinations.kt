/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.capabilities.presentation.navigation

import kotlinx.serialization.Serializable

/**
 * Sealed class representing different destinations in the app.
 *
 * @author Apoorv Gupta
 */
sealed class Destinations(val route: String) {
    companion object {
        // Splash
        const val SPLASH_ROUTE = "splash_route"

        // Home
        const val HOME_ROUTE = "home_route"
    }

    object SplashDestination : Destinations(
        route = SPLASH_ROUTE,
    )

    object HomeDestination : Destinations(
        route = HOME_ROUTE,
    )

    /**
     * Create route arguments that can navigate your screen with arguments.
     */
    fun withArguments(vararg args: Any): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}

// Splash Destination
@Serializable
object Splash

// Home Destination
@Serializable
object Home
