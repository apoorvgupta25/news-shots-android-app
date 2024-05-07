package com.apoorvgupta.capabilities.presentation.reusableComponents.loader

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp
import com.apoorvgupta.capabilities.presentation.theme.m_stroke_width
import com.apoorvgupta.capabilities.presentation.theme.md_theme_light_primaryButton
import com.apoorvgupta.capabilities.presentation.theme.welcome_card_background_light
import com.apoorvgupta.capabilities.presentation.theme.xl5_surrounding_spacing

/**
 * @author Apoorv Gupta
 */

@Composable
fun AppCircularLoader(
    width: Dp = xl5_surrounding_spacing,
    height: Dp = xl5_surrounding_spacing,
    trackColor: Color = welcome_card_background_light,
    color: Color = md_theme_light_primaryButton,
    strokeWidth: Dp = m_stroke_width,
    strokeCap: StrokeCap = StrokeCap.Round,
) {
    CircularProgressIndicator(
        modifier = Modifier
            .width(width)
            .height(height),
        color = color,
        trackColor = trackColor,
        strokeWidth = strokeWidth,
        strokeCap = strokeCap,
    )
}
