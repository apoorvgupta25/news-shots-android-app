package com.apoorvgupta.capabilities.presentation.reusableComponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.apoorvgupta.capabilities.presentation.theme.sm_surrounding_spacing
import com.apoorvgupta.capabilities.presentation.theme.xxl_icon_size
import com.apoorvgupta.capabilities.presentation.theme.xxxs_stroke_width
import com.apoorvgupta.newsshots.capabilities.R

/**
 * @author Apoorv Gupta
 */

@Composable
fun BackArrowNavigation(onBackClick: () -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.ic_back_arrow),
        contentDescription = "Back",
        modifier = Modifier
            .noRippleClickable {
                onBackClick()
            }
            .size(xxl_icon_size)
            .background(color = MaterialTheme.colorScheme.background, shape = CircleShape)
            .border(
                border = BorderStroke(
                    width = xxxs_stroke_width,
                    color = MaterialTheme.colorScheme.outline,
                ),
                shape = CircleShape,
            )
            .padding(sm_surrounding_spacing),

    )
}
