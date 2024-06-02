package com.apoorvgupta.capabilities.network.rest.api

import com.apoorvgupta.capabilities.network.rest.data.model.NewsShots
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * This interface represents the api services for App
 *
 * @author Apoorv Gupta
 */
interface ApiService {

    @GET("api/daily")
    suspend fun getDailyNewsShots(
        @Query("limit") limit: Int,
        @Query("sortBy") sortBy: String,
    ): Response<List<NewsShots>>

}
