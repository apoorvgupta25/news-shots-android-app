/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.capabilities.network.rest.helpers

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.apoorvgupta.capabilities.network.rest.data.GenericErrorModel
import okhttp3.ResponseBody
import org.json.JSONObject

/**
 * This class checks if the network is available or not and returns true/false.
 *
 * @author Apoorv Gupta
 */
fun Context.isNetworkAvailable(): Boolean {
    val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager?
    val activeNetworkInfo = connectivityManager!!.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnected
}

fun fetchErrorGenericErrorBody(
    httpErrorCode: Int,
    errorBody: ResponseBody?,
): GenericErrorModel {
    return if (errorBody != null) {
        val errorObj = JSONObject(errorBody.string())
        val bffErrorCode = errorObj.getString("error").toInt()
        val bffErrorMessage = errorObj.getString("error_description")
        GenericErrorModel(code = httpErrorCode, message = bffErrorMessage, errorCode = bffErrorCode)
    } else {
        GenericErrorModel(code = httpErrorCode)
    }
}

fun fetchForgotPasswordGenericErrorBody(
    httpErrorCode: Int,
    errorBody: ResponseBody?,
): GenericErrorModel {
    return if (errorBody != null) {
        val errorObj = JSONObject(errorBody.string())
        val bffErrorCode = errorObj.getString("Code").toInt()
        val bffErrorMessage = errorObj.getString("Message")
        GenericErrorModel(code = httpErrorCode, errorCode = bffErrorCode, message = bffErrorMessage)
    } else {
        GenericErrorModel(code = httpErrorCode)
    }
}

fun fetchMainGenericErrorBody(
    httpErrorCode: Int,
    errorBody: ResponseBody?,
): GenericErrorModel {
    return if (errorBody != null) {
        val errorObj = JSONObject(errorBody.string())
        val bffErrorCode = errorObj.getString("Code").toInt()
        val bffErrorMessage = errorObj.getString("Message")
        GenericErrorModel(code = httpErrorCode, errorCode = bffErrorCode, message = bffErrorMessage)
    } else {
        GenericErrorModel(code = httpErrorCode)
    }
}

fun setGenericErrorMessage(bffErrorCode: String, message: String?): String {
    return "Unexpected error occurred"
}

fun getNetworkType(context: Context): String {
    val connectivityManager = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork
    val capabilities = connectivityManager.getNetworkCapabilities(network)
    if (capabilities != null) {
        if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
            return "WiFi"
        } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
            val upstreamBandwidth = capabilities.linkUpstreamBandwidthKbps
            return if (upstreamBandwidth < 500) {
                "2G"
            } else if (upstreamBandwidth < 2000) {
                "3G"
            } else if (upstreamBandwidth < 20000) {
                "4G"
            } else {
                "5G"
            }
        }
    }
    return "Unknown"
}
