package com.apoorvgupta.newsshots.view.elements

import androidx.compose.runtime.Composable
import com.apoorvgupta.capabilities.presentation.reusableComponents.errorscreen.AppErrorScreen
import com.apoorvgupta.newsshots.intent.NewsShotsListingIntent
import com.apoorvgupta.newsshots.intent.NewsShotsListingViewStates

@Composable
fun NewsShotsListingErrorContent(
    state: NewsShotsListingViewStates.LoadedData,
    userIntent: (NewsShotsListingIntent) -> Unit,
    error: String,
) {
    AppErrorScreen(
        isRefreshing = state.showLoader,
        onRefresh = { userIntent.invoke(NewsShotsListingIntent.RefreshNewsShotsListingScreen) },
        errorMessage = error,
    )
}
