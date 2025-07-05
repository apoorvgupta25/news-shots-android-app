/**
 * Copyright (c) 2025 Apoorv Gupta
 * All rights reserved.
 */
package com.apoorvgupta.capabilities.network.rest.api

import com.apoorvgupta.core.utils.emptyValue
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Interceptor class for handling authorization headers in HTTP requests.
 *
 * This class is responsible for intercepting requests and applying the Authorization Header.
 * The Authorization Header value can be set dynamically using the provided `setAuthHeaderValue` function.
 * The class is marked as a singleton to ensure a single instance across the application.
 *
 * @author Apoorv Gupta
 */
@Singleton
class AuthInterceptor @Inject constructor() : Interceptor {
    // Volatile variables for thread safety
    @Volatile
    var authorizationHeaderValue: String? = null

    @Volatile
    var anonymousHeaderValue = String.emptyValue()

    // Initialize with a default anonymous token value
    init {
        setAuthHeaderValue("YOUR_TOKEN_HERE")
    }

    /**
     * Function to set the Authorization Header value dynamically.
     *
     * @param authToken The new Authorization token to be set.
     */
    fun setAuthHeaderValue(authToken: String?) {
        if (authToken != null) {
            this.anonymousHeaderValue = authToken
        }
    }

    /**
     * Intercepts the request and adds the Authorization Header if available.
     *
     * @param chain The interceptor chain.
     * @return The modified response after adding the Authorization Header.
     * @throws IOException If an I/O error occurs during the request.
     */
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        // Proceed with the modified request
        return chain.proceed(request.build())
    }
}
