package com.apoorvgupta.capabilities.network.rest.api

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Ths class handles the api calls for main screen of app.
 */
@Singleton
class MainRemoteDataRepository @Inject constructor(
    @ApplicationContext val context: Context,
    private val mainRemoteDataSource: MainRemoteDataSource,
)
