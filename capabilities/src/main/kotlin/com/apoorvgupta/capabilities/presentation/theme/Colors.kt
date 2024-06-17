/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.capabilities.presentation.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Color constants for light theme
private val md_theme_light_primary = Color(0xFFE3E2DF)
private val md_theme_light_onPrimary = Color(0xFFFFFFFF)
private val md_theme_light_secondary = Color(0xFF6F5B40)
private val md_theme_light_onSecondary = Color(0xFFFFFFFF)
private val md_theme_light_background = Color(0xFFFFFFFF)
private val md_theme_light_error = Color(0xFFFFFFFF)
private val md_theme_light_errorContainer = Color(0xFFFFFFFF)
private val md_theme_light_primaryButton = Color(0xFFFFFFFF)

// Color constants for dark theme
private val md_theme_dark_primary = Color(0xFFE3E2DF)
private val md_theme_dark_onPrimary = Color(0xFF452B00)
private val md_theme_dark_secondary = Color(0xFFDDC2A1)
private val md_theme_dark_onSecondary = Color(0xFF3E2D16)
private val md_theme_dark_background = Color(0xFF1F1B16)
private val md_theme_dark_error = Color(0xFFFFB4AB)
private val md_theme_dark_errorContainer = Color(0xFF93000A)
private val md_theme_dark_primaryButton = Color(0xFFE3E2DF)

// App Colors
private val disabled_bg = Color(0xFFD9D9D9)
private val shadow_bg = Color(0x26000000)
private val button_bg_color = Color(0xFFF2F2F2)

// Text Colors
private val text_black = Color(0xFF000000)
private val text_disabled = Color(0xFF707070)

// Light color scheme
val LightColorScheme =
    lightColorScheme(
        primary = md_theme_light_primary,
        onPrimary = md_theme_light_onPrimary,
        secondary = md_theme_light_secondary,
        onSecondary = md_theme_light_onSecondary,
        background = md_theme_light_background,
        error = md_theme_light_error,
        errorContainer = md_theme_light_errorContainer,
        surface = Color.White,
        surfaceTint = Color.White,
    )

// Dark color scheme
val DarkColorScheme =
    darkColorScheme(
        primary = md_theme_dark_primary,
        onPrimary = md_theme_dark_onPrimary,
        secondary = md_theme_dark_secondary,
        onSecondary = md_theme_dark_onSecondary,
        background = md_theme_dark_background,
        error = md_theme_dark_error,
        errorContainer = md_theme_dark_errorContainer,
        surface = Color.Black,
        surfaceTint = Color.Black,
    )

val ColorScheme.whiteColor: Color
    @Composable
    get() = Color.White

val ColorScheme.primaryButtonColor: Color
    @Composable
    get() = md_theme_light_primaryButton

val ColorScheme.textColor: Color
    @Composable
    get() = text_black

val ColorScheme.disabledTextColor: Color
    @Composable
    get() = text_disabled

val ColorScheme.disabledBackgroundColor: Color
    @Composable
    get() = disabled_bg

val ColorScheme.buttonBackgroundColor: Color
    @Composable
    get() = button_bg_color

val ColorScheme.shadowBackgroundColor: Color
    @Composable
    get() = shadow_bg
