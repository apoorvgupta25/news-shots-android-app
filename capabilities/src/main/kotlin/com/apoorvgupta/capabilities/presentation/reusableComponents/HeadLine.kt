package com.apoorvgupta.capabilities.presentation.reusableComponents

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.apoorvgupta.core.utils.EMPTY_STRING

/**
 * @author Apoorv Gupta
 */

@Composable
fun HeadLine(
    headText: String = EMPTY_STRING,
    subHeadingText: String = EMPTY_STRING,
    onHeadClick: () -> Unit = {},
) {
    // Title
    Text(
        text = headText,
        style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier.noRippleClickable {
            onHeadClick()
        },
        color = MaterialTheme.colorScheme.onBackground,
    )

    // SubTitle
    Text(
        text = subHeadingText,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurface,
    )
}
