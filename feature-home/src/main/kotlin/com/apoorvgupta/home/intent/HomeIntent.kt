package com.apoorvgupta.home.intent

import androidx.compose.ui.unit.Dp
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
}

/**
 * Sealed class representing UI intents for the home screen.
 *
 * @author Apoorv Gupta
 */
sealed class HomeUIIntent {
    data class ShowMessage(val message: String, val imageUrl: String, val imageSize: Dp) : HomeUIIntent()
}

/**
 * Sealed class representing navigation effects for the home feature.
 *
 * @author Apoorv Gupta
 */
sealed class HomeNavEffect : NavEffect {
    data class OpenSearchPage(val userId: String) : HomeNavEffect()
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
        val trackedSections: MutableList<Boolean> = MutableList(1) { false },
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
