package com.apoorvgupta.core.models

import com.apoorvgupta.core.utils.DataStatus
import com.apoorvgupta.core.utils.EMPTY_STRING

/**
 * Data class representing the model used to render data on the main app screen.
 *
 * @param status The data status (e.g., Empty, Offline, Error, Success, Loading).
 * @param profileLabel The profileLabel for the main app screen.
 * @param clearSessionLabel The clearSessionLabel for the main app screen.
 * @param versionInfoLabel The versionInfoLabel for the main app screen.
 *
 * @author Apoorv Gupta
 */
data class MainScreenDataModel(
    val status: DataStatus = DataStatus.Empty,
    var profileLabel: String = EMPTY_STRING,
    var clearSessionLabel: String = EMPTY_STRING,
    var versionInfoLabel: String = EMPTY_STRING,
    var versionName: String = EMPTY_STRING,
) {
    companion object {
        val defaultValue = MainScreenDataModel()
    }
}
