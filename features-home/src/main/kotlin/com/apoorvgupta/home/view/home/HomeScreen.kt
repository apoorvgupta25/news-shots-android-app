/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.home.view.home

import androidx.compose.runtime.Composable
import com.apoorvgupta.home.intent.HomeIntent
import com.apoorvgupta.home.intent.HomeViewStates

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
    CommonScreen(title = "Home")
}
