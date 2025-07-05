package com.apoorvgupta.capabilities.network.rest.domain.newsshots.repo

import android.content.Context
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.apoorvgupta.capabilities.network.rest.api.RemoteDataSource
import com.apoorvgupta.capabilities.network.rest.data.newsshots.NewsShots
import com.apoorvgupta.capabilities.network.rest.domain.newsshots.NewsShotsPagingSource
import com.apoorvgupta.capabilities.network.rest.helpers.makeSafeApiCall
import com.apoorvgupta.capabilities.util.Constants
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
    val context: Context,
    private val remoteDataSource: RemoteDataSource,
) : NewsShotsRepo {

    /**
     * Get recent news shots
     *
     * @param limit
     * @param sortBy
     * @return
     */
    override fun getRecentNewsShots(limit: Int, sortBy: String) = makeSafeApiCall(context) { remoteDataSource.getDailyNewsShots(limit, sortBy) }

    /**
     * Get individual news shots
     *
     * @param postLink
     */
    override fun getIndividualNewsShots(postLink: String) = makeSafeApiCall(context) { remoteDataSource.getIndividualPost(postLink) }

    /**
     * Get searched news shots
     *
     * @param searchKeyword
     */
    override fun getSearchedNewsShots(searchKeyword: String) = makeSafeApiCall(context) { remoteDataSource.getSearchedPost(searchKeyword) }

    /**
     * Get all news shots
     *
     * @return
     */
    override fun getAllNewsShots(): Flow<PagingData<NewsShots>> {
        val perPageLimit = Constants.POST_PER_PAGE
        return Pager(
            config = PagingConfig(pageSize = perPageLimit),
            pagingSourceFactory = { NewsShotsPagingSource(remoteDataSource, perPageLimit) },
        ).flow
    }

    /**
     * Get news shots by category
     *
     * @param categoryName
     */
    override fun getNewsShotsByCategory(categoryName: String): Flow<PagingData<NewsShots>> {
        val perPageLimit = Constants.POST_PER_PAGE
        return Pager(
            config = PagingConfig(pageSize = perPageLimit),
            pagingSourceFactory = { NewsShotsPagingSource(remoteDataSource, perPageLimit, categoryName) },
        ).flow
    }
}
