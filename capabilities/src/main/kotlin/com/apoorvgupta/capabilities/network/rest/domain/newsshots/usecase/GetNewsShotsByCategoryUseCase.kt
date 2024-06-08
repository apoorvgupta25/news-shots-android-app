package com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase

import com.apoorvgupta.capabilities.network.rest.data.newsshots.NewsShots
import com.apoorvgupta.capabilities.network.rest.helpers.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Get news shots by category use case
 *
 * @constructor Create empty Get news shots by category use case
 *
 * @author Apoorv Gupta
 */
fun interface GetNewsShotsByCategoryUseCase {
    fun getNewsShotsByCategory(categoryName: String): Flow<Resource<List<NewsShots>?>>
}