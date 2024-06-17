package com.apoorvgupta.newsshots.intent

import com.apoorvgupta.core.base.NavEffect
import com.apoorvgupta.core.base.UserIntent
import com.apoorvgupta.core.base.ViewState
import com.apoorvgupta.core.models.ApiErrorModel
import com.apoorvgupta.core.models.OfflineErrorModel
import com.apoorvgupta.newsshots.models.NewsShotsListingDataModel

/**
 * Sealed class representing user intents for the NewsShots Listing.
 *
 * @author Apoorv Gupta
 */
sealed class NewsShotsListingIntent : UserIntent {
    data class LoadNewsShotsListingScreen(val categoryName: String) : NewsShotsListingIntent()
}

/**
 * Sealed class representing navigation effects for the NewsShots Listing.
 *
 * @author Apoorv Gupta
 */
sealed class NewsShotsListingNavEffect : NavEffect {
    data class OpenIndividualNewsShots(val userId: String) : NewsShotsListingNavEffect()
}

/**
 * Sealed class representing different view states for the NewsShots Listing.
 *
 * @author Apoorv Gupta
 */
sealed class NewsShotsListingViewStates {
    data class LoadedData(
        val showLoader: Boolean = false,
        val isRefreshing: Boolean = false,
        val data: NewsShotsListingDataModel,
    ) : NewsShotsListingViewStates()

    data class Offline(
        val showLoader: Boolean = false,
        val isRefreshing: Boolean = false,
        val offlineErrorModel: OfflineErrorModel,
    ) : NewsShotsListingViewStates()

    data class Error(
        val showLoader: Boolean = false,
        val isRefreshing: Boolean = false,
        val apiErrorContentModel: ApiErrorModel = ApiErrorModel.emptyValue,
    ) : NewsShotsListingViewStates()

    data class InitialLoading(
        val showLoader: Boolean = false,
        val isRefreshing: Boolean = false,
        val data: NewsShotsListingDataModel,
    ) : NewsShotsListingViewStates()

    data object UnInitialized : NewsShotsListingViewStates()
}

/**
 * Data class representing the overall view state for the NewsShots Listing.
 *
 * @param NewsShotsListingViewState The specific NewsShots Listing view state.
 */
data class NewsShotsListingViewState(
    var NewsShotsListingViewState: NewsShotsListingViewStates,
) : ViewState
