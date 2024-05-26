package com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase

import com.apoorvgupta.capabilities.network.rest.data.model.NewsShots
import com.apoorvgupta.capabilities.network.rest.domain.newsshots.data.RecentNewsShotsDataResult
import com.apoorvgupta.capabilities.network.rest.helpers.Resource
import kotlinx.coroutines.flow.Flow

fun interface GetRecentNewsShotsUseCase {
    fun getRecentNewsShots(): Flow<Resource<List<NewsShots>?>>
}
