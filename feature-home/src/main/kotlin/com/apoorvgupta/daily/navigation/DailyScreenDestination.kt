package com.apoorvgupta.daily.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.apoorvgupta.capabilities.presentation.reusableComponents.loader.CircularProgressBarComponent
import com.apoorvgupta.capabilities.presentation.theme.buttonBackgroundColor
import com.apoorvgupta.daily.intent.DailyIntent
import com.apoorvgupta.daily.intent.DailyNavEffect
import com.apoorvgupta.daily.intent.DailyViewStates
import com.apoorvgupta.daily.view.DailyScreen
import com.apoorvgupta.daily.viewmodels.DailyViewModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Apoorv Gupta
 */

@Composable
fun DailyScreenDestination(
    dailyViewModel: DailyViewModel,
    dailyViewState: DailyViewStates,
    navEffect: Flow<DailyNavEffect>,
    navController: NavController,
) {
    /**
     * Handles navigation based on [DailyNavEffect].
     *
     * @param navEvent The navigation event to handle.
     */
    fun handleNavigation(navEvent: DailyNavEffect) {
        when (navEvent) {
            is DailyNavEffect.OpenIndividualNewsShots -> {
            }
        }
    }

    // LaunchedEffect to trigger actions when the composable is launched.
    LaunchedEffect(Unit) {
        // Perform the LoadDailyScreen action when the composable is launched.
        dailyViewModel.performAction(DailyIntent.LoadDailyScreen)
        // Collect and handle navigation effects.
        navEffect.collect { handleNavigation(it) }
    }

    /**
     * Provides a function to handle user actions.
     *
     * @return A function that takes [DailyIntent] as a parameter.
     */
    fun onUserAction(): (DailyIntent) -> Unit =
        {
            // Perform the specified user action using the ViewModel.
            dailyViewModel.performAction(it)
        }

    // Main content of the Daily Screen Destination.
    // Choose the appropriate content based on the current state of the Daily Screen.
    when (dailyViewState) {
        is DailyViewStates.LoadedData -> {
            // Display the Daily Screen with loaded data.
            DailyScreen(
                viewModel = dailyViewModel,
                userIntent = onUserAction(),
            )
        }

        is DailyViewStates.Error -> {
            CircularProgressBarComponent(dailyViewState.showLoader)
            // Display content for the error state.
            Text(
                text = dailyViewState.apiErrorContentModel.title,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.buttonBackgroundColor,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = dailyViewState.apiErrorContentModel.subTitle,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.buttonBackgroundColor,
                fontWeight = FontWeight.Bold,
            )
        }

        is DailyViewStates.InitialLoading -> {
            CircularProgressBarComponent(dailyViewState.showLoader)
        }

        is DailyViewStates.Offline -> {
            CircularProgressBarComponent(dailyViewState.showLoader)
            // Display content for the offline state.
            Text("Offline")
        }

        is DailyViewStates.UnInitialized -> {
            // Display content for the uninitialized state.
            dailyViewModel.emitLoading()
        }
    }
}
