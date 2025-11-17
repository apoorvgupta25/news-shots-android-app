package com.apoorvgupta.home.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.apoorvgupta.capabilities.presentation.navigation.NewsDetails
import com.apoorvgupta.capabilities.presentation.navigation.NewsShotsListing
import com.apoorvgupta.capabilities.presentation.navigation.Search
import com.apoorvgupta.capabilities.presentation.reusableComponents.loader.CircularProgressBarComponent
import com.apoorvgupta.core.interactions.session.FinishActivityChannel
import com.apoorvgupta.home.intent.HomeIntent
import com.apoorvgupta.home.intent.HomeNavEffect
import com.apoorvgupta.home.intent.HomeViewStates
import com.apoorvgupta.home.view.HomeScreenErrorContent
import com.apoorvgupta.home.view.HomeScreenLoadedContent
import com.apoorvgupta.home.viewmodels.HomeViewModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Apoorv Gupta
 */
@Composable
fun HomeScreenDestination(
    homeViewModel: HomeViewModel,
    homeViewState: HomeViewStates,
    navEffect: Flow<HomeNavEffect>,
    navController: NavController,
) {
    BackHandler {
        FinishActivityChannel.publish(
            true,
        )
    }
    /**
     * Handles navigation based on [HomeNavEffect].
     *
     * @param navEvent The navigation event to handle.
     */
    fun handleNavigation(navEvent: HomeNavEffect) {
        when (navEvent) {
            // Need to update
            HomeNavEffect.OpenSearchPage -> {
                navController.navigate(Search)
            }

            is HomeNavEffect.OpenNewsShotsListingPage -> {
                navController.navigate(
                    NewsShotsListing(
                        categoryName = navEvent.categoryName,
                    ),
                )
            }

            is HomeNavEffect.OpenIndividualNewsShots -> {
                navController.navigate(
                    NewsDetails(postLink = navEvent.postLink),
                )
            }
        }
    }

    // LaunchedEffect to trigger actions when the composable is launched.
    LaunchedEffect(Unit) {
        // Adding Base Section for Home
        // Perform the FetchHomeData action when the composable is launched.
        homeViewModel.performAction(HomeIntent.LoadHomeScreen)
        // Collect and handle navigation effects.
        navEffect.collect { handleNavigation(it) }
    }

    /**
     * Provides a function to handle user actions.
     *
     * @return A function that takes [HomeIntent] as a parameter.
     */
    fun onUserAction(): (HomeIntent) -> Unit = {
        // Perform the specified user action using the ViewModel.
        homeViewModel.performAction(it)
    }

    // Main content of the Home Screen Destination.
    // Choose the appropriate content based on the current state of the Home Screen.

    when (homeViewState) {
        is HomeViewStates.LoadedData -> {
            // Display the Home Screen with loaded data.
            HomeScreenLoadedContent(
                state = homeViewState,
                userIntent = onUserAction(),
            )
        }

        is HomeViewStates.ErrorData -> {
            // Display the Home Screen with error data.
            HomeScreenErrorContent(
                state = homeViewState,
                userIntent = onUserAction(),
            )
        }

        is HomeViewStates.Loading -> {
            CircularProgressBarComponent(homeViewState.showLoader)
        }

        HomeViewStates.UnInitialized -> {
            // Do Nothing.
        }
    }
}
