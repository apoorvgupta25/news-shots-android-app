package com.apoorvgupta.daily.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.apoorvgupta.capabilities.presentation.reusableComponents.newsshots.NewsShotsCard
import com.apoorvgupta.capabilities.presentation.theme.m_horizontal_spacing
import com.apoorvgupta.core.logger.AppLogger
import com.apoorvgupta.daily.intent.DailyIntent
import com.apoorvgupta.daily.viewmodels.DailyViewModel

/**
 * @author Apoorv Gupta
 */
@Composable
fun DailyScreen(
    viewModel: DailyViewModel,
    userIntent: (DailyIntent) -> Unit,
) {
    val newsShotsResults = viewModel.newsShotsPaginationResults.collectAsLazyPagingItems()

    LazyColumn(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(horizontal = m_horizontal_spacing),
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
            is LoadState.Error -> AppLogger.d { "newsShotsResults.loadState.refresh.Error" }
            LoadState.Loading -> AppLogger.d { "newsShotsResults.loadState.refresh.Loading" }
            is LoadState.NotLoading -> {
                AppLogger.d { "newsShotsResults.loadState.refresh.NotLoading" }
            }
        }

        when (newsShotsResults.loadState.append) {
            is LoadState.Error -> AppLogger.d { "newsShotsResults.loadState.append.Error" }
            LoadState.Loading -> AppLogger.d { "newsShotsResults.loadState.append.Loading" }
            is LoadState.NotLoading -> AppLogger.d { "newsShotsResults.loadState.append.NotLoading" }
        }
    }
}
