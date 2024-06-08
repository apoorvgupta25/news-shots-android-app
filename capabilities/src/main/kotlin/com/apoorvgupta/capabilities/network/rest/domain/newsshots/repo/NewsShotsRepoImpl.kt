package com.apoorvgupta.capabilities.network.rest.domain.newsshots.repo

import android.content.Context
import com.apoorvgupta.capabilities.network.rest.api.RemoteDataSource
import com.apoorvgupta.capabilities.network.rest.data.newsshots.NewsShots
import com.apoorvgupta.capabilities.network.rest.helpers.Resource
import com.apoorvgupta.capabilities.network.rest.helpers.makeSafeApiCall
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
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
    override fun getRecentNewsShots(limit: Int, sortBy: String): Flow<Resource<List<NewsShots>?>> =
        makeSafeApiCall(context) { remoteDataSource.getDailyNewsShots(limit, sortBy) }
}
