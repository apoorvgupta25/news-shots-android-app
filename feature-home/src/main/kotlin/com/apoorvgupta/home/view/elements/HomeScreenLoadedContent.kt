package com.apoorvgupta.home.view.elements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.apoorvgupta.capabilities.presentation.reusableComponents.newsshots.NewsShotsCard
import com.apoorvgupta.capabilities.presentation.theme.ll_corner_radius
import com.apoorvgupta.capabilities.presentation.theme.m_horizontal_spacing
import com.apoorvgupta.capabilities.presentation.theme.m_vertical_spacing
import com.apoorvgupta.capabilities.presentation.theme.s_horizontal_spacing
import com.apoorvgupta.capabilities.presentation.theme.s_vertical_spacing
import com.apoorvgupta.capabilities.presentation.theme.sl_vertical_spacing
import com.apoorvgupta.capabilities.presentation.theme.textColor
import com.apoorvgupta.capabilities.presentation.theme.xxs_vertical_spacing
import com.apoorvgupta.capabilities.presentation.theme.xxxl_vertical_spacing
import com.apoorvgupta.capabilities.presentation.theme.xxxs_stroke_width
import com.apoorvgupta.home.intent.HomeViewStates

/**
 * @author Apoorv Gupta
 */

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeScreenLoadedContent(state: HomeViewStates.LoadedData) {
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(
                start = m_horizontal_spacing,
                end = m_horizontal_spacing,
                top = xxxl_vertical_spacing,
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {
        // Title
        Text(
            text = state.data.homeContent.headingText,
            style = MaterialTheme.typography.headlineLarge,
        )

        // SubTitle
        Text(
            text = state.data.homeContent.subHeadingText,
            style = MaterialTheme.typography.bodyMedium,
        )

        // Category
        Text(
            text = state.data.homeContent.categoryLabel,
            modifier = Modifier.padding(top = m_vertical_spacing, bottom = sl_vertical_spacing),
            style = MaterialTheme.typography.labelLarge,
        )

        // Category Chips
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(s_horizontal_spacing),
            verticalArrangement = Arrangement.spacedBy(s_vertical_spacing),
        ) {
            state.data.categoriesList.forEach {
                Text(
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colorScheme.onPrimary,
                            shape = RoundedCornerShape(ll_corner_radius),
                        )
                        .border(
                            border = BorderStroke(
                                width = xxxs_stroke_width,
                                color = MaterialTheme.colorScheme.textColor,
                            ),
                            shape = RoundedCornerShape(ll_corner_radius),
                        )
                        .padding(
                            horizontal = s_horizontal_spacing,
                            vertical = xxs_vertical_spacing,
                        ),

                    text = it.name,
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
        }

        HorizontalDivider(
            modifier = Modifier.padding(top = m_vertical_spacing),
        )

        // Articles
        Text(
            text = state.data.homeContent.allArticlesLabel,
            modifier = Modifier.padding(top = m_vertical_spacing, bottom = sl_vertical_spacing),
            style = MaterialTheme.typography.labelLarge,
        )

        state.data.newsShotsList.forEach {
            NewsShotsCard(
                it,
            )
        }
    }
}
