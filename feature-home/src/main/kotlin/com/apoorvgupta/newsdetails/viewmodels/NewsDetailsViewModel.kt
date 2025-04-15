package com.apoorvgupta.newsdetails.viewmodels

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.apoorvgupta.capabilities.network.rest.data.newsshots.NewsShots
import com.apoorvgupta.core.base.BaseViewModel
import com.apoorvgupta.newsdetails.intent.NewsDetailsIntent
import com.apoorvgupta.newsdetails.intent.NewsDetailsNavEffect
import com.apoorvgupta.newsdetails.intent.NewsDetailsViewState
import com.apoorvgupta.newsdetails.intent.NewsDetailsViewStates
import com.apoorvgupta.newsdetails.models.NewsDetailsDataModel
import com.apoorvgupta.newsdetails.usecase.NewsDetailsScreenUseCase
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
class NewsDetailsViewModel @Inject constructor(
    private val newsDetailsScreenUseCase: NewsDetailsScreenUseCase
) : BaseViewModel<NewsDetailsIntent, NewsDetailsViewState, NewsDetailsNavEffect>() {

    private val _newsShotsPaginationResults: MutableStateFlow<PagingData<NewsShots>> =
        MutableStateFlow(value = PagingData.empty())

    val newsShotsPaginationResults: StateFlow<PagingData<NewsShots>> =
        _newsShotsPaginationResults.asStateFlow()

    override fun createInitialState(): NewsDetailsViewState = NewsDetailsViewState(
        NewsDetailsViewStates.UnInitialized)

    override fun handleIntent(intent: NewsDetailsIntent) {
        when (intent) {
            is NewsDetailsIntent.LoadNewsDetailsScreen -> {
                getNewsDetails(intent.postLink)
            }
            
            is NewsDetailsIntent.ToggleBookMark -> {
                
            }

            is NewsDetailsIntent.NavigateToChromeCustomTab -> {
                sendNavEffect { NewsDetailsNavEffect.OpenChromeCustomTab(intent.link) }
            }

            is NewsDetailsIntent.NavigateToIndividualNewsShots -> {
                sendNavEffect { NewsDetailsNavEffect.OpenIndividualNewsShots(intent.link) }
            }

            NewsDetailsIntent.NavigateToPreviousScreen -> {
                sendNavEffect { NewsDetailsNavEffect.OpenPreviousScreen }
            }

        }
    }

    private fun getNewsDetails(postLink: String) {
        emitLoading()
        viewModelScope.launch {
            newsDetailsScreenUseCase.getNewsDetailsContentData(postLink = postLink)
                .collect {
                    emitDetailsData(it)
                }
        }
    }

    private fun emitDetailsData(newsDetailsDataModel: NewsDetailsDataModel) {
        emitViewState {
            copy(
                newsDetailsViewState = NewsDetailsViewStates.LoadedData(
                    showLoader = false,
                    data = newsDetailsDataModel,
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
                newsDetailsViewState = NewsDetailsViewStates.InitialLoading(
                    showLoader = true,
                    data = NewsDetailsDataModel(),
                ),
            )
        }
    }
}