/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */
package com.apoorvgupta.newsshots.ui.main

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import com.apoorvgupta.newsshots.ui.main.intents.MainIntent
import com.apoorvgupta.newsshots.ui.main.intents.MainNavEffect
import com.apoorvgupta.newsshots.ui.main.intents.MainViewStates
import com.apoorvgupta.newsshots.ui.main.ui.MainScreenContent
import com.apoorvgupta.newsshots.ui.main.viewmodels.MainViewModel

/**
 * Main destination composable function.
 *
 * This composable function represents the main content structure of the application.
 * It includes the navigation host, bottom app bar, and floating action button based on
 *
 * @author Apoorv Gupta
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainDestination(
    viewModel: MainViewModel,
) {
    val navController = rememberNavController()

    val viewState by viewModel.viewState.collectAsState()
    val navEffect = viewModel.effect

    /**
     * Handles navigation based on [MainNavEffect].
     *
     * @param navEvent The navigation event to handle.
     */
    fun handleNavigation(navEvent: MainNavEffect) {
        when (navEvent) {
            is MainNavEffect.BottomBarItemNavigation -> {
                // TODO: Optimization required after Sprint 2
            }

            is MainNavEffect.DrawerItemNavigation -> {
                // TODO: Optimization required after Sprint 2
            }

            is MainNavEffect.ToolbarItemNavigation -> {
                // TODO: Optimization required after Sprint 2
                // navController.navigate(Destinations.NotificationDestination.route)
            }
        }
    }

    // LaunchedEffect to trigger actions when the composable is launched.
    LaunchedEffect(Unit) {
        // Perform the FetchLoginData action when the composable is launched.
        viewModel.performAction(MainIntent.FetchNavigationScreenData)
        // Collect and handle navigation effects.
        navEffect.collect { handleNavigation(it) }
    }

    /**
     * Provides a function to handle user actions.
     *
     * @return A function that takes [MainIntent] as a parameter.
     */
    fun onUserAction(): (MainIntent) -> Unit =
        {
            // Perform the specified user action using the ViewModel.
            viewModel.performAction(it)
        }

    // Main content of the Splash Screen Destination.
    // Choose the appropriate content based on the current state of the Splash Screen.
    when (viewState.appViewState) {
        is MainViewStates.LoadedData -> {
            MainScreenContent(
                navController = navController,
                viewState = viewState.appViewState as MainViewStates.LoadedData,
                mainIntent = onUserAction(),
                viewModel = viewModel,
            )
        }

        is MainViewStates.Offline -> {
        }
    }
}
