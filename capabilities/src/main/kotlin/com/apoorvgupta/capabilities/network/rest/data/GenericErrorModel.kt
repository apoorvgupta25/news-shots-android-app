/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */
package com.apoorvgupta.capabilities.network.rest.data

/**
 * This class contains the generic error model.
 *
 * @property code The error code.
 * @property message The error message.
 * @property status The error status.
 * @property errorCode The specific error code.
 *
 * @author Apoorv Gupta
 */
data class GenericErrorModel(
    val code: Int = -1,
    val message: String? = null,
    val status: String = "",
)
