package com.apoorvgupta.home.data.network

import com.apoorvgupta.home.models.FinanceDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit API interface for handling home-related HTTP requests.
 *
 * @author Apoorv Gupta
 */

interface HomeApiService {

    /**
     * Retrieves user data.
     * @param appVersion The version of the application.
     * @return A Response object containing the refresh data response.
     */
    @GET("api/Account/RefreshData")
    suspend fun getUserData(
        @Query("appVersion") appVersion: String,
    ): Response<FinanceDataResponse>
}
