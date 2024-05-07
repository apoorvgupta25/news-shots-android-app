package com.apoorvgupta.capabilities.presentation.reusableComponents.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.style.TextAlign
import com.apoorvgupta.capabilities.presentation.theme.CornerRadiusLarge
import com.apoorvgupta.capabilities.presentation.theme.HorizontalSpacingSmall
import com.apoorvgupta.capabilities.presentation.theme.StrokeWidthMedium
import com.apoorvgupta.capabilities.presentation.theme.StrokeWidthSmall
import com.apoorvgupta.capabilities.presentation.theme.blackTextColor
import com.apoorvgupta.capabilities.presentation.theme.buttonTextStyle
import com.apoorvgupta.capabilities.presentation.theme.disabledBackgroundColor
import com.apoorvgupta.capabilities.presentation.theme.disabledTextColor
import com.apoorvgupta.core.utils.EMPTY_STRING

/**
 * Composable function to handle the Buttons through out the application
 *
 * @param modifier          - Modifier to define the width
 * @param buttonTitle       - Button title
 * @param isButtonFilled    - True if the button is filled, else false
 * @param fillColor         - Fill color / border color for unfilled buttons
 * @param textColor         - Text color
 * @param isEnabled         - True if button is enabled, else false
 * @param onClickListener   - Button click handler function
 */
@Composable
fun AppButton(
    modifier: Modifier,
    buttonTitle: String,
    isButtonFilled: Boolean = true,
    fillColor: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = MaterialTheme.colorScheme.blackTextColor,
    isEnabled: MutableState<Boolean> = mutableStateOf(true),
    contentTag: String = EMPTY_STRING,
    isIconVisible: MutableState<Boolean> = mutableStateOf(false),
    onClickListener: () -> Unit,
) {
    Button(
        modifier =
        modifier.semantics {
            contentDescription = "$contentTag Button"
            testTag = "$contentTag Button"
        },
        shape = RoundedCornerShape(CornerRadiusLarge),
        border =
        BorderStroke(
            StrokeWidthSmall,
            if (isEnabled.value) fillColor else MaterialTheme.colorScheme.disabledBackgroundColor,
        ),
        elevation = null,
        enabled = isEnabled.value,
        colors =
        if (isButtonFilled) {
            ButtonDefaults.buttonColors(
                disabledContainerColor = MaterialTheme.colorScheme.disabledBackgroundColor,
                containerColor = fillColor,
                contentColor = textColor,
                disabledContentColor = MaterialTheme.colorScheme.disabledTextColor,
            )
        } else {
            ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        },
        onClick = onClickListener,
    ) {
        Spacer(Modifier.size(StrokeWidthMedium))
        Text(
            modifier =
            Modifier
                .padding(horizontal = HorizontalSpacingSmall)
                .semantics {
                    contentDescription = "$contentTag Button"
                    testTag = "$contentTag Button"
                },
            text = buttonTitle,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.buttonTextStyle.copy(color = textColor),
        )
    }
}
