package com.apoorvgupta.home.viewmodels

import androidx.lifecycle.viewModelScope
import com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase.GetRecentNewsShotsUseCase
import com.apoorvgupta.capabilities.network.rest.helpers.Resource
import com.apoorvgupta.core.base.BaseViewModel
import com.apoorvgupta.core.utils.DataStatus
import com.apoorvgupta.home.intent.HomeIntent
import com.apoorvgupta.home.intent.HomeNavEffect
import com.apoorvgupta.home.intent.HomeViewState
import com.apoorvgupta.home.intent.HomeViewStates
import com.apoorvgupta.home.models.HomeDataModel
import com.apoorvgupta.home.usecase.HomeScreenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel class for the home screen.
 *
 * @author Apoorv Gupta
 */

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeScreenUseCase: HomeScreenUseCase,
) : BaseViewModel<HomeIntent, HomeViewState, HomeNavEffect>() {

    private var homeDataModel: HomeDataModel = HomeDataModel()

    override fun createInitialState(): HomeViewState {
        return HomeViewState(HomeViewStates.UnInitialized)
    }

    override fun handleIntent(intent: HomeIntent) {
        when (intent) {
            HomeIntent.LoadHomeScreen -> {
                getHomeData()
            }
        }
    }

    private fun getHomeData() {
        viewModelScope.launch {
            homeScreenUseCase.getHomeScreenContentData().collect {
                emitHomeData(it)
            }
            /*getRecentNewsShotsUseCase.getRecentNewsShots().collect {
                when (it.status) {
                    Resource.Status.LOADING -> {
                        // Loader
                    }

                    Resource.Status.SUCCESS -> {
                        homeDataModel = homeDataModel.copy(
                            newsShotsList = it.data ?: emptyList(),
                        )
                        emitHomeData(homeDataModel)
                    }

                    else -> {
                        homeDataModel = homeDataModel.copy(
                            newsShotsList = emptyList(),
                        )
                        emitHomeData(homeDataModel)
                    }
                }
            }*/
        }
    }

    private fun emitHomeData(homeDataModel: HomeDataModel) {
        emitViewState {
            copy(
                homeViewState = HomeViewStates.LoadedData(
                    showLoader = false,
                    data = homeDataModel,
                ),
            )
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
