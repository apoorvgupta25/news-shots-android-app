/**
 * Copyright (c) 2025 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.capabilities.network.rest.helpers

import com.apoorvgupta.capabilities.network.rest.data.GenericErrorModel

/**
 * A generic class that contains data and status about loading this data Success,Loading and Error.
 *
 * @author Apoorv Gupta
 */
data class Resource<out T>(val status: Status, val data: T?, val error: GenericErrorModel?) {
    companion object {
        // Handles success
        fun <T> success(data: T): Resource<T> = Resource(
            status = Status.SUCCESS,
            data = data,
            error = null,
        )

        // Handles Loading
        fun <T> loading(data: T? = null): Resource<T> = Resource(
            status = Status.LOADING,
            data = data,
            error = null,
        )

        // Handles Error
        fun <T> error(
            data: T? = null,
            error: GenericErrorModel? = null,
        ): Resource<T> = Resource(
            status = Status.ERROR,
            data = data,
            error = error,
        )

        // Handles Idle/No Action
        fun <T> idle(data: T? = null) = Resource(status = Status.NONE, data = data, error = null)
    }

    // Enum to represent different states of the resource
    enum class Status {
        NONE, // No action/Idle state
        SUCCESS, // Success state
        ERROR, // Error state
        LOADING, // Loading state
    }
}
