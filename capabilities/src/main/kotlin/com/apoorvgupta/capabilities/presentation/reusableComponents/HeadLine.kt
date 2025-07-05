package com.apoorvgupta.capabilities.presentation.reusableComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.apoorvgupta.capabilities.presentation.theme.Dimensions
import com.apoorvgupta.core.utils.emptyValue
import com.apoorvgupta.newsshots.capabilities.R

/**
 * @author Apoorv Gupta
 */

@Composable
fun HeadLine(
    headText: String = String.emptyValue(),
    subHeadingText: String = String.emptyValue(),
    onHeadClick: () -> Unit = {},
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
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

        Image(
            painter = painterResource(R.drawable.ic_light_mode),
            contentDescription = String.emptyValue(),
            modifier = Modifier.size(Dimensions.IconSize.xml_icon_size),
        )
    }

    // SubTitle
    Text(
        text = subHeadingText,
        style = MaterialTheme.typography.labelLarge,
        color = MaterialTheme.colorScheme.onSurface,
    )
}
