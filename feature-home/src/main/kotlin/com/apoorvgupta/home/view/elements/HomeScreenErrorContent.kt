package com.apoorvgupta.home.view.elements

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.apoorvgupta.home.intent.HomeViewStates

/**
 * @author Apoorv Gupta
 */

@Composable
fun HomeScreenErrorContent(state: HomeViewStates.LoadedData) {
    Text(text = "${state.data.errorModel.errorCode} ${state.data.errorModel.message}")
}
