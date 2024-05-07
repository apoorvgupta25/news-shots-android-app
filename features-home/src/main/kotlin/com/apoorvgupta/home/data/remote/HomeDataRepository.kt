package com.apoorvgupta.home.data.remote

import com.apoorvgupta.capabilities.network.rest.helpers.Resource
import com.apoorvgupta.home.models.FinanceDataResponse
import com.apoorvgupta.home.models.refreshdata.RefreshDataResponse
import kotlinx.coroutines.flow.Flow

/**
 * Repository for user refresh Data and campaign related data
 *
 * @constructor Create empty Refresh data repo
 *
 * @author Apoorv Gupta
 */
interface HomeDataRepository {

    /**
     * Get user refresh data Function to fetch the user refresh Data
     *
     * @param appVersion passed as query parameter in api
     * @return Flow emitting [Resource] states representing loading, success, or error for [RefreshDataResponse]
     */
    suspend fun getUserRefreshData(appVersion: String): Flow<Resource<FinanceDataResponse?>>
}
