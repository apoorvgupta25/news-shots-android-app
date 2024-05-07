/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.onboarding.network.rest.helpers

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.apoorvgupta.capabilities.network.rest.helpers.isNetworkAvailable
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

/**
 * This unit test exercises the NetworkUtils class.
 *
 * @author Apoorv Gupta
 */
class NetworkUtilsTest {
    private lateinit var context: Context
    private lateinit var connectivityManager: ConnectivityManager
    private lateinit var networkInfo: NetworkInfo

    /**
     * This function executes before every test.
     */
    @Before
    fun setUp() {
        context = mockk(relaxed = true)
        connectivityManager = mockk()
        networkInfo = mockk()

        every { context.getSystemService(Context.CONNECTIVITY_SERVICE) } returns connectivityManager
        every { connectivityManager.activeNetworkInfo } returns networkInfo

        mockkStatic(NetworkInfo::class)
    }

    /**
     * This test verifies that the isNetworkAvailable() function returns true when the network is connected.
     */
    @Test
    fun `isNetworkAvailable returns true when network is connected`() {
        // Given
        every { networkInfo.isConnected } returns true

        // When
        val result = context.isNetworkAvailable()

        // Then
        assertTrue(result)
    }

    /**
     * This test verifies that the isNetworkAvailable() function returns false when the network is not connected.
     */
    @Test
    fun `isNetworkAvailable returns false when network is not connected`() {
        // Given
        every { networkInfo.isConnected } returns false

        // When
        val result = context.isNetworkAvailable()

        // Then
        assertFalse(result)
    }

    /**
     * This test verifies that the isNetworkAvailable() function returns false when the `activeNetworkInfo` is null.
     */
    @Test
    fun `isNetworkAvailable returns false when activeNetworkInfo is null`() {
        // Given
        every { connectivityManager.activeNetworkInfo } returns null

        // When
        val result = context.isNetworkAvailable()

        // Then
        assertFalse(result)
    }

    /**
     * This test verifies that the isNetworkAvailable() function returns false when both the `activeNetworkInfo` is null
     * and `networkInfo` isConnected is false.
     */
    @Test
    fun `isNetworkAvailable returns false when activeNetworkInfo is null and networkInfo isConnected is false`() {
        // Given
        every { connectivityManager.activeNetworkInfo } returns null
        every { networkInfo.isConnected } returns false

        // When
        val result = context.isNetworkAvailable()

        // Then
        assertFalse(result)
    }

    /**
     * This test verifies that the isNetworkAvailable() function returns false when the `activeNetworkInfo` isConnected is false.
     */
    @Test
    fun `isNetworkAvailable returns false when activeNetworkInfo isConnected is false`() {
        // Given
        every { networkInfo.isConnected } returns false

        // When
        val result = context.isNetworkAvailable()

        // Then
        assertFalse(result)
    }
}
