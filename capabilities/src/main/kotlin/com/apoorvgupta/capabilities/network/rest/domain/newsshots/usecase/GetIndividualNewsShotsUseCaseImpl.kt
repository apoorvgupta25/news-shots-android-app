package com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase

import com.apoorvgupta.capabilities.network.rest.domain.newsshots.repo.NewsShotsRepo
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

/**
 * @author Apoorv Gupta
 */
class GetIndividualNewsShotsUseCaseImpl @Inject constructor(
    private val newsShotsRepo: NewsShotsRepo,
) : GetIndividualNewsShotsUseCase {

    /**
     * Get individual news shots
     *
     * @param postLink
     * @return
     */
    override fun getIndividualNewsShots(postLink: String) = newsShotsRepo.getIndividualNewsShots(postLink = postLink).transform { response ->
        emit(response)
    }
}
