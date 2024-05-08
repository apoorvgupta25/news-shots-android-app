/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.capabilities.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.apoorvgupta.newsshots.capabilities.R

/**
 * Typography for defining text styles.
 *
 * @author Apoorv Gupta
 */

private val Poppins =
    FontFamily(
        Font(R.font.poppins_bold, weight = FontWeight.Bold),
        Font(R.font.poppins_regular, weight = FontWeight.Normal),
        Font(R.font.poppins_italic),
    )

val Typography =
    Typography(
        displayLarge = Typography().displayLarge.copy(fontFamily = Poppins),
        displayMedium = Typography().displayMedium.copy(fontFamily = Poppins),
        displaySmall = Typography().displaySmall.copy(fontFamily = Poppins),
        headlineLarge = Typography().headlineLarge.copy(fontFamily = Poppins),
        headlineMedium = Typography().headlineMedium.copy(fontFamily = Poppins),
        headlineSmall = Typography().headlineSmall.copy(fontFamily = Poppins),
        titleLarge = Typography().titleLarge.copy(fontFamily = Poppins),
        titleMedium = Typography().titleMedium.copy(fontFamily = Poppins),
        titleSmall = Typography().titleSmall.copy(fontFamily = Poppins),
        bodyLarge = Typography().bodyLarge.copy(fontFamily = Poppins),
        bodyMedium = Typography().bodyMedium.copy(fontFamily = Poppins),
        bodySmall = Typography().bodySmall.copy(fontFamily = Poppins),
        labelLarge = Typography().labelLarge.copy(fontFamily = Poppins),
        labelMedium = Typography().labelMedium.copy(fontFamily = Poppins),
        labelSmall = Typography().labelSmall.copy(fontFamily = Poppins),
    )

val Typography.buttonTextStyle: TextStyle
    @Composable
    get() = TextStyle(
        fontSize = text_size_body,
        lineHeight = line_height_body_regular,
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.4.sp,
    )
