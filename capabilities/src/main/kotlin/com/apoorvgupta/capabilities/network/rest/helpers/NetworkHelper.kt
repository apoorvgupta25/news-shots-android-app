/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.capabilities.network.rest.helpers

import android.content.Context
import com.apoorvgupta.capabilities.network.rest.data.ErrorCode
import com.apoorvgupta.capabilities.network.rest.data.GenericErrorModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

/**
 * A utility function for making safe API calls within a Kotlin coroutine Flow. It handles
 * network availability, emits loading, success, or error states, and provides a consistent
 * approach for handling API responses.
 *
 * @param context The Android context used for checking network availability.
 * @param api The suspend function representing the API call to be executed.
 * @return A Flow emitting [Resource] states representing loading, success, or error.
 *
 * @author Apoorv Gupta
 */
suspend fun <T> makeSafeApiCall(context: Context, api: suspend () -> Resource<T?>) = flow {
    emit(Resource.loading())
    if (context.isNetworkAvailable()) {
        val response = api.invoke()
        if (response.status == Resource.Status.ERROR) {
            emit(Resource.error(error = response.error))
        } else if (response.status == Resource.Status.SUCCESS) {
            emit(Resource.success(response.data))
        }
    } else {
        ConnectivityChannel.publish(connectionLoss = true)
        emit(
            Resource.error(
                error = GenericErrorModel(
                    errorCode = ErrorCode.NETWORK_NOT_AVAILABLE,
                    message = "",
                ),
            ),
        )
    }
}.catch { e ->
    emit(
        Resource.error(
            error = GenericErrorModel(
                errorCode = ErrorCode.NETWORK_CONNECTION_FAILED,
                message = e.message,
            ),
        ),
    )
}
