package com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase

import com.apoorvgupta.capabilities.network.rest.data.newsshots.NewsShots
import com.apoorvgupta.capabilities.network.rest.helpers.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Get searched news shots use case
 *
 * @constructor Create empty Get searched news shots use case
 *
 * @author Apoorv Gupta
 */
fun interface GetSearchedNewsShotsUseCase {
    fun getSearchedNewsShots(searchKeyword: String): Flow<Resource<List<NewsShots>?>>
}
