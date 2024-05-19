package com.apoorvgupta.home.viewmodels

import com.apoorvgupta.core.base.BaseViewModel
import com.apoorvgupta.core.utils.DataStatus
import com.apoorvgupta.home.intent.HomeIntent
import com.apoorvgupta.home.intent.HomeNavEffect
import com.apoorvgupta.home.intent.HomeViewState
import com.apoorvgupta.home.intent.HomeViewStates
import com.apoorvgupta.home.models.HomeDataModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * ViewModel class for the home screen.
 *
 * @author Apoorv Gupta
 */

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel<HomeIntent, HomeViewState, HomeNavEffect>() {

    private var homeDataModel: HomeDataModel = HomeDataModel()

    override fun createInitialState(): HomeViewState {
        return HomeViewState(HomeViewStates.UnInitialized)
    }

    override fun handleIntent(intent: HomeIntent) {
        when (intent) {
            HomeIntent.LoadHomeScreen -> {
                homeDataModel = homeDataModel.copy(status = DataStatus.Success)
                emitRefreshDataContent(homeDataModel)
            }
        }
    }

    private fun emitRefreshDataContent(homeDataModel: HomeDataModel) {
        when (homeDataModel.status) {
            DataStatus.Success -> {
                emitViewState {
                    copy(
                        homeViewState = HomeViewStates.LoadedData(
                            showLoader = false,
                            data = homeDataModel,
                        ),
                    )
                }
            }

            else -> {
                // Do Nothing
            }
        }
    }

    /**
     * Emits a loading state to update the UI when initial loading is in progress.
     */
    fun emitLoading() {
        emitViewState {
            copy(
                homeViewState = HomeViewStates.InitialLoading(
                    showLoader = true,
                    data = HomeDataModel(),
                ),
            )
        }
    }
}
