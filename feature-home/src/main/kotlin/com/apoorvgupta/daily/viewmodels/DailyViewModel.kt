package com.apoorvgupta.daily.viewmodels

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.apoorvgupta.capabilities.network.rest.data.newsshots.NewsShots
import com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase.GetAllNewsShotsUseCase
import com.apoorvgupta.core.base.BaseViewModel
import com.apoorvgupta.daily.intent.DailyIntent
import com.apoorvgupta.daily.intent.DailyNavEffect
import com.apoorvgupta.daily.intent.DailyViewState
import com.apoorvgupta.daily.intent.DailyViewStates
import com.apoorvgupta.daily.models.DailyDataModel
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
class DailyViewModel @Inject constructor(
    private val getAllNewsShotsUseCase: GetAllNewsShotsUseCase,
) : BaseViewModel<DailyIntent, DailyViewState, DailyNavEffect>() {

    private var dailyDataModel: DailyDataModel = DailyDataModel()

    private val _newsShotsPaginationResults: MutableStateFlow<PagingData<NewsShots>> =
        MutableStateFlow(value = PagingData.empty())

    val newsShotsPaginationResults: StateFlow<PagingData<NewsShots>> =
        _newsShotsPaginationResults.asStateFlow()

    override fun createInitialState(): DailyViewState {
        return DailyViewState(DailyViewStates.UnInitialized)
    }

    override fun handleIntent(intent: DailyIntent) {
        when (intent) {
            DailyIntent.LoadDailyScreen -> {
                getDailyData()
            }
        }
    }

    private fun getDailyData() {
        viewModelScope.launch {
            getAllNewsShotsUseCase.getAllNewsShots().cachedIn(viewModelScope).collect {
                _newsShotsPaginationResults.value = it
                emitDailyData(dailyDataModel)
            }
        }
    }

    private fun emitDailyData(dailyDataModel: DailyDataModel) {
        emitViewState {
            copy(
                dailyViewState = DailyViewStates.LoadedData(
                    showLoader = false,
                    data = dailyDataModel,
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
                dailyViewState = DailyViewStates.InitialLoading(
                    showLoader = true,
                    data = DailyDataModel(),
                ),
            )
        }
    }
}
