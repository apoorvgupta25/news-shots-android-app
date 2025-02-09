/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.capabilities.network.rest.helpers

import android.content.Context
import com.apoorvgupta.capabilities.network.rest.data.ErrorCode
import com.apoorvgupta.capabilities.network.rest.data.GenericErrorModel
import com.apoorvgupta.core.utils.emptyValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

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
fun <T> makeSafeApiCall(context: Context, api: suspend () -> Resource<T?>) = flow {
    emit(Resource.loading())
    if (getConnectionType(context) != 0) {
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
                    code = ErrorCode.NETWORK_NOT_AVAILABLE,
                    message = String.emptyValue(),
                ),
            ),
        )
    }
}.catch { e ->
    emit(
        Resource.error(
            error = GenericErrorModel(
                code = ErrorCode.NETWORK_CONNECTION_FAILED,
                message = e.message,
            ),
        ),
    )
}

fun <T> safeApiCallChannel(
    apiCall: suspend () -> Response<T>,
) = channelFlow<Resource<T>> {
    send(Resource.loading())
    try {
        val response = apiCall()
        if (response.isSuccessful) {
            val body = response.body()
            body?.let {
                send(Resource.success(body))
                return@channelFlow
            }
        }
        send(error("${response.code()} ${response.message()}"))
        return@channelFlow
    } catch (e: Exception) {
        send(error(e.message ?: e.toString()))
        return@channelFlow
    }
}.flowOn(Dispatchers.IO)
