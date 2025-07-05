package com.apoorvgupta.newsshots.ui.main.intents

import androidx.compose.ui.unit.Dp
import com.apoorvgupta.core.base.NavEffect
import com.apoorvgupta.core.base.UserIntent
import com.apoorvgupta.core.base.ViewState
import com.apoorvgupta.core.models.MainScreenDataModel

/**
 * Sealed class representing user intents for the app.
 *
 * @author Apoorv Gupta
 */
sealed class MainIntent : UserIntent {
    data object FetchNavigationScreenData : MainIntent()
    data object InitiateClearSession : MainIntent()
}

sealed class MainUIIntent {
    data class ShowMessage(
        val message: String,
        val imageUrl: String,
        val imageSize: Dp,
    ) : MainUIIntent()
}

/**
 * Sealed class representing navigation effects for the app.
 *
 * @author Apoorv Gupta
 */
sealed class MainNavEffect : NavEffect {
    data class BottomBarItemNavigation(val navigationRoute: String) : MainNavEffect()
}

/**
 * Sealed class representing different view states for the app.
 *
 * @author Apoorv Gupta
 */
sealed class MainViewStates {
    /**
     * Data class representing the loaded data state.
     *
     * @param data The app update screen data model.
     */
    data class LoadedData(
        val showLoader: Boolean = false,
        val data: MainScreenDataModel,
    ) : MainViewStates()
}

/**
 * Data class representing the overall view state for the app screen.
 *
 * @param appViewState The specific app screen view state.
 */
data class MainViewState(
    var appViewState: MainViewStates,
) : ViewState
