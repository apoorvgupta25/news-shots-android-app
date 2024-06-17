package com.apoorvgupta.newsshots.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.apoorvgupta.capabilities.presentation.navigation.NewsShotsListing
import com.apoorvgupta.capabilities.presentation.reusableComponents.loader.CircularProgressBarComponent
import com.apoorvgupta.capabilities.presentation.theme.buttonBackgroundColor
import com.apoorvgupta.newsshots.intent.NewsShotsListingIntent
import com.apoorvgupta.newsshots.intent.NewsShotsListingNavEffect
import com.apoorvgupta.newsshots.intent.NewsShotsListingViewStates
import com.apoorvgupta.newsshots.view.NewsShotsListingScreen
import com.apoorvgupta.newsshots.viewmodels.NewsShotsListingViewModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Apoorv Gupta
 */

@Composable
fun NewsShotsListingScreenDestination(
    newsShotsListingViewModel: NewsShotsListingViewModel,
    newsShotsListingViewState: NewsShotsListingViewStates,
    navEffect: Flow<NewsShotsListingNavEffect>,
    arg: NewsShotsListing,
    navController: NavController,
) {
    /**
     * Handles navigation based on [NewsShotsListingNavEffect].
     *
     * @param navEvent The navigation event to handle.
     */
    fun handleNavigation(navEvent: NewsShotsListingNavEffect) {
        when (navEvent) {
            is NewsShotsListingNavEffect.OpenIndividualNewsShots -> {
            }
        }
    }

    // LaunchedEffect to trigger actions when the composable is launched.
    LaunchedEffect(Unit) {
        // Perform the LoadNewsShotsListingScreen action when the composable is launched.
        newsShotsListingViewModel.performAction(NewsShotsListingIntent.LoadNewsShotsListingScreen(arg.categoryName))
        // Collect and handle navigation effects.
        navEffect.collect { handleNavigation(it) }
    }

    /**
     * Provides a function to handle user actions.
     *
     * @return A function that takes [NewsShotsListingIntent] as a parameter.
     */
    fun onUserAction(): (NewsShotsListingIntent) -> Unit =
        {
            // Perform the specified user action using the ViewModel.
            newsShotsListingViewModel.performAction(it)
        }

    // Main content of the NewsShots Listing Screen Destination.
    // Choose the appropriate content based on the current state of the NewsShots Listing Screen.
    when (newsShotsListingViewState) {
        is NewsShotsListingViewStates.LoadedData -> {
            // Display the NewsShots Listing Screen with loaded data.
            NewsShotsListingScreen(
                viewModel = newsShotsListingViewModel,
                userIntent = onUserAction(),
            )
        }

        is NewsShotsListingViewStates.Error -> {
            CircularProgressBarComponent(newsShotsListingViewState.showLoader)
            // Display content for the error state.
            Text(
                text = newsShotsListingViewState.apiErrorContentModel.title,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.buttonBackgroundColor,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = newsShotsListingViewState.apiErrorContentModel.subTitle,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.buttonBackgroundColor,
                fontWeight = FontWeight.Bold,
            )
        }

        is NewsShotsListingViewStates.InitialLoading -> {
            CircularProgressBarComponent(newsShotsListingViewState.showLoader)
        }

        is NewsShotsListingViewStates.Offline -> {
            CircularProgressBarComponent(newsShotsListingViewState.showLoader)
            // Display content for the offline state.
            Text("Offline")
        }

        is NewsShotsListingViewStates.UnInitialized -> {
            // Display content for the uninitialized state.
            newsShotsListingViewModel.emitLoading()
        }
    }
}
