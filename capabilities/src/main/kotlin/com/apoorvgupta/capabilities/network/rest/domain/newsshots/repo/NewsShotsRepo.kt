package com.apoorvgupta.capabilities.network.rest.domain.newsshots.repo

import com.apoorvgupta.capabilities.network.rest.data.model.NewsShots
import com.apoorvgupta.capabilities.network.rest.helpers.Resource
import kotlinx.coroutines.flow.Flow

/**
 * News shots repo
 *
 * @constructor Create empty News shots repo
 *
 * @author Apoorv Gupta
 */
fun interface NewsShotsRepo {
    fun getRecentNewsShots(limit: Int, sortBy: String): Flow<Resource<List<NewsShots>?>>
}