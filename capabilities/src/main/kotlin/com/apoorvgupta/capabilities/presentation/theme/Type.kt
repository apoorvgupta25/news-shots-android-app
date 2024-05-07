/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.capabilities.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
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
        displayLarge =
        TextStyle(
            // Default font family
            fontFamily = Poppins,
            // Normal font weight
            fontWeight = FontWeight.Normal,
            // Font size of 16sp
            fontSize = text_size_body_medium,
        ),

    )

val textFieldLabel =
    TextStyle(
        fontFamily = Poppins,
        // Normal font weight
        fontWeight = FontWeight.Normal,
        // Font size of 13sp
        fontSize = text_size_default,
    )

val buttonTextBold =
    TextStyle(
        fontFamily = Poppins,
        // Normal font weight
        fontWeight = FontWeight.Bold,
        // Font size of 13sp
        fontSize = text_size_default,
        letterSpacing = line_spacing_default,
    )

val filterCategoryText =
    TextStyle(
        fontFamily = Poppins,
        // Normal font weight
        fontWeight = FontWeight.Bold,
        // Font size of 13sp
        fontSize = text_size_subtitle_small,
        lineHeight = line_height_title,
    )

val buttonTextNormal =
    TextStyle(
        fontFamily = Poppins,
        // Normal font weight
        fontWeight = FontWeight.Normal,
        // Font size of 13sp
        fontSize = text_size_default,
        letterSpacing = line_spacing_default,
    )

val textStyle1 =
    TextStyle(
        fontFamily = Poppins,
        // Normal font weight
        fontWeight = FontWeight.Normal,
        // Font size of 13sp
        fontSize = text_size_default,
    )

val textStyle2 =
    TextStyle(
        fontFamily = Poppins,
        // Normal font weight
        fontWeight = FontWeight.ExtraBold,
        // Font size of 13sp
        fontSize = text_size_default,
    )

val textStyleLight =
    TextStyle(
        fontFamily = Poppins,
        // Normal font weight
        fontWeight = FontWeight.Light,
        // Font size of 13sp
        fontSize = text_size_default,
    )

// Multibrand/input-text
val inputTextStyle =
    TextStyle(
        fontSize = text_size_body_medium,
        lineHeight = line_height_body_medium,
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.15.sp,
    )

// Multibrand/input-label
val inputLabelStyle =
    TextStyle(
        fontSize = text_size_description,
        lineHeight = line_height_default,
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.15.sp,
    )

// Multibrand/h6
val h6 =
    TextStyle(
        fontSize = text_size_h6,
        lineHeight = line_height_h6,
        fontFamily = Poppins, // montserrat
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.15.sp,
    )

// Multibrand/body1
val body1 =
    TextStyle(
        fontSize = text_size_body_medium,
        lineHeight = line_height_body_medium,
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.15.sp,
    )

// Multibrand/body2
val body2 =
    TextStyle(
        fontSize = text_size_body,
        lineHeight = line_height_body_regular,
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.1.sp,
    )

// Multibrand/body3

val bulletPoint = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = line_height_h6,
)
val body3 =
    TextStyle(
        fontSize = text_size_description,
        lineHeight = line_height_default,
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.1.sp,
    )

// Multibrand/subtitle1
val subtitle1 =
    TextStyle(
        fontSize = text_size_body_medium,
        lineHeight = line_height_body_medium,
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.15.sp,
    )

val textSmall =
    TextStyle(
        fontSize = text_size_small,
        lineHeight = line_height_xs,
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.4.sp,
    )

val textXXSmallBold =
    TextStyle(
        textAlign = TextAlign.Center,
        fontFamily = Poppins,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = text_size_xx_small,
        lineHeight = 6.sp,
    )

val textXSmallBold =
    TextStyle(
        fontFamily = Poppins,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = text_size_x_small,
        lineHeight = 14.sp,
    )

// Multibrand/subtitle2
val subtitle2 =
    TextStyle(
        fontSize = text_size_body,
        lineHeight = line_height_body_regular,
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.1.sp,
    )

// Multibrand/subtitle3
val subtitle3 =
    TextStyle(
        fontSize = text_size_description,
        lineHeight = line_height_default,
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.1.sp,
    )

// Button
val buttonTextStyle =
    TextStyle(
        fontSize = text_size_body,
        lineHeight = line_height_body_regular,
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.4.sp,
    )

// Multibrand/button-medium
val buttonMediumStyle =
    TextStyle(
        fontSize = text_size_body,
        lineHeight = line_height_body_regular,
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.4.sp,
    )

// Multibrand/button-medium-underlined
val buttonMediumUnderlineStyle =
    TextStyle(
        fontSize = text_size_body,
        lineHeight = line_height_body_regular,
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.4.sp,
        textDecoration = TextDecoration.Underline,
    )

// Multibrand/button-small
val buttonSmall =
    TextStyle(
        fontSize = text_size_description,
        lineHeight = line_height_default,
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.4.sp,
    )

// Multibrand/button-small-underlined
val buttonSmallUnderlineStyle =
    TextStyle(
        fontSize = text_size_description,
        lineHeight = line_height_default,
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.4.sp,
        textDecoration = TextDecoration.Underline,
    )

// Multibrand/button-xsmall
val buttonXSmall =
    TextStyle(
        fontSize = text_size_small,
        lineHeight = line_height_xs,
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.4.sp,
    )
