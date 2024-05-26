package com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase

import com.apoorvgupta.capabilities.network.rest.domain.newsshots.data.RecentNewsShotsDataResult
import kotlinx.coroutines.flow.Flow

fun interface GetRecentNewsShotsUseCase {
    fun getRecentNewsShots(): Flow<RecentNewsShotsDataResult>
}
