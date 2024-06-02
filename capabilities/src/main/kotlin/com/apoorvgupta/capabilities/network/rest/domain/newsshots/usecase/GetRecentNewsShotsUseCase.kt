package com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase

import com.apoorvgupta.capabilities.network.rest.data.model.NewsShots
import com.apoorvgupta.capabilities.network.rest.helpers.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Get recent news shots use case
 *
 * @constructor Create empty Get recent news shots use case
 *
 * @author Apoorv Gupta
 */
fun interface GetRecentNewsShotsUseCase {
    fun getRecentNewsShots(): Flow<Resource<List<NewsShots>?>>
}
