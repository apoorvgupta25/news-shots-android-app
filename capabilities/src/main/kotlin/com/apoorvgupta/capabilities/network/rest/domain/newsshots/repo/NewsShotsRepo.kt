package com.apoorvgupta.capabilities.network.rest.domain.newsshots.repo

import androidx.paging.PagingData
import com.apoorvgupta.capabilities.network.rest.data.newsshots.NewsShots
import com.apoorvgupta.capabilities.network.rest.helpers.Resource
import kotlinx.coroutines.flow.Flow

/**
 * News shots repo
 *
 * @constructor Create empty News shots repo
 *
 * @author Apoorv Gupta
 */
interface NewsShotsRepo {
    fun getRecentNewsShots(limit: Int, sortBy: String): Flow<Resource<List<NewsShots>?>>

    fun getNewsShotsByCategory(categoryName: String): Flow<Resource<List<NewsShots>?>>

    fun getIndividualNewsShots(postLink: String): Flow<Resource<NewsShots?>>

    fun getSearchedNewsShots(searchKeyword: String): Flow<Resource<List<NewsShots>?>>

    fun getAllNewsShots(): Flow<PagingData<NewsShots>>
}
