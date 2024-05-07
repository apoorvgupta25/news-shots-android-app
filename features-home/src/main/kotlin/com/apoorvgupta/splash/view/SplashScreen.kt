package com.apoorvgupta.splash.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.apoorvgupta.capabilities.presentation.theme.primary
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
            .background(primary),
        contentAlignment = Alignment.Center,
    ) {
//        Image(painter =
//        painterResource(id = R.drawable.vintage_bg)
//            , contentDescription = ""
//            , modifier = Modifier.fillMaxSize().
//            background(primary)
//        )
        /*Image(
            modifier = Modifier
                .scale(0.48f),
            painter = painterResource(id = R),
            contentDescription = "Splash Logo",
        )*/
    }
    LaunchedEffect(Unit) {
        userIntent.invoke(SplashIntent.ValidateSessionData)
    }
}
