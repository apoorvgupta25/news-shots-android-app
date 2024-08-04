package com.apoorvgupta.newsshots.viewmodels

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.apoorvgupta.capabilities.network.rest.data.newsshots.NewsShots
import com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase.GetAllNewsShotsUseCase
import com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase.GetNewsShotsByCategoryUseCase
import com.apoorvgupta.capabilities.util.Constants.DAILY
import com.apoorvgupta.core.base.BaseViewModel
import com.apoorvgupta.newsshots.intent.NewsShotsListingIntent
import com.apoorvgupta.newsshots.intent.NewsShotsListingNavEffect
import com.apoorvgupta.newsshots.intent.NewsShotsListingViewState
import com.apoorvgupta.newsshots.intent.NewsShotsListingViewStates
import com.apoorvgupta.newsshots.models.NewsShotsListingDataModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Apoorv Gupta
 */

@HiltViewModel
class NewsShotsListingViewModel @Inject constructor(
    private val getAllNewsShotsUseCase: GetAllNewsShotsUseCase,
    private val getNewsShotsByCategoryUseCase: GetNewsShotsByCategoryUseCase,
) : BaseViewModel<NewsShotsListingIntent, NewsShotsListingViewState, NewsShotsListingNavEffect>() {

    private val _newsShotsPaginationResults: MutableStateFlow<PagingData<NewsShots>> =
        MutableStateFlow(value = PagingData.empty())

    val newsShotsPaginationResults: StateFlow<PagingData<NewsShots>> =
        _newsShotsPaginationResults.asStateFlow()

    override fun createInitialState(): NewsShotsListingViewState {
        return NewsShotsListingViewState(NewsShotsListingViewStates.UnInitialized)
    }

    override fun handleIntent(intent: NewsShotsListingIntent) {
        when (intent) {
            is NewsShotsListingIntent.LoadNewsShotsListingScreen -> {
                getDailyData(intent.categoryName)
            }

            is NewsShotsListingIntent.NavigateToIndividualNewsShots -> {
                sendNavEffect { NewsShotsListingNavEffect.OpenIndividualNewsShots(intent.link) }
            }

            NewsShotsListingIntent.NavigateToPreviousScreen -> {
                sendNavEffect { NewsShotsListingNavEffect.OpenPreviousScreen }
            }
        }
    }

    private fun getDailyData(categoryName: String) {
        viewModelScope.launch {
            if (categoryName.equals(DAILY, true)) {
                getAllNewsShotsUseCase.getAllNewsShots().cachedIn(viewModelScope).collect {
                    _newsShotsPaginationResults.value = it
                    emitDailyData(categoryName)
                }
            } else {
                getNewsShotsByCategoryUseCase.getNewsShotsByCategory(categoryName = categoryName)
                    .cachedIn(viewModelScope).collect {
                        _newsShotsPaginationResults.value = it
                        emitDailyData(categoryName)
                    }
            }
        }
    }

    private fun emitDailyData(headingText: String) {
        emitViewState {
            copy(
                newsShotsListingViewState = NewsShotsListingViewStates.LoadedData(
                    showLoader = false,
                    data = NewsShotsListingDataModel(
                        headingText = headingText,
                    ),
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
                newsShotsListingViewState = NewsShotsListingViewStates.InitialLoading(
                    showLoader = true,
                    data = NewsShotsListingDataModel(),
                ),
            )
        }
    }
}
