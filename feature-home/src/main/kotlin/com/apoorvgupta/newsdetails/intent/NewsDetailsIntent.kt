package com.apoorvgupta.newsdetails.intent

import com.apoorvgupta.core.base.NavEffect
import com.apoorvgupta.core.base.UserIntent
import com.apoorvgupta.core.base.ViewState
import com.apoorvgupta.newsdetails.models.NewsDetailsDataModel

/**
 * Sealed class representing user intents for the News Details.
 *
 * @author Apoorv Gupta
 */
sealed class NewsDetailsIntent : UserIntent {
    data class LoadNewsDetailsScreen(val postLink: String) : NewsDetailsIntent()
    data class ToggleBookMark(val link: String) : NewsDetailsIntent()
    data class NavigateToIndividualNewsShots(val link: String) : NewsDetailsIntent()
    data class NavigateToChromeCustomTab(val link: String) : NewsDetailsIntent()
    data object NavigateToPreviousScreen : NewsDetailsIntent()
    data object RefreshNewsDetailsScreen : NewsDetailsIntent()
}

/**
 * Sealed class representing navigation effects for the News Details.
 *
 * @author Apoorv Gupta
 */
sealed class NewsDetailsNavEffect : NavEffect {
    data class OpenIndividualNewsShots(val postLink: String) : NewsDetailsNavEffect()
    data class OpenChromeCustomTab(val link: String) : NewsDetailsNavEffect()
    data object OpenPreviousScreen : NewsDetailsNavEffect()
}

/**
 * Sealed class representing different view states for the News Details.
 *
 * @author Apoorv Gupta
 */
sealed class NewsDetailsViewStates {
    data class LoadedData(
        val showLoader: Boolean = false,
        val data: NewsDetailsDataModel,
    ) : NewsDetailsViewStates()

    data class ErrorData(
        val showLoader: Boolean = false,
        val data: NewsDetailsDataModel,
    ) : NewsDetailsViewStates()


    data class Loading(
        val showLoader: Boolean = false,
        val data: NewsDetailsDataModel,
    ) : NewsDetailsViewStates()

    data object UnInitialized : NewsDetailsViewStates()
}

/**
 * Data class representing the overall view state for the News Details.
 *
 * @param newsDetailsViewState The specific News Details view state.
 */
data class NewsDetailsViewState(
    var newsDetailsViewState: NewsDetailsViewStates,
) : ViewState
