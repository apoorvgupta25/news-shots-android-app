package com.apoorvgupta.newsshots.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.apoorvgupta.capabilities.presentation.reusableComponents.newsshots.NewsShotsCard
import com.apoorvgupta.capabilities.presentation.theme.m_horizontal_spacing
import com.apoorvgupta.core.logger.AppLogger
import com.apoorvgupta.core.utils.getValueOrEmpty
import com.apoorvgupta.newsshots.intent.NewsShotsListingIntent
import com.apoorvgupta.newsshots.viewmodels.NewsShotsListingViewModel

/**
 * @author Apoorv Gupta
 */
@Composable
fun NewsShotsListingScreen(
    viewModel: NewsShotsListingViewModel,
    userIntent: (NewsShotsListingIntent) -> Unit,
) {
    val newsShotsResults = viewModel.newsShotsPaginationResults.collectAsLazyPagingItems()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(horizontal = m_horizontal_spacing),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(
            count = newsShotsResults.itemCount,
        ) { index ->
            newsShotsResults.get(index = index)?.let { newsShot ->
                NewsShotsCard(
                    newsShot = newsShot,
                )
            }
        }

        when (newsShotsResults.loadState.refresh) {
            is LoadState.Error -> {
                item {
                    NewsShotsListingErrorContent((newsShotsResults.loadState.refresh as LoadState.Error).error.message.getValueOrEmpty())
                }
            }

            LoadState.Loading -> AppLogger.d { "newsShotsResults.loadState.refresh.Loading" }
            is LoadState.NotLoading -> AppLogger.d { "newsShotsResults.loadState.refresh.NotLoading" }
        }

        when (newsShotsResults.loadState.append) {
            is LoadState.Error -> {
                item {
                    NewsShotsListingErrorContent((newsShotsResults.loadState.append as LoadState.Error).error.message.getValueOrEmpty())
                }
            }

            LoadState.Loading -> AppLogger.d { "newsShotsResults.loadState.append.Loading" }
            is LoadState.NotLoading -> AppLogger.d { "newsShotsResults.loadState.append.NotLoading" }
        }
    }
}

@Composable
fun NewsShotsListingErrorContent(error: String) {
    Text(
        text = error,
        textAlign = TextAlign.Center,
    )
}
