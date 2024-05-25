/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.capabilities.presentation.reusableComponents.loader

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.apoorvgupta.capabilities.presentation.theme.m_icon_size
import com.apoorvgupta.capabilities.presentation.theme.xs_stroke_width

/**
 * Composable function representing a circular progress bar in Jetpack Compose.
 *
 * @param modifier Custom modifier for the circular progress bar.
 * @param progressColor Color of the circular progress bar.
 * @param size Size of the circular progress bar.
 * @param strokeWidth Width of the circular progress bar's stroke.
 *
 * @author Apoorv Gupta
 */
@Composable
fun CircularProgressBar(
    modifier: Modifier = Modifier,
    progressColor: Color = MaterialTheme.colorScheme.primary,
    size: Dp = m_icon_size,
    strokeWidth: Dp = xs_stroke_width,
) {
    // Column to center the circular progress bar vertically and horizontally
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Circular progress indicator with specified parameters
        CircularProgressIndicator(
            modifier = modifier.size(size),
            color = progressColor,
            strokeWidth = strokeWidth,
        )
    }
}
