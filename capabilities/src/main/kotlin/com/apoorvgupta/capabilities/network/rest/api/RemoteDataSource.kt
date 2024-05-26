package com.apoorvgupta.capabilities.network.rest.api

import com.apoorvgupta.capabilities.network.rest.data.model.NewsShots
import com.apoorvgupta.capabilities.network.rest.helpers.Resource
import com.apoorvgupta.capabilities.network.rest.helpers.fetchErrorGenericErrorBody
import com.apoorvgupta.core.logger.AppLogger
import com.apoorvgupta.core.threading.DispatcherProvider
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * This class handles the api calls related to main screen of app.
 */
@Singleton
class RemoteDataSource @Inject constructor(
    private val apiService: ApiService,
    private val dispatcher: DispatcherProvider,
) {

    suspend fun getDailyNewsShots(limit: Int, sortBy: String): Resource<List<NewsShots>?> {
        return withContext(dispatcher.io) {

            val response = apiService.getDailyNewsShots(
                limit = limit,
                sortBy = sortBy
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