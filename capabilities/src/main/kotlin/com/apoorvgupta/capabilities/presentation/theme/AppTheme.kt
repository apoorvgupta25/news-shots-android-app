/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.capabilities.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

/**
 * Composable function representing the overall theme of the app using Jetpack Compose.
 *
 * @param darkTheme Flag to indicate whether the theme is in dark mode or light mode.
 * @param content The content block to apply the theme to.
 *
 * @author Apoorv Gupta
 */
@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    // Determine the color scheme based on the selected theme (dark or light)
    val colors = LightColorScheme // if (!darkTheme) LightColorScheme else DarkColorScheme

    // Apply MaterialTheme with specified color scheme, typography, and shapes
    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content,
    )
}
