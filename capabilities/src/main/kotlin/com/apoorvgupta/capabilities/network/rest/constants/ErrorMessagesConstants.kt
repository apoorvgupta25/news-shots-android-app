/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */
package com.apoorvgupta.capabilities.network.rest.constants

import com.google.gson.annotations.SerializedName

/**
 * Object containing constants for error messages in the network layer.
 *
 * @author Apoorv Gupta
 */
object ErrorMessagesConstants {
    const val VERIFICATION_FAILED = "Please contact customer support."
}

data class ErrorCodeDataModel(
    @SerializedName("errorCode")
    var errorCode: Int? = null,
    @SerializedName("errorMessage")
    var errorMessage: String = "Unexpected error occurred",
)
