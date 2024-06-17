package com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase

import com.apoorvgupta.capabilities.network.rest.data.newsshots.NewsShots
import com.apoorvgupta.capabilities.network.rest.helpers.Resource
import kotlinx.coroutines.flow.Flow

/**
 * @author Apoorv Gupta
 */

fun interface GetIndividualNewsShotsUseCase {
    fun getIndividualNewsShots(postLink: String): Flow<Resource<NewsShots?>>
}
