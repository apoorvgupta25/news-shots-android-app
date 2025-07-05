package com.apoorvgupta.newsshots.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.apoorvgupta.capabilities.presentation.reusableComponents.HeadLine
import com.apoorvgupta.capabilities.presentation.reusableComponents.loader.CircularProgressBarComponent
import com.apoorvgupta.capabilities.presentation.reusableComponents.newsshots.NewsShotsCard
import com.apoorvgupta.capabilities.presentation.theme.Dimensions
import com.apoorvgupta.core.logger.AppLogger
import com.apoorvgupta.core.utils.getValueOrEmpty
import com.apoorvgupta.newsshots.intent.NewsShotsListingIntent
import com.apoorvgupta.newsshots.intent.NewsShotsListingViewStates
import com.apoorvgupta.newsshots.viewmodels.NewsShotsListingViewModel

/**
 * @author Apoorv Gupta
 */
@Composable
fun NewsShotsListingScreen(
    state: NewsShotsListingViewStates.LoadedData,
    viewModel: NewsShotsListingViewModel,
    userIntent: (NewsShotsListingIntent) -> Unit,
) {
    val newsShotsResults = viewModel.newsShotsPaginationResults.collectAsLazyPagingItems()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dimensions.HorizonalDimensions.m_horizontal_spacing),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        item {
            Spacer(modifier = Modifier.height(Dimensions.VerticalDimensions.s_vertical_spacing))

            HeadLine(
                headText = state.data.headingText,
                onBackClick = {
                    userIntent.invoke(NewsShotsListingIntent.NavigateToPreviousScreen)
                },
            )

            Spacer(modifier = Modifier.height(Dimensions.VerticalDimensions.s_vertical_spacing))
        }

        items(
            count = newsShotsResults.itemCount,
        ) { index ->
            newsShotsResults.get(index = index)?.let { newsShot ->
                NewsShotsCard(
                    newsShot = newsShot,
                    onCardClick = {
                        userIntent.invoke(NewsShotsListingIntent.NavigateToIndividualNewsShots(newsShot.link))
                    },
                    onBookmarkClick = {},
                )
                if (newsShotsResults.itemCount - 1 != index) {
                    HorizontalDivider(
                        modifier = Modifier.padding(all = Dimensions.SurroundingDimensions.s_surrounding_spacing),
                    )
                }
            }
        }

        when (newsShotsResults.loadState.refresh) {
            is LoadState.Error -> {
                item {
                    NewsShotsListingErrorContent((newsShotsResults.loadState.refresh as LoadState.Error).error.message.getValueOrEmpty())
                }
            }

            LoadState.Loading -> {
                item {
                    CircularProgressBarComponent(true)
                }
                AppLogger.d { "newsShotsResults.loadState.refresh.Loading" }
            }

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
