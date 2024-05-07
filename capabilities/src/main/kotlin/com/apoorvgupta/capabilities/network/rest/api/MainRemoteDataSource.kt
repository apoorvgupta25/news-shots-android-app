package com.apoorvgupta.capabilities.network.rest.api

import javax.inject.Inject
import javax.inject.Singleton

/**
 * This class handles the api calls related to main screen of app.
 */
@Singleton
class MainRemoteDataSource @Inject constructor(
    private val appApiService: MainApiService,
)
