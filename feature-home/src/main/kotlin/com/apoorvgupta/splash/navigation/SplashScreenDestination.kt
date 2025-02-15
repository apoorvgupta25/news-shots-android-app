package com.apoorvgupta.splash.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.apoorvgupta.capabilities.presentation.navigation.Home
import com.apoorvgupta.capabilities.presentation.reusableComponents.loader.CircularProgressBarComponent
import com.apoorvgupta.splash.intents.SplashIntent
import com.apoorvgupta.splash.intents.SplashNavEffect
import com.apoorvgupta.splash.intents.SplashViewStates
import com.apoorvgupta.splash.view.SplashScreen
import com.apoorvgupta.splash.viewmodel.SplashViewModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Apoorv Gupta
 */

@Composable
fun SplashScreenDestination(
    splashViewModel: SplashViewModel,
    splashViewState: SplashViewStates,
    navEffect: Flow<SplashNavEffect>,
    navController: NavController,
) {
    /**
     * Handles navigation based on [SplashNavEffect].
     *
     * @param navEvent The navigation event to handle.
     */
    fun handleNavigation(navEvent: SplashNavEffect) {
        when (navEvent) {
            SplashNavEffect.OpenHomeScreen -> {
                navController.popBackStack()
                navController.navigate(Home)
            }
        }
    }

    // LaunchedEffect to trigger actions when the composable is launched.
    LaunchedEffect(Unit) {
        // Collect and handle navigation effects.
        navEffect.collect { handleNavigation(it) }
    }

    /**
     * Provides a function to handle user actions.
     *
     * @return A function that takes [SplashIntent] as a parameter.
     */
    fun onUserAction(): (SplashIntent) -> Unit = {
        // Perform the specified user action using the ViewModel.
        splashViewModel.performAction(it)
    }

    // Main content of the Splash Screen Destination.
    // Choose the appropriate content based on the current state of the Splash Screen.
    when (splashViewState) {
        is SplashViewStates.LoadedData -> {
            // Display the Splash Screen with loaded data.
            SplashScreen(
                state = splashViewState,
                userIntent = onUserAction(),
            )
        }

        is SplashViewStates.InitialLoading -> {
            CircularProgressBarComponent(splashViewState.showLoader)
        }

        is SplashViewStates.UnInitialized -> {
            // Display content for the uninitialized state.
            splashViewModel.emitLoading()
        }
    }
}
