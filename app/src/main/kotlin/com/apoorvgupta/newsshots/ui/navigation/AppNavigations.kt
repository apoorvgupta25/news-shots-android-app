/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */
package com.apoorvgupta.newsshots.ui.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.apoorvgupta.capabilities.presentation.navigation.BaseComponentState
import com.apoorvgupta.capabilities.presentation.navigation.Bookmark
import com.apoorvgupta.capabilities.presentation.navigation.Home
import com.apoorvgupta.capabilities.presentation.navigation.Search
import com.apoorvgupta.capabilities.presentation.navigation.Splash
import com.apoorvgupta.home.navigation.HomeScreenDestination
import com.apoorvgupta.home.view.home.CommonScreen
import com.apoorvgupta.home.viewmodels.HomeViewModel
import com.apoorvgupta.splash.navigation.SplashScreenDestination
import com.apoorvgupta.splash.viewmodel.SplashViewModel

/**
 * Defines the navigation graph for the Splash screen.
 *
 * @author Apoorv Gupta
 */
fun NavGraphBuilder.splashNavigationGraph(
    navController: NavHostController,
    baseComponentState: BaseComponentState,
) {
    composable<Splash> {
        // Hide bottom bar and floating action button for the splash screen
        hideBottomBar(baseComponentState)
        hideFloatingActionButton(baseComponentState)

        val viewModel: SplashViewModel = hiltViewModel()
        val viewState by viewModel.viewState.collectAsState()
        val effect = viewModel.effect
        val context = LocalContext.current

        // Display the SplashScreen composable
        SplashScreenDestination(
            splashViewModel = viewModel,
            splashViewState = viewState.splashViewState,
            navEffect = effect,
            navController = navController,
        )
    }
}

/**
 * Defines the navigation graph for the Home screen.
 */
fun NavGraphBuilder.homeNavigationGraph(
    navController: NavHostController,
    baseComponentState: BaseComponentState,
) {
    composable<Home> {
        // Show bottom bar and hide floating action button for the home screen
        showBottomBar(baseComponentState)
        hideFloatingActionButton(baseComponentState)

        val viewModel: HomeViewModel = hiltViewModel()
        val viewState by viewModel.viewState.collectAsState()
        val effect = viewModel.effect

        HomeScreenDestination(
            homeViewModel = viewModel,
            homeViewState = viewState.homeViewState,
            navEffect = effect,
            navController = navController,
        )
    }

    composable<Search> {
        showBottomBar(baseComponentState)
        hideFloatingActionButton(baseComponentState)
        CommonScreen(title = "Search")
    }

    composable<Bookmark> {
        showBottomBar(baseComponentState)
        hideFloatingActionButton(baseComponentState)
        CommonScreen(title = "Bookmark")
    }
}

/**
 * Utility function to hide the bottom navigation bar.
 */
fun hideBottomBar(baseComponentState: BaseComponentState) {
    baseComponentState.displayBottomNavigationBar.value = false
}

/**
 * Utility function to show the bottom navigation bar.
 */
fun showBottomBar(baseComponentState: BaseComponentState) {
    baseComponentState.displayBottomNavigationBar.value = true
}

/**
 * Utility function to hide the floating action button.
 */
fun hideFloatingActionButton(baseComponentState: BaseComponentState) {
    baseComponentState.displayFloatingActionButton.value = false
}

/**
 * Utility function to show the floating action button.
 */
fun showFloatingActionButton(baseComponentState: BaseComponentState) {
    baseComponentState.displayFloatingActionButton.value = true
}
