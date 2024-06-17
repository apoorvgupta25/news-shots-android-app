package com.apoorvgupta.home.intent

import com.apoorvgupta.core.base.NavEffect
import com.apoorvgupta.core.base.UserIntent
import com.apoorvgupta.core.base.ViewState
import com.apoorvgupta.core.models.ApiErrorModel
import com.apoorvgupta.core.models.OfflineErrorModel
import com.apoorvgupta.home.models.HomeDataModel

/**
 * Sealed class representing user intents for the home feature.
 *
 * @author Apoorv Gupta
 */
sealed class HomeIntent : UserIntent {
    data object LoadHomeScreen : HomeIntent()
    data object NavigateToDailyNewsShots : HomeIntent()
}

/**
 * Sealed class representing navigation effects for the home feature.
 *
 * @author Apoorv Gupta
 */
sealed class HomeNavEffect : NavEffect {
    data class OpenSearchPage(val userId: String) : HomeNavEffect()
    data object OpenDailyNewsShotsPage : HomeNavEffect()
}

/**
 * Sealed class representing different view states for the home feature.
 *
 * @author Apoorv Gupta
 */
sealed class HomeViewStates {
    data class LoadedData(
        val showLoader: Boolean = false,
        val isRefreshing: Boolean = false,
        val data: HomeDataModel,
    ) : HomeViewStates()

    data class Offline(
        val showLoader: Boolean = false,
        val isRefreshing: Boolean = false,
        val offlineErrorModel: OfflineErrorModel,
    ) : HomeViewStates()

    data class Error(
        val showLoader: Boolean = false,
        val isRefreshing: Boolean = false,
        val apiErrorContentModel: ApiErrorModel = ApiErrorModel.emptyValue,
    ) : HomeViewStates()

    data class InitialLoading(
        val showLoader: Boolean = false,
        val isRefreshing: Boolean = false,
        val data: HomeDataModel,
    ) : HomeViewStates()

    data object UnInitialized : HomeViewStates()
}

/**
 * Data class representing the overall view state for the home feature.
 *
 * @param homeViewState The specific home view state.
 */
data class HomeViewState(
    var homeViewState: HomeViewStates,
) : ViewState
