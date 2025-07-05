package com.apoorvgupta.capabilities.presentation.reusableComponents.errorscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.apoorvgupta.capabilities.presentation.reusableComponents.pulltorefresh.AppPullToRefresh

/**
 * @author Apoorv Gupta
 */

@Composable
fun AppErrorScreen(
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    errorMessage: String = "Something went wrong",
) {
    AppPullToRefresh(
        isRefreshing = isRefreshing,
        onRefresh = onRefresh,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {
            Text(
                text = errorMessage,
                textAlign = TextAlign.Center,
            )
        }
    }
}
