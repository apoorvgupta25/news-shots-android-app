package com.apoorvgupta.home.navigation

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.apoorvgupta.capabilities.presentation.reusableComponents.loader.CircularProgressBarComponent
import com.apoorvgupta.capabilities.presentation.theme.buttonBackgroundColor
import com.apoorvgupta.core.interactions.session.FinishActivityChannel
import com.apoorvgupta.home.intent.HomeIntent
import com.apoorvgupta.home.intent.HomeNavEffect
import com.apoorvgupta.home.intent.HomeViewStates
import com.apoorvgupta.home.view.home.HomeScreen
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
    val context = LocalContext.current

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
    @SuppressLint("RestrictedApi")
    fun handleNavigation(navEvent: HomeNavEffect) {
        when (navEvent) {
            is HomeNavEffect.OpenSettingsPage -> {
                // navController
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
    fun onUserAction(): (HomeIntent) -> Unit =
        {
            // Perform the specified user action using the ViewModel.
            homeViewModel.performAction(it)
        }

    // Main content of the Home Screen Destination.
    // Choose the appropriate content based on the current state of the Home Screen.

    when (homeViewState) {
        is HomeViewStates.LoadedData -> {
            // Display the Home Screen with loaded data.
//            CircularProgressBarComponent(homeViewState.showLoader)
            HomeScreen(
                state = homeViewState,
                userIntent = onUserAction(),
            )
        }

        is HomeViewStates.Error -> {
            CircularProgressBarComponent(homeViewState.showLoader)
            // Display content for the error state.
            Text(
                text = homeViewState.apiErrorContentModel.title,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.buttonBackgroundColor,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = homeViewState.apiErrorContentModel.subTitle,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.buttonBackgroundColor,
                fontWeight = FontWeight.Bold,
            )
        }

        is HomeViewStates.InitialLoading -> {
            CircularProgressBarComponent(homeViewState.showLoader)
//            HomeScreenShimmer(homeViewState.data.homeMetaData)
        }

        is HomeViewStates.Offline -> {
            CircularProgressBarComponent(homeViewState.showLoader)
            // Display content for the offline state.
            Text("Offline")
        }

        is HomeViewStates.UnInitialized -> {
            // Display content for the uninitialized state.
            homeViewModel.emitLoading()
        }
    }
}
