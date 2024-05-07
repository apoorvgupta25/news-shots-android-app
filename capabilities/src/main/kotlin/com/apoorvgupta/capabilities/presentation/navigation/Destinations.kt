/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.capabilities.presentation.navigation

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

/*    private fun appendArguments(routeBuilder: StringBuilder, args: Array<out NavArgument>) {
        var isFirstOptional = true
        args.forEach { arg ->
            if (arg.optional) {
                if (arg.key == null) {
                    Log.e("Destinations", "Exception: Key cannot be null for optional argument")
                } else {
                    routeBuilder.append(if (isFirstOptional) "?" else "&").append(arg.key).append("=").append(arg.argument)
                    isFirstOptional = false
                }
            } else {
                routeBuilder.append("/").append(arg.argument)
            }
        }
    }

    fun withArguments(vararg args: NavArgument): String {
        val routeBuilder = StringBuilder(route)
        appendArguments(routeBuilder, args)
        return routeBuilder.toString()
    }

    fun String.toNavArgument(optional: Boolean = false, key: String? = null): NavArgument {
        if (optional && key == null) {
            throw IllegalArgumentException("Key cannot be null for optional argument")
        }
        return NavArgument(this, optional, key)
    }*/
}
