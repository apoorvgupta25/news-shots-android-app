package com.apoorvgupta.capabilities.presentation.reusableComponents

import android.app.Activity
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.WindowInsetsControllerCompat
import com.apoorvgupta.capabilities.presentation.theme.disabled_bg
import com.apoorvgupta.capabilities.presentation.theme.error_light
import com.apoorvgupta.capabilities.presentation.theme.light_gray
import com.apoorvgupta.capabilities.presentation.theme.outline_black
import com.apoorvgupta.capabilities.presentation.theme.outline_red
import com.apoorvgupta.capabilities.presentation.theme.primary
import com.apoorvgupta.capabilities.presentation.theme.text_black
import com.apoorvgupta.capabilities.presentation.theme.text_disabled
import com.apoorvgupta.capabilities.presentation.theme.text_error_red
import com.apoorvgupta.capabilities.presentation.theme.text_gray_c4
import com.apoorvgupta.capabilities.presentation.theme.white

/**
 * Colors for the OutlinedTextField
 */
@Composable
fun getOutlinedTextFieldColors(): TextFieldColors {
    return OutlinedTextFieldDefaults.colors(
        disabledBorderColor = text_gray_c4,
        focusedBorderColor = outline_black,
        unfocusedBorderColor = outline_black,
        errorBorderColor = outline_red,
        errorContainerColor = error_light,
        errorCursorColor = text_error_red,
        errorTextColor = text_error_red,
        errorPlaceholderColor = text_error_red,
        cursorColor = text_black,
        disabledTextColor = text_gray_c4,
        focusedTextColor = text_black,
        unfocusedTextColor = text_black,
    )
}

/**
 * Colors for the SearchTextField
 */
@Composable
fun getSearchTextFieldColors(): TextFieldColors {
    return OutlinedTextFieldDefaults.colors(
        disabledBorderColor = Color.Transparent,
        focusedBorderColor = Color.Transparent,
        unfocusedBorderColor = Color.Transparent,
        errorBorderColor = Color.Transparent,
        errorContainerColor = light_gray,
        errorCursorColor = text_black,
        errorTextColor = text_black,
        errorPlaceholderColor = text_black,
        cursorColor = text_black,
        disabledTextColor = text_black,
        focusedTextColor = text_black,
        unfocusedTextColor = text_black,
    )
}

/**
 * Colors for the InputCountTextField
 */
@Composable
fun getOutlinedInputCountTextFieldColors(): TextFieldColors {
    return OutlinedTextFieldDefaults.colors(
        disabledBorderColor = text_gray_c4,
        focusedBorderColor = primary,
        unfocusedBorderColor = primary,
        errorBorderColor = outline_red,
        errorContainerColor = error_light,
        errorCursorColor = text_error_red,
        errorTextColor = text_error_red,
        errorPlaceholderColor = text_error_red,
        cursorColor = primary,
        disabledTextColor = text_gray_c4,
        focusedTextColor = primary,
        unfocusedTextColor = primary,
    )
}

/**
 * Colors for the NavigationBar
 */
@Composable
fun getNavigationBarItemColors(): NavigationBarItemColors {
    return NavigationBarItemDefaults.colors(
        selectedIconColor = primary,
        selectedTextColor = primary,
        indicatorColor = white,
        unselectedIconColor = outline_black,
        unselectedTextColor = text_black,
        disabledIconColor = text_disabled,
        disabledTextColor = text_disabled,
    )
}

/**
 * Colors for the Cards.
 */
@Composable
fun getCardColors(): CardColors {
    return CardDefaults.cardColors(
        containerColor = white,
        contentColor = text_black,
        disabledContainerColor = disabled_bg,
        disabledContentColor = text_black,
    )
}

/**
 * Colors for the Checkbox
 */
@Composable
fun getCheckBoxColors(isError: Boolean = false): CheckboxColors {
    return CheckboxDefaults.colors(
        checkedColor = primary,
        uncheckedColor = if (isError) outline_red else primary,
        checkmarkColor = white,
        disabledCheckedColor = text_gray_c4,
        disabledUncheckedColor = text_gray_c4,
        disabledIndeterminateColor = text_gray_c4,
    ).apply { }
}

/**
 * Sets the status bar color and text appearance for the current activity.
 *
 * @param color The color to set as the status bar color.
 */
@Composable
fun SetStatusBarColor(color: Color) {
    val window = (LocalContext.current as? Activity)?.window
    window?.apply {
        WindowInsetsControllerCompat(window, decorView).apply {
            isAppearanceLightStatusBars = true
            isAppearanceLightNavigationBars = true
        }
        statusBarColor = color.toArgb()
    }
}
