package com.apoorvgupta.core.models

import com.apoorvgupta.core.utils.emptyValue

/**
 * Data class representing the model used to render data on the Offline Screen.
 *
 * @param title The title of the offline screen.
 * @param subTitle The subtitle of the offline screen.
 * @param imageUrl The URL of the image to be displayed on the offline screen.
 * @param offlineCTALabel The optional label for the offline call-to-action button.
 *
 * @author Apoorv Gupta
 */
data class OfflineScreenDataModel(
    var title: String,
    var subTitle: String,
    var imageUrl: String,
    var offlineCTALabel: String = String.emptyValue(), // Optional field
) {
    companion object {
        /**
         * A default empty value for the OfflineScreenDataModel.
         */
        val emptyValue =
            OfflineScreenDataModel(
                title = String.emptyValue(),
                subTitle = String.emptyValue(),
                imageUrl = String.emptyValue(),
                offlineCTALabel = String.emptyValue(),
            )
    }
}
