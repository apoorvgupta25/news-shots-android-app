package com.apoorvgupta.home.view.elements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.apoorvgupta.capabilities.presentation.reusableComponents.HeadLine
import com.apoorvgupta.capabilities.presentation.reusableComponents.newsshots.NewsShotsCard
import com.apoorvgupta.capabilities.presentation.reusableComponents.noRippleClickable
import com.apoorvgupta.capabilities.presentation.theme.ll_corner_radius
import com.apoorvgupta.capabilities.presentation.theme.m_horizontal_spacing
import com.apoorvgupta.capabilities.presentation.theme.m_vertical_spacing
import com.apoorvgupta.capabilities.presentation.theme.s_horizontal_spacing
import com.apoorvgupta.capabilities.presentation.theme.s_vertical_spacing
import com.apoorvgupta.capabilities.presentation.theme.sl_vertical_spacing
import com.apoorvgupta.capabilities.presentation.theme.xxs_vertical_spacing
import com.apoorvgupta.capabilities.presentation.theme.xxxs_stroke_width
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
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surface)
            .padding(
                start = m_horizontal_spacing,
                end = m_horizontal_spacing,
                top = m_vertical_spacing,
            ),
        verticalArrangement = Arrangement.Center,
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

            // Category
            Text(
                text = state.data.homeContent.categoryLabel,
                modifier = Modifier.padding(top = m_vertical_spacing, bottom = sl_vertical_spacing),
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurface,
            )

            // Category Chips
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(s_horizontal_spacing),
                verticalArrangement = Arrangement.spacedBy(s_vertical_spacing),
            ) {
                state.data.categoriesList.forEach {
                    Text(
                        modifier = Modifier
                            .noRippleClickable {
                                userIntent.invoke(HomeIntent.NavigateToNewsShotsListing(it.name))
                            }
                            .background(
                                color = MaterialTheme.colorScheme.background,
                                shape = RoundedCornerShape(ll_corner_radius),
                            )
                            .border(
                                border = BorderStroke(
                                    width = xxxs_stroke_width,
                                    color = MaterialTheme.colorScheme.outline,
                                ),
                                shape = RoundedCornerShape(ll_corner_radius),
                            )
                            .padding(
                                horizontal = s_horizontal_spacing,
                                vertical = xxs_vertical_spacing,
                            ),

                        text = it.name,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                }
            }

            HorizontalDivider(
                modifier = Modifier.padding(top = m_vertical_spacing),
            )

            // Articles
            Text(
                text = state.data.homeContent.articlesLabel,
                modifier = Modifier.padding(top = m_vertical_spacing, bottom = sl_vertical_spacing),
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }

        items(state.data.newsShotsList) {
            NewsShotsCard(
                newsShot = it,
                onCardClick = {},
                onBookmarkClick = {},
            )
        }
    }
}
