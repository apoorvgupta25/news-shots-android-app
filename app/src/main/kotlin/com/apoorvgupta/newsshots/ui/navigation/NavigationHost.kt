/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */
package com.apoorvgupta.newsshots.ui.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.apoorvgupta.capabilities.presentation.navigation.Splash

/**
 * NavigationHost composable function.
 *
 * This composable function represents the navigation host for the Newsshots Android application.
 * It is responsible for defining the navigation graph using Jetpack Compose Navigation.
 *
 * @param navController The NavHostController responsible for navigating between destinations.
 *
 * @author Apoorv Gupta
 */
@Composable
fun NavigationHost(
    navController: NavHostController,
    paddingTop: Dp,
) {
    // NavHost is used to define the navigation graph with various destination composable functions.
    NavHost(
        navController = navController,
        startDestination = Splash,
        modifier = Modifier.padding(top = paddingTop),
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
    ) {
        // Define the navigation graph using destination composable functions for each screen.
        splashNavigationGraph(
            navController = navController,
        )

        homeNavigationGraph(
            navController = navController,
        )

        searchNavigationGraph(
            navController = navController,
        )

        bookmarkNavigationGraph(
            navController = navController,
        )
    }
}
