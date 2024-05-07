/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.core.models

import com.apoorvgupta.core.utils.EMPTY_STRING
import com.apoorvgupta.core.utils.emptyValue

/**
 * Data class representing an offline error model with information such as title, subtitle, image URL, and offline CTA label.
 *
 * @param title The title of the offline error.
 * @param subTitle The subtitle or additional information about the offline error.
 * @param imageUrl The URL pointing to an image associated with the offline error. Default is [EMPTY_STRING].
 * @param offlineCtaLabel The label for the call-to-action related to the offline error. Default is [EMPTY_STRING].
 *
 * @author Apoorv Gupta
 */
data class OfflineErrorModel(
    var title: String,
    var subTitle: String,
    var imageUrl: String = EMPTY_STRING,
    var offlineCtaLabel: String = EMPTY_STRING,
) {
    companion object {
        val emptyValue = OfflineErrorModel(
            title = String.emptyValue(),
            subTitle = String.emptyValue(),
            imageUrl = String.emptyValue(),
            offlineCtaLabel = String.emptyValue(),
        )
    }
}
