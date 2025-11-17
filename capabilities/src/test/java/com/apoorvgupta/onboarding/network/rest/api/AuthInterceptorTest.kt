/**
 * Copyright (c) 2025 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.onboarding.network.rest.api

import com.apoorvgupta.capabilities.network.rest.api.AuthInterceptor
import com.apoorvgupta.capabilities.network.rest.constants.ApiConstants.HTTP_HEADER_REQUEST_AUTHORIZATION_KEY
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase.assertTrue
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Before
import org.junit.Test

/**
 * This unit test exercises the AuthInterceptor class.
 *
 * @author Apoorv Gupta
 */
class AuthInterceptorTest {
    private lateinit var authInterceptor: AuthInterceptor

    /**
     * This function executes before every test.
     */
    @Before
    fun setup() {
        MockKAnnotations.init(this)
        authInterceptor = AuthInterceptor()
    }

    /**
     * This test verifies that the intercept function returns a response when the authorizationHeaderValue is set.
     */
    @Test
    fun `intercept returns response when authorizationHeaderValue is set`() {
        // Given
        val authToken = "YOUR_AUTH_TOKEN"
        authInterceptor.setAuthHeaderValue(authToken)

        val mockChain: Interceptor.Chain =
            mockk(relaxed = true) {
                every { request() } returns
                    Request.Builder()
                        .url("http://somehost/somepath")
                        .build()

                every { proceed(any()) } returns
                    Response.Builder()
                        .request(request())
                        .protocol(Protocol.HTTP_1_1)
                        .code(200)
                        .message("Test")
                        .body("abc".toResponseBody())
                        .build()
            }

        // When
        val result = authInterceptor.intercept(mockChain)

        // Then
        assertTrue(result is Response)
    }

    /**
     * This test verifies that the intercept function does not add the Authorization Header when authorizationHeaderValue is null.
     */
    @Test
    fun `intercept does not add Authorization Header when authorizationHeaderValue is null`() {
        // Given
        authInterceptor.authorizationHeaderValue = null

        val chain = mockk<Interceptor.Chain>()
        val requestBuilder = mockk<Request.Builder>()
        val request = mockk<Request>()
        val modifiedRequest = mockk<Request>()

        every { chain.request() } returns request
        every { request.newBuilder() } returns requestBuilder
        every { requestBuilder.addHeader(any(), any()) } returns requestBuilder
        every { requestBuilder.build() } returns modifiedRequest
        every { chain.proceed(modifiedRequest) } returns mockk()

        // When
        authInterceptor.intercept(chain)

        // Then
        verify(exactly = 0) {
            requestBuilder.addHeader(
                HTTP_HEADER_REQUEST_AUTHORIZATION_KEY,
                "YOUR_ACCESS_TOKEN",
            )
        }
    }
}
