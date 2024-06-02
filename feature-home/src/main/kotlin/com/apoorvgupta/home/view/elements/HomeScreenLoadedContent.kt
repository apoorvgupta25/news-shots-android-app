package com.apoorvgupta.home.view.elements

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.apoorvgupta.home.intent.HomeViewStates

/**
 * @author Apoorv Gupta
 */

@Composable
fun HomeScreenLoadedContent(state: HomeViewStates.LoadedData) {
    Text(
        text = "Home",
    )

    state.data.newsShotsList.forEach {
        Text(
            text = it.title,
        )
    }
}

