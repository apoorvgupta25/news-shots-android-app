package com.apoorvgupta.newsdetails.view.elements

import androidx.compose.runtime.Composable
import com.apoorvgupta.capabilities.presentation.reusableComponents.errorscreen.AppErrorScreen
import com.apoorvgupta.newsdetails.intent.NewsDetailsIntent
import com.apoorvgupta.newsdetails.intent.NewsDetailsViewStates

/**
 * @author Apoorv Gupta
 */
@Composable
fun NewsDetailScreenErrorContent(
    state: NewsDetailsViewStates.LoadedData,
    userIntent: (NewsDetailsIntent) -> Unit,
) {
    AppErrorScreen(
        isRefreshing = state.showLoader,
        onRefresh = {
            userIntent.invoke(NewsDetailsIntent.RefreshNewsDetailsScreen)
        },
        errorMessage = "${state.data.errorModel.errorCode} ${state.data.errorModel.message}",
    )
}
