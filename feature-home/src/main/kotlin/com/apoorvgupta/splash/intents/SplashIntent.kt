package com.apoorvgupta.splash.intents

import com.apoorvgupta.core.base.NavEffect
import com.apoorvgupta.core.base.UserIntent
import com.apoorvgupta.core.base.ViewState

/**
 * Sealed class representing user intents for the splash screen.
 *
 * @author Apoorv Gupta
 */
sealed class SplashIntent : UserIntent {
    data object NavigateToHomeScreen : SplashIntent()
}

/**
 * Sealed class representing navigation effects for the login feature.
 *
 * @author Apoorv Gupta
 */
sealed class SplashNavEffect : NavEffect {
    data object OpenHomeScreen : SplashNavEffect()
}

/**
 * Sealed class representing different view states for the login feature.
 *
 * @author Apoorv Gupta
 */
sealed class SplashViewStates {
    data class LoadedData(
        val showLoader: Boolean = false,
    ) : SplashViewStates()

    data class InitialLoading(
        val showLoader: Boolean = false,
    ) : SplashViewStates()

    data object UnInitialized : SplashViewStates()
}

/**
 * Data class representing the overall view state for the splash feature.
 *
 * @param splashViewState The specific splash view state.
 */
data class SplashViewState(
    var splashViewState: SplashViewStates,
) : ViewState
