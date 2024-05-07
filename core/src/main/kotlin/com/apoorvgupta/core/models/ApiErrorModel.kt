/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.core.models

import com.apoorvgupta.core.utils.EMPTY_STRING
import com.apoorvgupta.core.utils.emptyValue

/**
 * Data class representing an API error model with information such as title, subtitle, image URL, and error CTA label.
 *
 * @param title The title of the API error.
 * @param subTitle The subtitle or additional information about the API error.
 * @param imageUrl The URL pointing to an image associated with the API error. Default is [EMPTY_STRING].
 * @param errorCtaLabel The label for the call-to-action related to the API error. Default is [EMPTY_STRING].
 *
 * @author Apoorv Gupta
 */
data class ApiErrorModel(
    var title: String,
    var subTitle: String,
    var imageUrl: String = EMPTY_STRING,
    var errorCtaLabel: String = EMPTY_STRING,
) {
    companion object {
        val emptyValue =
            ApiErrorModel(
                title = String.emptyValue(),
                subTitle = String.emptyValue(),
                imageUrl = String.emptyValue(),
                errorCtaLabel = String.emptyValue(),
            )
    }
}
