package com.apoorvgupta.capabilities.network.rest.interceptor

import com.apoorvgupta.capabilities.util.Constants.ENABLE_APP_CACHE
import com.apoorvgupta.core.logger.AppLogger
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.TimeUnit

const val HTTP_HEADER_CACHING_CONTROL = "Cache-Control"

/**
 * Interceptor for caching API response
 *
 * @author Apoorv Gupta
 */
class CacheInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response: Response = chain.proceed(chain.request())
        if (request.url.queryParameter(ENABLE_APP_CACHE)?.toBoolean() == true) {
            val cacheControl1 = CacheControl.Builder()
                .maxAge(1, TimeUnit.MINUTES)
                .build()

            val cacheControl = response.header(HTTP_HEADER_CACHING_CONTROL)

            if (cacheControl == null ||
                cacheControl.contains("no-store") ||
                cacheControl.contains("no-cache") ||
                cacheControl.contains("must-revalidate") ||
                cacheControl.contains("max-age=0")
            ) {
                // No cache headers, skip caching
                AppLogger.d { "No Caching $cacheControl" }
            }

            return response.newBuilder().removeHeader("Pragma").removeHeader("pragma")
                .header(HTTP_HEADER_CACHING_CONTROL, cacheControl1.toString())
                .build()
        }
        return response
    }
}
