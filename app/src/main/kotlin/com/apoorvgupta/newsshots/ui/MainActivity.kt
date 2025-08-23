/**
 * Copyright (c) 2025 Apoorv Gupta
 * All rights reserved.
 */
package com.apoorvgupta.newsshots.ui

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.apoorvgupta.capabilities.network.rest.helpers.ConnectivityChannel
import com.apoorvgupta.capabilities.network.rest.helpers.getNetworkType
import com.apoorvgupta.capabilities.presentation.reusableComponents.SetStatusBarColor
import com.apoorvgupta.capabilities.presentation.theme.AppTheme
import com.apoorvgupta.core.interactions.session.FinishActivityChannel
import com.apoorvgupta.core.logger.AppLogger
import com.apoorvgupta.newsshots.ui.main.MainDestination
import com.apoorvgupta.newsshots.ui.main.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * MainActivity serves as the main entry point for the Newsshots Android application UI.
 * It extends ComponentActivity, which is part of the AndroidX Activity library.
 * The @AndroidEntryPoint annotation is used to indicate that Hilt should be used for
 * dependency injection in this Activity.
 *
 * @author Apoorv Gupta
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // ViewModel for managing main UI logic
    private val mainViewModel: MainViewModel by viewModels()

    /**
     * Called when the activity is first created.
     *
     * This method is overridden to provide the main content of the activity.
     * The setContent block is used to set the content of the activity using Jetpack
     * Compose. The AppTheme composable is applied to the entire UI, providing a
     * consistent theme.
     *
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            installSplashScreen()
        }
        setContent {
            SetStatusBarColor()
            //need to update start destination if authenticated navController.graph.setStartDestination(startDestinationRoute.value)
            /*val startDestination = remember {
                mutableStateOf(Destinations.SplashDestination.route)
            }*/

            AppTheme {
                // MainDestination is a composable that represents the main content
                // of the app. It is included within the Row composable.
                MainDestination(
                    viewModel = mainViewModel,
                )
            }
            AppLogger.d("***NetworkType", "Network type: ${getNetworkType(this)}")
        }
    }

    override fun onStart() {
        super.onStart()

        lifecycleScope.launch {
            FinishActivityChannel.observer().collectLatest {
                if (it) {
                    FinishActivityChannel.publish(false)
                    finish()
                }
            }
        }
        lifecycleScope.launch {
            ConnectivityChannel.observer().collectLatest {
                if (it) {
                    ConnectivityChannel.publish(false)
                    mainViewModel.showNoInternetDialog(it)
                }
            }
        }
    }
}
