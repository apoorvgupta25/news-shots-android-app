package com.apoorvgupta.home.view.elements

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.apoorvgupta.capabilities.presentation.theme.Dimensions
import com.apoorvgupta.home.intent.HomeViewStates

/**
 * @author Apoorv Gupta
 */

@Composable
fun ArticlesLabel(state: HomeViewStates.LoadedData) {
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