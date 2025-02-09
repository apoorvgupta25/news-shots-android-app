package com.apoorvgupta.capabilities.presentation.reusableComponents.alertdialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.apoorvgupta.capabilities.presentation.reusableComponents.button.AppButton
import com.apoorvgupta.capabilities.presentation.theme.m_corner_radius
import com.apoorvgupta.capabilities.presentation.theme.m_surrounding_spacing
import com.apoorvgupta.capabilities.presentation.theme.m_vertical_spacing
import com.apoorvgupta.capabilities.presentation.theme.s_vertical_spacing
import com.apoorvgupta.capabilities.presentation.theme.xl_vertical_spacing
import com.apoorvgupta.capabilities.presentation.theme.xs_vertical_spacing
import com.apoorvgupta.newsshots.capabilities.R

/**
 * Composable function representing a dialog to notify users about the lack of internet connectivity.
 *
 * @param visibility Whether the dialog is visible or not.
 * @param onCtaAction Lambda function to be executed when the CTA button is clicked.
 *
 * @author Apoorv Gupta
 */
@Composable
fun NoInternetDialog(
    visibility: Boolean,
    onCtaAction: () -> Unit,
) {
    if (visibility) {
        Dialog(
            onDismissRequest = { },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false,
            ),
            content = {
                Column(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                        .background(
                            color = MaterialTheme.colorScheme.background,
                            shape = RoundedCornerShape(size = m_corner_radius),
                        )
                        .padding(m_surrounding_spacing),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Spacer(modifier = Modifier.height(m_vertical_spacing))
                    Image(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Icon",
                    )
                    Spacer(modifier = Modifier.height(s_vertical_spacing))
                    Text(
                        text = stringResource(id = R.string.noInternetErrorTitle),
                        style = MaterialTheme.typography.titleLarge,
                    )
                    Spacer(modifier = Modifier.height(xs_vertical_spacing))
                    Text(
                        text = stringResource(id = R.string.noInternetErrorMessage),
                        style = MaterialTheme.typography.bodyLarge,
                    )
                    Spacer(modifier = Modifier.height(xl_vertical_spacing))
                    AppButton(
                        buttonTitle = stringResource(id = R.string.noInternetErrorCtaLabel),
                        onClickListener = {
                            onCtaAction.invoke()
                        },
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
            },
        )
    }
}
