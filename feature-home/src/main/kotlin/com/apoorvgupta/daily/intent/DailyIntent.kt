package com.apoorvgupta.daily.intent

import com.apoorvgupta.core.base.NavEffect
import com.apoorvgupta.core.base.UserIntent
import com.apoorvgupta.core.base.ViewState
import com.apoorvgupta.core.models.ApiErrorModel
import com.apoorvgupta.core.models.OfflineErrorModel
import com.apoorvgupta.daily.models.DailyDataModel

/**
 * Sealed class representing user intents for the daily feature.
 *
 * @author Apoorv Gupta
 */
sealed class DailyIntent : UserIntent {
    data object LoadDailyScreen : DailyIntent()
}

/**
 * Sealed class representing navigation effects for the daily feature.
 *
 * @author Apoorv Gupta
 */
sealed class DailyNavEffect : NavEffect {
    data class OpenIndividualNewsShots(val userId: String) : DailyNavEffect()
}

/**
 * Sealed class representing different view states for the daily feature.
 *
 * @author Apoorv Gupta
 */
sealed class DailyViewStates {
    data class LoadedData(
        val showLoader: Boolean = false,
        val isRefreshing: Boolean = false,
        val data: DailyDataModel,
    ) : DailyViewStates()

    data class Offline(
        val showLoader: Boolean = false,
        val isRefreshing: Boolean = false,
        val offlineErrorModel: OfflineErrorModel,
    ) : DailyViewStates()

    data class Error(
        val showLoader: Boolean = false,
        val isRefreshing: Boolean = false,
        val apiErrorContentModel: ApiErrorModel = ApiErrorModel.emptyValue,
    ) : DailyViewStates()

    data class InitialLoading(
        val showLoader: Boolean = false,
        val isRefreshing: Boolean = false,
        val data: DailyDataModel,
    ) : DailyViewStates()

    data object UnInitialized : DailyViewStates()
}

/**
 * Data class representing the overall view state for the daily feature.
 *
 * @param dailyViewState The specific daily view state.
 */
data class DailyViewState(
    var dailyViewState: DailyViewStates,
) : ViewState
