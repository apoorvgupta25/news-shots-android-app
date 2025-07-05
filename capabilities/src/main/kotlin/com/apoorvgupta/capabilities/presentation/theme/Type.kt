/**
 * Copyright (c) 2025 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.capabilities.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.apoorvgupta.newsshots.capabilities.R

/**
 * Typography for defining text styles.
 *
 * @author Apoorv Gupta
 */

private val Poppins =
    FontFamily(
        Font(R.font.poppins_medium, weight = FontWeight.Medium),
        Font(R.font.poppins_semi_bold, weight = FontWeight.SemiBold),
        Font(R.font.poppins_bold, weight = FontWeight.Bold),
        Font(R.font.poppins_regular, weight = FontWeight.Normal),
        Font(R.font.poppins_italic),
    )

private val Graphik =
    FontFamily(
        Font(R.font.graphik_medium, weight = FontWeight.Medium),
        Font(R.font.graphik_regular, weight = FontWeight.Normal),
    )

private val NewsReader60 =
    FontFamily(
        Font(R.font.newsreader_medium, weight = FontWeight.Medium),
        Font(R.font.newsreader_semi_bold, weight = FontWeight.SemiBold),
        Font(R.font.newsreader_bold, weight = FontWeight.Bold),
        Font(R.font.newsreader_regular, weight = FontWeight.Normal),
        Font(R.font.newsreader_italic, style = FontStyle.Italic),
    )

private val AppFontFamily =
//    Poppins
//    Graphik
    NewsReader60

val Typography =
    Typography(
        displayLarge = Typography().displayLarge.copy(fontFamily = AppFontFamily),
        displayMedium = Typography().displayMedium.copy(fontFamily = AppFontFamily),
        displaySmall = Typography().displaySmall.copy(fontFamily = AppFontFamily),
        headlineLarge = Typography().headlineLarge.copy(
            fontFamily = AppFontFamily,
            fontWeight = FontWeight.Medium,
        ),
        headlineMedium = Typography().headlineMedium.copy(fontFamily = AppFontFamily),
        headlineSmall = Typography().headlineSmall.copy(
            fontFamily = AppFontFamily,
            fontWeight = FontWeight.Bold,
        ),
        titleLarge = Typography().titleLarge.copy(fontFamily = AppFontFamily),
        titleMedium = Typography().titleMedium.copy(
            fontFamily = AppFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = Dimensions.TextSize.text_size_title_medium,
        ),
        titleSmall = Typography().titleSmall.copy(
            fontFamily = AppFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = Dimensions.TextSize.text_size_title_small,
        ),
        bodyLarge = Typography().bodyLarge.copy(fontFamily = AppFontFamily),
        bodyMedium = Typography().bodyMedium.copy(fontFamily = AppFontFamily),
        bodySmall = Typography().bodySmall.copy(fontFamily = AppFontFamily),
        labelLarge = Typography().labelLarge.copy(
            fontFamily = AppFontFamily,
            fontWeight = FontWeight.Medium,
        ),
        labelMedium = Typography().labelMedium.copy(fontFamily = AppFontFamily),
        labelSmall = Typography().labelSmall.copy(fontFamily = AppFontFamily),
    )

val Typography.buttonTextStyle: TextStyle
    @Composable
    get() = Typography.bodyMedium.copy(
        fontFamily = AppFontFamily,
        fontWeight = FontWeight.Bold,
    )
