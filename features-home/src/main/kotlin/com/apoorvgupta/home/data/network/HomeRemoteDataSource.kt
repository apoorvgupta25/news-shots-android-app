package com.apoorvgupta.home.data.network

import com.apoorvgupta.capabilities.network.rest.helpers.Resource
import com.apoorvgupta.capabilities.network.rest.helpers.fetchErrorGenericErrorBody
import com.apoorvgupta.home.models.FinanceDataResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Home remote data source makes API calls using [HomeApiService]
 *
 * @property apiService Retrofit API service instance which contains all the api calls
 * @property ioCoroutineDispatcher Coroutine Dispatcher to switch coroutine context to background for API calls
 *
 * @constructor Create empty Home remote data source
 *
 * @author Apoorv Gupta
 */
class HomeRemoteDataSource @Inject constructor(
    private val apiService: HomeApiService,
    private val ioCoroutineDispatcher: CoroutineDispatcher,
) {
    suspend fun getUserRefreshData(appVersion: String): Resource<FinanceDataResponse?> {
        return withContext(ioCoroutineDispatcher) {
            val response = apiService.getUserData(
                appVersion = appVersion,
            )
            if (response.isSuccessful) {
                Resource.success(response.body())
            } else {
                Resource.error(
                    data = null,
                    error = fetchErrorGenericErrorBody(response.code(), response.errorBody()),
                )
            }
        }
    }
}
