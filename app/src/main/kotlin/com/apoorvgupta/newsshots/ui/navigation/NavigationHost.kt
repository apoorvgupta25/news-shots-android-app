/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */
package com.apoorvgupta.newsshots.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.apoorvgupta.capabilities.presentation.navigation.BaseComponentState
import kotlinx.coroutines.CoroutineScope

/**
 * NavigationHost composable function.
 *
 * This composable function represents the navigation host for the Newsshots Android application.
 * It is responsible for defining the navigation graph using Jetpack Compose Navigation.
 *
 * @param navController The NavHostController responsible for navigating between destinations.
 * @param baseComponentState The base component state that affects the app component's visibility behavior.
 *
 * @author Apoorv Gupta
 */
@Composable
fun NavigationHost(
    navController: NavHostController,
    startDestination: MutableState<String>,
    baseComponentState: BaseComponentState,
    drawerState: DrawerState,
    coroutineScope: CoroutineScope,
    paddingTop: Dp,
) {
    // NavHost is used to define the navigation graph with various destination composable functions.
    NavHost(
        navController = navController,
        startDestination = startDestination.value,
        modifier = Modifier.padding(top = paddingTop),
//        enterTransition = { EnterTransition.None },
//        exitTransition = { ExitTransition.None },
    ) {
        // Define the navigation graph using destination composable functions for each screen.
        splashNavigationGraph(
            navController = navController,
            baseComponentState = baseComponentState,
        )

        homeNavigationGraph(
            navController = navController,
            baseComponentState = baseComponentState,
        )
    }
}
