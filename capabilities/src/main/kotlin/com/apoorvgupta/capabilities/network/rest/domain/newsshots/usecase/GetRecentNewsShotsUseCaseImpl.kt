package com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase

import com.apoorvgupta.capabilities.network.rest.data.newsshots.NewsShots
import com.apoorvgupta.capabilities.network.rest.domain.newsshots.repo.NewsShotsRepo
import com.apoorvgupta.capabilities.network.rest.helpers.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

/**
 * Get recent news shots use case impl
 *
 * @property newsShotsRepo
 * @constructor Create empty Get recent news shots use case impl
 *
 * @author Apoorv Gupta
 */
class GetRecentNewsShotsUseCaseImpl @Inject constructor(
    private val newsShotsRepo: NewsShotsRepo,
) : GetRecentNewsShotsUseCase {

    /**
     * Get recent news shots
     *
     * @return
     */
    override fun getRecentNewsShots(): Flow<Resource<List<NewsShots>?>> =
        newsShotsRepo.getRecentNewsShots(3, "createdAt").transform { response ->
            emit(response)
        }
}
