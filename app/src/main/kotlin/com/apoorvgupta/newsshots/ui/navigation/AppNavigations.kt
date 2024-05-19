/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */
package com.apoorvgupta.newsshots.ui.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.apoorvgupta.bookmark.BookmarkScreen
import com.apoorvgupta.capabilities.presentation.navigation.Bookmark
import com.apoorvgupta.capabilities.presentation.navigation.Home
import com.apoorvgupta.capabilities.presentation.navigation.Search
import com.apoorvgupta.capabilities.presentation.navigation.Splash
import com.apoorvgupta.home.navigation.HomeScreenDestination
import com.apoorvgupta.home.viewmodels.HomeViewModel
import com.apoorvgupta.search.SearchScreen
import com.apoorvgupta.splash.navigation.SplashScreenDestination
import com.apoorvgupta.splash.viewmodel.SplashViewModel

/**
 * Defines the navigation graph for the Splash screen.
 *
 * @author Apoorv Gupta
 */
fun NavGraphBuilder.splashNavigationGraph(
    navController: NavHostController,
) {
    composable<Splash> {
        val viewModel: SplashViewModel = hiltViewModel()
        val viewState by viewModel.viewState.collectAsState()
        val effect = viewModel.effect

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
) {
    composable<Home> {
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
}

fun NavGraphBuilder.searchNavigationGraph() {
    composable<Search> {
        SearchScreen()
    }
}

fun NavGraphBuilder.bookmarkNavigationGraph() {
    composable<Bookmark> {
        BookmarkScreen()
    }
}
