package com.apoorvgupta.core.models

import com.apoorvgupta.core.utils.EMPTY_STRING

/**
 * Data class representing the model for an error response.
 *
 * @param message The message describing the error response.
 * @param errorCode The code for the error response.
 */
data class ErrorModel(
    val message: String = EMPTY_STRING,
    val errorCode: Int = -1,
) {
    companion object {
        val emptyValue = ErrorModel()
    }
}
