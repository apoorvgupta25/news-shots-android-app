package com.apoorvgupta.newsdetails.view.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.apoorvgupta.capabilities.presentation.reusableComponents.BackArrowNavigation
import com.apoorvgupta.capabilities.presentation.theme.linkTextColor
import com.apoorvgupta.capabilities.presentation.theme.m_horizontal_spacing
import com.apoorvgupta.capabilities.presentation.theme.m_surrounding_spacing
import com.apoorvgupta.capabilities.presentation.theme.m_vertical_spacing
import com.apoorvgupta.capabilities.util.Constants
import com.apoorvgupta.draftjscompose.view.DraftJSView
import com.apoorvgupta.newsdetails.intent.NewsDetailsIntent
import com.apoorvgupta.newsdetails.intent.NewsDetailsViewStates

/**
 * @author Apoorv Gupta
 */
@Composable
fun NewsDetailScreenLoadedContent(
    state: NewsDetailsViewStates.LoadedData,
    userIntent: (NewsDetailsIntent) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        // Image
        Box(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                model = "${Constants.IMAGE_BASE_URL}${state.data.newsShot.link}",
                contentDescription = "NewsShot image",
            )

            Column(
                modifier = Modifier.padding(all = m_surrounding_spacing),
            ) {
                BackArrowNavigation(
                    onBackClick = {
                        userIntent.invoke(NewsDetailsIntent.NavigateToPreviousScreen)
                    },
                )
            }
        }

        // Desc
        Row(
            modifier = Modifier
                .padding(vertical = m_vertical_spacing, horizontal = m_horizontal_spacing)
                .fillMaxWidth(),
        ) {
            Text(
                text = state.data.newsShot.category.name,
                style = MaterialTheme.typography.bodyLarge,
            )

            Spacer(modifier = Modifier.weight(Constants.FULL_WEIGHT))

            Text(
                text = state.data.newsShot.formattedDate,
                style = MaterialTheme.typography.bodyLarge,
            )
        }

        Text(
            modifier = Modifier.padding(
                start = m_horizontal_spacing,
                end = m_horizontal_spacing,
                bottom = m_vertical_spacing,
            ),
            text = state.data.newsShot.title,
            style = MaterialTheme.typography.headlineSmall,
        )

        // Main Content
        Box(
            modifier = Modifier.padding(horizontal = m_horizontal_spacing),
        ) {
            DraftJSView(
                modifier = Modifier,
                draftJSContent = state.data.newsShot.draftJSContent,
                linkTextColor = MaterialTheme.colorScheme.linkTextColor,
            )
        }
    }
}
