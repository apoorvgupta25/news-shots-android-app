package com.apoorvgupta.newsdetails.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.apoorvgupta.core.utils.DataStatus
import com.apoorvgupta.newsdetails.intent.NewsDetailsIntent
import com.apoorvgupta.newsdetails.intent.NewsDetailsViewStates
import com.apoorvgupta.newsdetails.view.elements.NewsDetailScreenErrorContent
import com.apoorvgupta.newsdetails.view.elements.NewsDetailScreenLoadedContent

/**
 * @author Apoorv Gupta
 */
@Composable
fun NewsDetailsScreen(
    state: NewsDetailsViewStates.LoadedData,
    userIntent: (NewsDetailsIntent) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        // Main content of the Home Screen.
        when (state.data.status) {
            DataStatus.Error -> NewsDetailScreenErrorContent(state = state, userIntent = userIntent)
            DataStatus.Success -> NewsDetailScreenLoadedContent(state = state, userIntent = userIntent)
            else -> {
                // Do Nothing.
            }
        }
    }
}
