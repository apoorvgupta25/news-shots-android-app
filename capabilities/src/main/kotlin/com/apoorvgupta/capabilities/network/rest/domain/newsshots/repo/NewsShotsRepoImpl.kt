package com.apoorvgupta.capabilities.network.rest.domain.newsshots.repo

import android.content.Context
import com.apoorvgupta.capabilities.network.rest.api.RemoteDataSource
import com.apoorvgupta.capabilities.network.rest.helpers.makeSafeApiCall
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * News shots repo impl
 *
 * @property context
 * @property remoteDataSource
 * @constructor Create empty News shots repo impl
 *
 * @author Apoorv Gupta
 */
class NewsShotsRepoImpl @Inject constructor(
    @ApplicationContext val context: Context,
    private val remoteDataSource: RemoteDataSource,
) : NewsShotsRepo {

    /**
     * Get recent news shots
     *
     * @param limit
     * @param sortBy
     * @return
     */
    override fun getRecentNewsShots(limit: Int, sortBy: String) =
        makeSafeApiCall(context) { remoteDataSource.getDailyNewsShots(limit, sortBy) }

    override fun getNewsShotsByCategory(categoryName: String) =
        makeSafeApiCall(context) { remoteDataSource.getNewsShotsByCategory(categoryName) }

    override fun getIndividualNewsShots(postLink: String) =
        makeSafeApiCall(context) { remoteDataSource.getIndividualPost(postLink) }

    override fun getSearchedNewsShots(searchKeyword: String) =
        makeSafeApiCall(context) { remoteDataSource.getSearchedPost(searchKeyword) }
}
