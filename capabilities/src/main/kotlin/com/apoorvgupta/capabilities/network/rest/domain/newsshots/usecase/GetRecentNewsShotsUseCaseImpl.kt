package com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase

import com.apoorvgupta.capabilities.network.rest.domain.newsshots.repo.NewsShotsRepo
import com.apoorvgupta.capabilities.util.Constants
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
    override fun getRecentNewsShots() = newsShotsRepo.getRecentNewsShots(
        limit = Constants.DAILY_POST_LIMIT,
        sortBy = Constants.DAILY_POST_SORT_BY_CREATED,
    ).transform { response ->
        emit(response)
    }
}
