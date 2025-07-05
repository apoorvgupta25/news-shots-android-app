package com.apoorvgupta.capabilities.presentation.reusableComponents

import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.core.view.WindowInsetsControllerCompat

/**
 * Sets the status bar color and text appearance for the current activity.
 *
 * @param darkIcon invert the Status icons color based on theme
 */
@Composable
fun SetStatusBarColor(darkIcon: Boolean = !isSystemInDarkTheme()) {
    val window = LocalActivity.current?.window
    window?.apply {
        WindowInsetsControllerCompat(window, decorView).apply {
            isAppearanceLightStatusBars = darkIcon
            isAppearanceLightNavigationBars = darkIcon
        }
    }
}

fun Modifier.noRippleClickable(
    onClick: () -> Unit,
): Modifier = composed {
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() },
    ) {
        onClick()
    }
}
