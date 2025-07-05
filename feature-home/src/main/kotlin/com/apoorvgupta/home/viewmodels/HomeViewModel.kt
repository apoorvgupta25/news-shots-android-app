package com.apoorvgupta.home.viewmodels

import androidx.lifecycle.viewModelScope
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

    override fun createInitialState(): HomeViewState = HomeViewState(HomeViewStates.UnInitialized)

    override fun handleIntent(intent: HomeIntent) {
        when (intent) {
            HomeIntent.LoadHomeScreen -> {
                getHomeData()
            }

            is HomeIntent.NavigateToNewsShotsListing -> {
                sendNavEffect { HomeNavEffect.OpenNewsShotsListingPage(intent.categoryName) }
            }

            is HomeIntent.NavigateToIndividualNewsShots -> {
                sendNavEffect { HomeNavEffect.OpenIndividualNewsShots(intent.postLink) }
            }
        }
    }

    private fun getHomeData() {
        viewModelScope.launch {
            homeScreenUseCase.getHomeScreenContentData().collect {
                emitHomeData(it)
            }
        }
    }

    private fun emitHomeData(homeDataModel: HomeDataModel) {
        val homeViewState = when (homeDataModel.status) {
            DataStatus.Success -> {
                HomeViewStates.LoadedData(
                    showLoader = false,
                    data = homeDataModel,
                )
            }

            DataStatus.Loading -> {
                HomeViewStates.Loading(
                    showLoader = true,
                    data = HomeDataModel(),
                )
            }

            DataStatus.Error,
            DataStatus.Offline,
            DataStatus.Empty -> {
                HomeViewStates.ErrorData(
                    showLoader = false,
                    data = homeDataModel,
                )
            }
        }

        emitViewState { copy(homeViewState = homeViewState) }
    }
}
