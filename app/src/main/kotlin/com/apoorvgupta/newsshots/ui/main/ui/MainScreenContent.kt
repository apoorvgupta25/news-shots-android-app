package com.apoorvgupta.newsshots.ui.main.ui

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.navigation.NavHostController
import com.apoorvgupta.capabilities.presentation.navigation.showNavigationBottomBar
import com.apoorvgupta.capabilities.presentation.navigation.ui.BottomNavigationBar
import com.apoorvgupta.capabilities.presentation.reusableComponents.alertdialog.NoInternetDialog
import com.apoorvgupta.capabilities.presentation.reusableComponents.loader.RoundedCircularProgressBarComponent
import com.apoorvgupta.capabilities.presentation.theme.bottom_bar_height
import com.apoorvgupta.core.logger.AppLogger
import com.apoorvgupta.newsshots.ui.main.intents.MainIntent
import com.apoorvgupta.newsshots.ui.main.intents.MainViewStates
import com.apoorvgupta.newsshots.ui.main.viewmodels.MainViewModel
import com.apoorvgupta.newsshots.ui.navigation.NavigationHost

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreenContent(
    navController: NavHostController,
    viewModel: MainViewModel,
    viewState: MainViewStates.LoadedData,
    mainIntent: (MainIntent) -> Unit,
) {
    val bottomBarHeight = bottom_bar_height
    val bottomBarHeightPx = with(LocalDensity.current) { bottomBarHeight.roundToPx().toFloat() }
    val bottomBarOffsetHeightPx = remember { mutableStateOf(0f) }

    LaunchedEffect(key1 = true) {
        // Need to update
        AppLogger.d { "viewState: ${viewState.data}" }
        mainIntent.invoke(
            MainIntent.FetchNavigationScreenData
        )

    }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                val newOffset = bottomBarOffsetHeightPx.value + delta
                bottomBarOffsetHeightPx.value = newOffset.coerceIn(-bottomBarHeightPx, 0f)

                return Offset.Zero
            }
        }
    }

    // Scaffold is used as the top-level container for the main content of the app
    Scaffold(
        modifier = Modifier.nestedScroll(nestedScrollConnection),
        topBar = {
        },
        bottomBar = {
            // Display the BottomAppBar with BottomNavigationBar if specified for route
            if (showNavigationBottomBar(navController = navController)) {
                BottomNavigationBar(
                    navController = navController,
                    bottomBarHeight = bottomBarHeight,
                    bottomBarOffsetHeightPx = bottomBarOffsetHeightPx,
                )
            }
        },
    ) {
        // Include the NavigationHost composable within the Box
        NavigationHost(
            navController = navController,
            paddingTop = it.calculateTopPadding(),
        )
    }

    RoundedCircularProgressBarComponent(visibility = viewModel.circularBarVisibility.value)

    if (viewModel.showNoInternet.value) {
        NoInternetDialog(visibility = true) {
            viewModel.showNoInternet.value = false
        }
    }
}
