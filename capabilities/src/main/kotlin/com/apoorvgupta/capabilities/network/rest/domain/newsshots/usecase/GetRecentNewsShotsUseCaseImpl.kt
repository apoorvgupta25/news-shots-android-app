package com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase

import com.apoorvgupta.capabilities.network.rest.domain.newsshots.data.ErrorRecentNewsShotsDataResponseModel
import com.apoorvgupta.capabilities.network.rest.domain.newsshots.data.RecentNewsShotsDataResult
import com.apoorvgupta.capabilities.network.rest.domain.newsshots.repo.NewsShotsRepo
import com.apoorvgupta.capabilities.network.rest.data.model.NewsShots
import com.apoorvgupta.capabilities.network.rest.helpers.Resource
import com.apoorvgupta.core.utils.DataStatus
import com.apoorvgupta.core.utils.getValueOrEmpty
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

class GetRecentNewsShotsUseCaseImpl @Inject constructor(
    private val newsShotsRepo: NewsShotsRepo,
) : GetRecentNewsShotsUseCase {

    override fun getRecentNewsShots(): Flow<Resource<List<NewsShots>?>> {
        return newsShotsRepo.getRecentNewsShots(3, "createdAt").transform { response ->
            emit(response)
        }
    }
}
