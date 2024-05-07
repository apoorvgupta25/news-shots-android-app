package com.apoorvgupta.capabilities.presentation.reusableComponents

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.WindowInsetsControllerCompat

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
