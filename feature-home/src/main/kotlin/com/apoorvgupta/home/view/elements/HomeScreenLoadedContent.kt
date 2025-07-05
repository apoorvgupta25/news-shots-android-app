package com.apoorvgupta.home.view.elements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.apoorvgupta.capabilities.presentation.reusableComponents.HeadLine
import com.apoorvgupta.capabilities.presentation.reusableComponents.newsshots.NewsShotsCard
import com.apoorvgupta.capabilities.presentation.reusableComponents.noRippleClickable
import com.apoorvgupta.capabilities.presentation.theme.Dimensions
import com.apoorvgupta.capabilities.util.Constants
import com.apoorvgupta.home.intent.HomeIntent
import com.apoorvgupta.home.intent.HomeViewStates

/**
 * @author Apoorv Gupta
 */

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenLoadedContent(
    state: HomeViewStates.LoadedData,
    userIntent: (HomeIntent) -> Unit,
) {
    val pullToRefreshState = rememberPullToRefreshState()
    PullToRefreshBox(
        isRefreshing = state.showLoader,
        onRefresh = {
            userIntent.invoke(HomeIntent.LoadHomeScreen)
        },
        state = pullToRefreshState,
        indicator = {
            Indicator(
                modifier = Modifier.align(Alignment.TopCenter),
                isRefreshing = state.showLoader,
                containerColor = MaterialTheme.colorScheme.background,
                color = MaterialTheme.colorScheme.onBackground,
                state = pullToRefreshState,
            )
        },
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.surface)
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
                )

                // Category Chips
                FlowRow(
                    modifier = Modifier.padding(
                        top = Dimensions.VerticalDimensions.m_vertical_spacing,
                    ),
                    horizontalArrangement = Arrangement.spacedBy(Dimensions.HorizonalDimensions.s_horizontal_spacing),
                    verticalArrangement = Arrangement.spacedBy(Dimensions.VerticalDimensions.s_vertical_spacing),
                ) {
                    state.data.categoriesList.forEach {
                        Text(
                            modifier = Modifier
                                .height(Dimensions.VerticalDimensions.xl_vertical_spacing)
                                .wrapContentHeight(align = Alignment.CenterVertically)
                                .noRippleClickable {
                                    userIntent.invoke(HomeIntent.NavigateToNewsShotsListing(it.name))
                                }
                                .background(
                                    color = MaterialTheme.colorScheme.background,
                                    shape = RoundedCornerShape(Dimensions.CornerRadius.ll_corner_radius),
                                )
                                .border(
                                    border = BorderStroke(
                                        width = Dimensions.StrokeWidth.xxxs_stroke_width,
                                        color = MaterialTheme.colorScheme.outline,
                                    ),
                                    shape = RoundedCornerShape(Dimensions.CornerRadius.ll_corner_radius),
                                )
                                .padding(
                                    horizontal = Dimensions.HorizonalDimensions.s_horizontal_spacing,
                                    vertical = Dimensions.VerticalDimensions.xxs_vertical_spacing,
                                ),

                            text = it.name,
                            style = MaterialTheme.typography.bodyLarge,
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

            items(state.data.newsShotsList) {
                NewsShotsCard(
                    newsShot = it,
                    onCardClick = {
                        userIntent.invoke(HomeIntent.NavigateToIndividualNewsShots(it.link))
                    },
                    onBookmarkClick = {},
                )
            }
        }
    }
}
