package com.apoorvgupta.newsshots.intent

import com.apoorvgupta.core.base.NavEffect
import com.apoorvgupta.core.base.UserIntent
import com.apoorvgupta.core.base.ViewState
import com.apoorvgupta.newsshots.models.NewsShotsListingDataModel

/**
 * Sealed class representing user intents for the NewsShots Listing.
 *
 * @author Apoorv Gupta
 */
sealed class NewsShotsListingIntent : UserIntent {
    data class LoadNewsShotsListingScreen(val categoryName: String) : NewsShotsListingIntent()
    data class NavigateToIndividualNewsShots(val link: String) : NewsShotsListingIntent()
    data object NavigateToPreviousScreen : NewsShotsListingIntent()
}

/**
 * Sealed class representing navigation effects for the NewsShots Listing.
 *
 * @author Apoorv Gupta
 */
sealed class NewsShotsListingNavEffect : NavEffect {
    data class OpenIndividualNewsShots(val userId: String) : NewsShotsListingNavEffect()
    data object OpenPreviousScreen : NewsShotsListingNavEffect()
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
 * @param newsShotsListingViewState The specific NewsShots Listing view state.
 */
data class NewsShotsListingViewState(
    var newsShotsListingViewState: NewsShotsListingViewStates,
) : ViewState
