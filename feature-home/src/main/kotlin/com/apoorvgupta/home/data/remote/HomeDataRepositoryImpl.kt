package com.apoorvgupta.home.data.remote

import android.content.Context
import com.apoorvgupta.capabilities.network.rest.helpers.Resource
import com.apoorvgupta.capabilities.network.rest.helpers.makeSafeApiCall
import com.apoorvgupta.home.data.network.HomeRemoteDataSource
import com.apoorvgupta.home.models.refreshdata.RefreshDataResponse
import javax.inject.Inject

/**
 * Implementation of [HomeDataRepository] repository interface
 *
 * @property context Android application context injected for checking network availability.
 * @property homeRemoteDataSource Home Remote Data Source for making API call
 * @constructor Create empty Refresh Data repo impl
 *
 * @author Apoorv Gupta
 */
class HomeDataRepositoryImpl @Inject constructor(
    private val context: Context,
    private val homeRemoteDataSource: HomeRemoteDataSource,
) : HomeDataRepository {

    /**
     * Get user refresh data Function to fetch the user refresh Data
     *
     * @param appVersion passed as query parameter in api
     * @return Flow emitting [Resource] states representing loading, success, or error for [RefreshDataResponse]
     */
    override suspend fun getUserRefreshData(appVersion: String) =
        makeSafeApiCall(context) { homeRemoteDataSource.getUserRefreshData(appVersion) }
}
