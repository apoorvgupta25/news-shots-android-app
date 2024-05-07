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
val md_theme_light_primary = Color(0xFF7D4DBE)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_secondary = Color(0xFF6F5B40)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_background = Color(0xFFFFFFFF)
val md_theme_light_error = Color(0xFFBA1A1A)
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_primaryButton = Color(0xFF7D4DBE)

// Color constants for dark theme
val md_theme_dark_primary = Color(0xFF7D4DBE)
val md_theme_dark_onPrimary = Color(0xFF452B00)
val md_theme_dark_secondary = Color(0xFFDDC2A1)
val md_theme_dark_onSecondary = Color(0xFF3E2D16)
val md_theme_dark_background = Color(0xFF1F1B16)
val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_primaryButton = Color(0xFF7D4DBE)

val login_in_button_bg_color = Color(0xFFF2F2F2)

// App Colors
val primary = Color(0xFF7D4DBE)
val white = Color(0xFFFFFFFF)
val disabled_bg = Color(0xFFD9D9D9)

// Text Colors
val text_black = Color(0xFF000000)
val text_disabled = Color(0xFF707070)
val text_light_grey = Color(0xFF777676)

// Home
val welcome_card_background_light = Color(0xFFF0ECF5)
val divider_color = Color(0xFFE0D1FF)
val divider_color_2 = Color(0xFFEFEFEF)

// Light color scheme
val LightColors =
    lightColorScheme(
        primary = md_theme_light_primary,
        onPrimary = md_theme_light_onPrimary,
        secondary = md_theme_light_secondary,
        onSecondary = md_theme_light_onSecondary,
        background = md_theme_light_background,
        error = md_theme_light_error,
        errorContainer = md_theme_light_errorContainer,
        surface = white,
        surfaceTint = white,
    )

// Dark color scheme
val DarkColors =
    darkColorScheme(
        primary = md_theme_light_primary,
        onPrimary = md_theme_light_onPrimary,
        secondary = md_theme_light_secondary,
        onSecondary = md_theme_light_onSecondary,
        background = md_theme_light_background,
        error = md_theme_light_error,
        errorContainer = md_theme_light_errorContainer,
        surface = white,
        surfaceTint = white,
    )

val ColorScheme.primaryBackground: Color
    @Composable
    get() = md_theme_light_background

val ColorScheme.primaryButtonColor: Color
    @Composable
    get() = md_theme_light_primaryButton

val ColorScheme.welcomeCardBackground: Color
    @Composable
    get() = welcome_card_background_light

val ColorScheme.dividerColor: Color
    @Composable
    get() = divider_color

val ColorScheme.dividerColorGrey: Color
    @Composable
    get() = divider_color_2

val ColorScheme.primaryTextColor: Color
    @Composable
    get() = md_theme_light_primaryButton

val ColorScheme.lightGreyTextColor: Color
    @Composable
    get() = text_light_grey
