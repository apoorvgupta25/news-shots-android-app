package com.apoorvgupta.splash.viewmodel

import com.apoorvgupta.core.base.BaseViewModel
import com.apoorvgupta.splash.intents.SplashIntent
import com.apoorvgupta.splash.intents.SplashNavEffect
import com.apoorvgupta.splash.intents.SplashViewState
import com.apoorvgupta.splash.intents.SplashViewStates
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author Apoorv Gupta
 */

@HiltViewModel
class SplashViewModel @Inject constructor() : BaseViewModel<SplashIntent, SplashViewState, SplashNavEffect>() {

    /**
     * Initial state of the Login Screen.
     */
    override fun createInitialState(): SplashViewState = SplashViewState(SplashViewStates.UnInitialized)

    /**
     * Handle user intents for the Login Screen.
     *
     * @param intent The user intent triggering an action.
     */
    override fun handleIntent(intent: SplashIntent) {
        when (intent) {
            is SplashIntent.NavigateToHomeScreen -> {
                sendNavEffect { SplashNavEffect.OpenHomeScreen }
            }
        }
    }

    /**
     * Emits a loading state to update the UI when initial loading is in progress.
     */
    fun emitLoading() {
        emitViewState {
            copy(
                splashViewState = SplashViewStates.LoadedData(
                    showLoader = true,
                ),
            )
        }
    }
}
