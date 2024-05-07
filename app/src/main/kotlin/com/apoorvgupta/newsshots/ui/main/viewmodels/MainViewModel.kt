package com.apoorvgupta.newsshots.ui.main.viewmodels

import androidx.compose.runtime.MutableState
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

    private val _circularBarVisibility = mutableStateOf(false)
    val circularBarVisibility: MutableState<Boolean> = _circularBarVisibility

    val showNoInternet = mutableStateOf(false)

    override fun createInitialState(): MainViewState {
        return MainViewState(MainViewStates.LoadedData(data = MainScreenDataModel.defaultValue))
    }

    override fun handleIntent(intent: MainIntent) {
        when (intent) {
            MainIntent.InitiateClearSession -> {
            }

            MainIntent.FetchNavigationScreenData -> {
                // TODO: Fetch Screen data from RC and update the default content of the main screen. After Sprint 2.
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
        mainScreenDataModel.versionName = buildConfigContract.getAppVersion()

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
