package com.apoorvgupta.newsshots.ui.main.viewmodels

import androidx.compose.runtime.mutableStateOf
import com.apoorvgupta.core.base.BaseViewModel
import com.apoorvgupta.core.interactions.buildConfigProvider.BuildConfigContract
import com.apoorvgupta.core.models.MainScreenDataModel
import com.apoorvgupta.newsshots.ui.main.intents.MainIntent
import com.apoorvgupta.newsshots.ui.main.intents.MainNavEffect
import com.apoorvgupta.newsshots.ui.main.intents.MainViewState
import com.apoorvgupta.newsshots.ui.main.intents.MainViewStates
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val buildConfigContract: BuildConfigContract,
) : BaseViewModel<MainIntent, MainViewState, MainNavEffect>() {

    val showNoInternet = mutableStateOf(false)

    override fun createInitialState(): MainViewState = MainViewState(MainViewStates.LoadedData(data = MainScreenDataModel.defaultValue))

    override fun handleIntent(intent: MainIntent) {
        // Need to update
        when (intent) {
            MainIntent.InitiateClearSession -> {
                // Do Nothing
            }

            MainIntent.FetchNavigationScreenData -> {
                renderMainScreen(MainScreenDataModel.defaultValue)
            }
        }
    }

    /**
     * Update the ViewState with the fetched login screen details.
     *
     * @param mainScreenDataModel The data model containing login screen details.
     */
    private fun renderMainScreen(mainScreenDataModel: MainScreenDataModel) {
        emitViewState {
            copy(
                appViewState = MainViewStates.LoadedData(
                    showLoader = false,
                    data = mainScreenDataModel,
                ),
            )
        }
    }

    fun showNoInternetDialog(
        visibility: Boolean,
    ) {
        showNoInternet.value = visibility
    }
}
