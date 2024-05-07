package com.apoorvgupta.capabilities.presentation.reusableComponents.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.style.TextAlign
import com.apoorvgupta.capabilities.presentation.theme.CornerRadiusLarge
import com.apoorvgupta.capabilities.presentation.theme.HorizontalSpacingSmall
import com.apoorvgupta.capabilities.presentation.theme.StrokeWidthSmall
import com.apoorvgupta.capabilities.presentation.theme.buttonTextStyle
import com.apoorvgupta.capabilities.presentation.theme.disabled_bg
import com.apoorvgupta.capabilities.presentation.theme.primary
import com.apoorvgupta.capabilities.presentation.theme.text_disabled
import com.apoorvgupta.capabilities.presentation.theme.white
import com.apoorvgupta.capabilities.presentation.theme.xxs_horizontal_spacing
import com.apoorvgupta.core.utils.EMPTY_STRING

/**
 * Composable function to handle the Buttons through out the application
 *
 * @param modifier          - Modifier to define the width
 * @param buttonTitle       - Button title
 * @param leadingIcon       - Leading Icon resource
 * @param isButtonFilled    - True if the button is filled, else false
 * @param fillColor         - Fill color / border color for unfilled buttons
 * @param textColor         - Text color
 * @param isEnabled         - True if button is enabled, else false
 * @param onClickListener   - Button click handler function
 */
@Composable
fun AppButtonWithIcon(
    modifier: Modifier,
    buttonTitle: String,
    leadingIcon: Int,
    isButtonFilled: Boolean = true,
    fillColor: Color = primary,
    textColor: Color = white,
    isEnabled: MutableState<Boolean> = mutableStateOf(true),
    contentTag: String = EMPTY_STRING,
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
            if (isEnabled.value) fillColor else disabled_bg,
        ),
        elevation = null,
        enabled = isEnabled.value,
        colors =
        if (isButtonFilled) {
            ButtonDefaults.buttonColors(
                disabledContainerColor = disabled_bg,
                containerColor = fillColor,
                contentColor = textColor,
                disabledContentColor = text_disabled,
            )
        } else {
            ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        },
        onClick = onClickListener,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = leadingIcon),
                contentDescription = "$buttonTitle icon",
                tint = if (isButtonFilled) textColor else primary,
            )
            Spacer(modifier = Modifier.width(xxs_horizontal_spacing))
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
                style = buttonTextStyle.copy(color = textColor),
            )
        }
    }
}
