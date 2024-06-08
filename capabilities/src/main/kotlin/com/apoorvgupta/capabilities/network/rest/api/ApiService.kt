package com.apoorvgupta.capabilities.network.rest.api

import com.apoorvgupta.capabilities.network.rest.data.categories.Category
import com.apoorvgupta.capabilities.network.rest.data.newsshots.NewsShots
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * This interface represents the api services for App
 *
 * @author Apoorv Gupta
 */
interface ApiService {

    /**
     * Get daily news shots
     *
     * @param limit
     * @param sortBy
     * @return
     */
    @GET("api/daily")
    suspend fun getDailyNewsShots(
        @Query("limit") limit: Int,
        @Query("sortBy") sortBy: String,
    ): Response<List<NewsShots>>

    /**
     * Get all categories
     *
     * @return
     */
    @GET("api/all/categories")
    suspend fun getAllCategories(): Response<List<Category>>

    /**
     * Get post by category
     *
     * @param categoryName
     * @return
     */
    @GET("api/daily/category/{categoryName}")
    suspend fun getPostByCategory(
        @Path("categoryName") categoryName: String
    ): Response<List<NewsShots>>

    /**
     * Get individual post
     *
     * @param postName
     * @return
     */
    @GET("api/daily/{postName}")
    suspend fun getIndividualPost(
        @Path("postName") postName: String
    ): Response<NewsShots>

}
