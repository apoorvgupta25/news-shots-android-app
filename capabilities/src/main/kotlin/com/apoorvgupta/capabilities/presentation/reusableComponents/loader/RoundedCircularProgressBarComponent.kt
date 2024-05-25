package com.apoorvgupta.capabilities.presentation.reusableComponents.loader

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.apoorvgupta.capabilities.presentation.theme.primaryButtonColor
import com.apoorvgupta.capabilities.presentation.theme.s_stroke_width
import com.apoorvgupta.capabilities.presentation.theme.xl5_surrounding_spacing

/**
 * Composable function that displays a purple and rounded circular progress bar component.
 *
 * @param visibility Determines whether the circular progress bar should be visible.
 *
 * @author Apoorv Gupta
 */
@Composable
fun RoundedCircularProgressBarComponent(visibility: Boolean) {
    if (visibility) {
        Dialog(
            onDismissRequest = { },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false,
            ),
            content = {
                Box(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight(),
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .width(xl5_surrounding_spacing)
                            .height(xl5_surrounding_spacing),
                        color = MaterialTheme.colorScheme.primaryButtonColor,
                        trackColor = MaterialTheme.colorScheme.primary,
                        strokeWidth = s_stroke_width,
                        strokeCap = StrokeCap.Round,
                    )
                }
            },
        )
    }
}
