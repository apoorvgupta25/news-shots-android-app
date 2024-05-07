/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.common.data.network

import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Data source class responsible for making common API calls. This class interacts
 * with the [CommonApiService] to perform common operations and processes the API responses.
 *
 * @param apiService The [CommonApiService] instance used for making common API requests.
 *
 * @author Apoorv Gupta
 */
@Singleton
class CommonRemoteDataSource @Inject constructor(
    private val apiService: CommonApiService,
    private val ioCoroutineDispatcher: CoroutineDispatcher,
)
