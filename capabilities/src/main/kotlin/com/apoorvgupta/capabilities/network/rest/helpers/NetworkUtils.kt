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
 * Get connection type
 *
 * @param context
 * @return connection type. 0: none; 1: mobile data; 2: wifi; 3: vpn
 */
fun getConnectionType(context: Context): Int {
    var result = 0
    val connectivityManager = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager?
    connectivityManager?.run {
        connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)?.run {
            when {
                hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    result = 1
                }
                hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    result = 2
                }
                hasTransport(NetworkCapabilities.TRANSPORT_VPN) -> {
                    result = 3
                }
            }
        }
    }
    return result
}

/**
 * Fetch error generic error body
 *
 * @param httpErrorCode
 * @param errorBody
 * @return
 */
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

/**
 * Get network type
 *
 * @param context
 * @return Network type
 */
fun getNetworkType(context: Context): String {
    val connectivityManager = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork
    val capabilities = connectivityManager.getNetworkCapabilities(network)
    if (capabilities != null) {
        if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
            return "WiFi"
        } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
            val upstreamBandwidth = capabilities.linkUpstreamBandwidthKbps
            return when {
                upstreamBandwidth < 500 -> {
                    "2G"
                }
                upstreamBandwidth < 2000 -> {
                    "3G"
                }
                upstreamBandwidth < 20000 -> {
                    "4G"
                }
                else -> {
                    "5G"
                }
            }
        }
    }
    return "Unknown"
}
