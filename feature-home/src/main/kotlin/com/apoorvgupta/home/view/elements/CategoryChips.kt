package com.apoorvgupta.home.view.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.apoorvgupta.capabilities.presentation.reusableComponents.noRippleClickable
import com.apoorvgupta.capabilities.presentation.theme.Dimensions
import com.apoorvgupta.home.intent.HomeIntent
import com.apoorvgupta.home.intent.HomeViewStates

/**
 * @author Apoorv Gupta
 */

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CategoryChips(
    state: HomeViewStates.LoadedData,
    userIntent: (HomeIntent) -> Unit,
) {
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
}
