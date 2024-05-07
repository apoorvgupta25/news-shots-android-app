/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.onboarding.network.rest.data

import com.apoorvgupta.capabilities.network.rest.data.GenericErrorModel
import io.mockk.MockKAnnotations
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * This unit test exercises the GenericErrorModel class.
 *
 * @author Apoorv Gupta
 */
class GenericErrorModelTest {
    /**
     * This function executes before every test.
     */
    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    /**
     * This test verifies that the GenericErrorModel class is created with default values.
     */
    @Test
    fun `create GenericErrorModel with default values`() {
        // When
        val genericErrorModel = GenericErrorModel()

        // Then
        assertEquals(-1, genericErrorModel.code)
        assertEquals(null, genericErrorModel.message)
        assertEquals("", genericErrorModel.status)
        assertEquals(-1, genericErrorModel.errorCode)
    }

    /**
     * This test verifies that the GenericErrorModel class is created with custom values.
     */
    @Test
    fun `create GenericErrorModel with custom values`() {
        // Given
        val code = 404
        val message = "Not Found"
        val status = "error"
        val errorCode = 123

        // When
        val genericErrorModel = GenericErrorModel(code, message, status, errorCode)

        // Then
        assertEquals(code, genericErrorModel.code)
        assertEquals(message, genericErrorModel.message)
        assertEquals(status, genericErrorModel.status)
        assertEquals(errorCode, genericErrorModel.errorCode)
    }

    /**
     * This test verifies that the GenericErrorModel class is created with a null message.
     */
    @Test
    fun `create GenericErrorModel with null message`() {
        // Given
        val code = 500
        val status = "error"
        val errorCode = 500

        // When
        val genericErrorModel = GenericErrorModel(code = code, status = status, errorCode = errorCode)

        // Then
        assertEquals(code, genericErrorModel.code)
        assertEquals(null, genericErrorModel.message)
        assertEquals(status, genericErrorModel.status)
        assertEquals(errorCode, genericErrorModel.errorCode)
    }
}
