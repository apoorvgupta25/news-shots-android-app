package com.apoorvgupta.home.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        // Main content of the Home Screen.
        when (state.data.status) {
            DataStatus.Error -> HomeScreenErrorContent(state = state, userIntent = userIntent)
            DataStatus.Success -> HomeScreenLoadedContent(state = state, userIntent = userIntent)
            else -> {
                // Do Nothing.
            }
        }
    }
}
