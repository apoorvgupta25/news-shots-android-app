/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.common.data.repository.remote

import android.content.Context
import com.apoorvgupta.common.data.network.CommonRemoteDataSource
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository class responsible for handling common data operations.
 *
 * @param context The Android application context injected for checking network availability.
 * @param commonRemoteDataSource The data source responsible for making common API calls.
 *
 * @author Apoorv Gupta
 */
@Singleton
class CommonRemoteDataRepository @Inject constructor(
    @ApplicationContext val context: Context,
    private val commonRemoteDataSource: CommonRemoteDataSource,
)
