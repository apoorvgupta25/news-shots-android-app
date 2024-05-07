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
val light_green = Color(0xFFE6F3EE)

// Color constants for dark theme
val md_theme_dark_primary = Color(0xFF7D4DBE)
val md_theme_dark_onPrimary = Color(0xFF452B00)
val md_theme_dark_secondary = Color(0xFFDDC2A1)
val md_theme_dark_onSecondary = Color(0xFF3E2D16)
val md_theme_dark_background = Color(0xFF1F1B16)
val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_primaryButton = Color(0xFF7D4DBE)

// Login
val text_field_bg_color = Color(0xFF1F1F1F)
val login_in_button_bg_color = Color(0xFFF2F2F2)
val text_field_label_color = Color(0xFFBDBDBD)
val divider_text_color = Color(0xFF3C3C3C)

// App Colors
val primary = Color(0xFF7D4DBE)
val secondary = Color(0xFF6436AB)
val white = Color(0xFFFFFFFF)
val off_white = Color(0xFFEFEFEF)
val disabled_bg = Color(0xFFD9D9D9)
val error_light = Color(0xFFFBE5E5)
val light_gray = Color(0xFFF6F6F6)
val light_purple = Color(0xFFF0ECF5)
val light_blue = Color(0xFFF4F8FC)
val bg_color = Color(0xFFF0ECF5)
val overlay_color = Color(0x66000000)
val yellow = Color(0xFFFFC83E)
val pink = Color(0xFFA90061)

// Text Colors
val text_black = Color(0xFF000000)
val text_gray_black = Color(0xFF545353)
val text_gray_777 = Color(0xFF777676)
val text_gray_c4 = Color(0xFFC4C4C4)
val text_disabled = Color(0xFF707070)
val text_error_red = Color(0xFFD40000)
val text_success_green = Color(0xFF038356)
val text_light_grey = Color(0xFF777676)

// Outline Colors
val outline_black = Color(0xFF000000)
val outline_gray = Color(0xFF353434)
val outline_red = Color(0xFFD40000)
val outline_disabled = Color(0xFFC4C4C4)

// Home
val welcome_card_background_light = Color(0xFFF0ECF5)
val divider_color = Color(0xFFE0D1FF)
val divider_color_2 = Color(0xFFEFEFEF)
val selection_color = Color(0xFFE0D1FF)

val warning_yellow_background = Color(0xFFFFF9EC)

val border_yellow = Color(0x80B3842F)
val border_red = Color(0x80E1251B)
val border_blue = Color(0x800856BF)
val border_purple = Color(0x807D4DBE)

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
