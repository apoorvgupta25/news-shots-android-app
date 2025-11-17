package com.apoorvgupta.newsdetails.viewmodels

import androidx.lifecycle.viewModelScope
import com.apoorvgupta.core.base.BaseViewModel
import com.apoorvgupta.core.utils.DataStatus
import com.apoorvgupta.core.utils.emptyValue
import com.apoorvgupta.newsdetails.intent.NewsDetailsIntent
import com.apoorvgupta.newsdetails.intent.NewsDetailsNavEffect
import com.apoorvgupta.newsdetails.intent.NewsDetailsViewState
import com.apoorvgupta.newsdetails.intent.NewsDetailsViewStates
import com.apoorvgupta.newsdetails.models.NewsDetailsDataModel
import com.apoorvgupta.newsdetails.usecase.NewsDetailsScreenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Apoorv Gupta
 */
@HiltViewModel
class NewsDetailsViewModel @Inject constructor(
    private val newsDetailsScreenUseCase: NewsDetailsScreenUseCase,
) : BaseViewModel<NewsDetailsIntent, NewsDetailsViewState, NewsDetailsNavEffect>() {

    private var postLink: String = String.emptyValue()

    override fun createInitialState(): NewsDetailsViewState = NewsDetailsViewState(NewsDetailsViewStates.UnInitialized)

    override fun handleIntent(intent: NewsDetailsIntent) {
        when (intent) {
            is NewsDetailsIntent.LoadNewsDetailsScreen -> {
                postLink = intent.postLink
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

            NewsDetailsIntent.RefreshNewsDetailsScreen -> {
                getNewsDetails(postLink)
            }
        }
    }

    private fun getNewsDetails(postLink: String) {
        viewModelScope.launch {
            newsDetailsScreenUseCase.getNewsDetailsContentData(postLink = postLink)
                .collect {
                    emitDetailsData(it)
                }
        }
    }

    private fun emitDetailsData(newsDetailsDataModel: NewsDetailsDataModel) {
        val newsDetailsViewState = when (newsDetailsDataModel.status) {
            DataStatus.Success -> {
                NewsDetailsViewStates.LoadedData(
                    showLoader = false,
                    data = newsDetailsDataModel,
                )
            }

            DataStatus.Loading -> {
                NewsDetailsViewStates.Loading(
                    showLoader = true,
                    data = NewsDetailsDataModel(),
                )
            }

            DataStatus.Error,
            DataStatus.Offline,
            DataStatus.Empty,
            -> {
                NewsDetailsViewStates.ErrorData(
                    showLoader = false,
                    data = newsDetailsDataModel,
                )
            }
        }

        emitViewState { copy(newsDetailsViewState = newsDetailsViewState) }
    }
}
