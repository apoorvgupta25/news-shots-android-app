package com.apoorvgupta.splash.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.apoorvgupta.splash.intents.SplashIntent
import com.apoorvgupta.splash.intents.SplashViewStates

/**
 * @author Apoorv Gupta
 */

@Composable
fun SplashScreen(
    state: SplashViewStates.LoadedData,
    userIntent: (SplashIntent) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surface),
        contentAlignment = Alignment.Center,
    ) {
    }
    LaunchedEffect(Unit) {
        userIntent.invoke(SplashIntent.NavigateToHomeScreen)
        // Need to update
    }
}
