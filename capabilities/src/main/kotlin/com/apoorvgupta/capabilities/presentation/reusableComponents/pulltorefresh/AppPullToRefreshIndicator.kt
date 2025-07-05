package com.apoorvgupta.capabilities.presentation.reusableComponents.pulltorefresh

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator
import androidx.compose.material3.pulltorefresh.PullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * @author Apoorv Gupta
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppPullToRefreshIndicator(isRefreshing: Boolean, pullToRefreshState: PullToRefreshState) {

    Box(modifier = Modifier.fillMaxSize()) {
        Indicator(
            modifier = Modifier.align(Alignment.TopCenter),
            isRefreshing = isRefreshing,
            containerColor = MaterialTheme.colorScheme.background,
            color = MaterialTheme.colorScheme.onBackground,
            state = pullToRefreshState,
        )
    }
}
