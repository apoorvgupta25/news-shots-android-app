package com.apoorvgupta.home.view.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.apoorvgupta.capabilities.presentation.reusableComponents.HeadLine
import com.apoorvgupta.capabilities.presentation.reusableComponents.newsshots.NewsShotsCard
import com.apoorvgupta.capabilities.presentation.reusableComponents.noRippleClickable
import com.apoorvgupta.capabilities.presentation.reusableComponents.pulltorefresh.AppPullToRefresh
import com.apoorvgupta.capabilities.presentation.theme.Dimensions
import com.apoorvgupta.capabilities.util.Constants
import com.apoorvgupta.home.intent.HomeIntent
import com.apoorvgupta.home.intent.HomeViewStates

/**
 * @author Apoorv Gupta
 */

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeScreenLoadedContent(
    state: HomeViewStates.LoadedData,
    userIntent: (HomeIntent) -> Unit,
) {
    AppPullToRefresh(
        isRefreshing = state.showLoader,
        onRefresh = { userIntent.invoke(HomeIntent.LoadHomeScreen) },
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = Dimensions.HorizonalDimensions.m_horizontal_spacing,
                    end = Dimensions.HorizonalDimensions.m_horizontal_spacing,
                    top = Dimensions.VerticalDimensions.m_vertical_spacing,
                ),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {
            item {
                HeadLine(
                    headText = state.data.homeContent.headingText,
                    subHeadingText = state.data.homeContent.subHeadingText,
                    onHeadClick = {
                        userIntent.invoke(HomeIntent.NavigateToNewsShotsListing(Constants.DAILY))
                    },
                    onModeIconClick = {
                    },
                )

                // Category Chips
                FlowRow(
                    modifier = Modifier.padding(
                        top = Dimensions.VerticalDimensions.m_vertical_spacing,
                    ),
                    horizontalArrangement = Arrangement.spacedBy(Dimensions.HorizonalDimensions.s_horizontal_spacing),
                    verticalArrangement = Arrangement.spacedBy(Dimensions.VerticalDimensions.sl_vertical_spacing),
                ) {
                    state.data.categoriesList.forEach {
                        Text(
                            modifier = Modifier
                                .noRippleClickable {
                                    userIntent.invoke(HomeIntent.NavigateToNewsShotsListing(it.name))
                                }
                                .background(
                                    color = MaterialTheme.colorScheme.surface,
                                    shape = RoundedCornerShape(Dimensions.CornerRadius.ll_corner_radius),
                                )
                                .padding(
                                    start = Dimensions.HorizonalDimensions.sl_horizontal_spacing,
                                    end = Dimensions.HorizonalDimensions.sl_horizontal_spacing,
                                    top = Dimensions.VerticalDimensions.s_vertical_spacing,
                                    bottom = Dimensions.VerticalDimensions.xs_vertical_spacing,
                                ),
                            text = it.name,
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.Center,
                        )
                    }
                }

                HorizontalDivider(
                    modifier = Modifier.padding(top = Dimensions.VerticalDimensions.m_vertical_spacing),
                )

                // Articles
                Text(
                    text = state.data.homeContent.articlesLabel,
                    modifier = Modifier.padding(
                        top = Dimensions.VerticalDimensions.m_vertical_spacing,
                        bottom = Dimensions.VerticalDimensions.sl_vertical_spacing,
                    ),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                )
            }

            itemsIndexed(state.data.newsShotsList) { index, it ->
                NewsShotsCard(
                    newsShot = it,
                    onCardClick = {
                        userIntent.invoke(HomeIntent.NavigateToIndividualNewsShots(it.link))
                    },
                    onBookmarkClick = {},
                )

                if (state.data.newsShotsList.size - 1 != index) {
                    HorizontalDivider(
                        modifier = Modifier.padding(all = Dimensions.SurroundingDimensions.s_surrounding_spacing),
                    )
                }
            }
        }
    }
}
