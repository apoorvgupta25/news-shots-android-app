package com.apoorvgupta.home.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.apoorvgupta.core.logger.AppLogger
import com.apoorvgupta.core.utils.DataStatus
import com.apoorvgupta.home.intent.HomeIntent
import com.apoorvgupta.home.intent.HomeViewStates
import com.apoorvgupta.home.view.elements.HomeScreenErrorContent
import com.apoorvgupta.home.view.elements.HomeScreenLoadedContent

/**
 * Composable function representing the Home Screen.
 *
 * @author Apoorv Gupta
 */
@Composable
fun HomeScreen(
    state: HomeViewStates.LoadedData,
    userIntent: (HomeIntent) -> Unit,
) {
    LaunchedEffect(key1 = true) {
        // Need to remove this temp
        userIntent.invoke(
            HomeIntent.LoadHomeScreen,
        )
        // Need to update
        AppLogger.d { "state: ${state.isRefreshing}" }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Main content of the Home Screen.
        when (state.data.status) {
            DataStatus.Error -> HomeScreenErrorContent(state)
            DataStatus.Success -> HomeScreenLoadedContent(state)
            else -> {
                // Do Nothing.
            }
        }
    }
}
