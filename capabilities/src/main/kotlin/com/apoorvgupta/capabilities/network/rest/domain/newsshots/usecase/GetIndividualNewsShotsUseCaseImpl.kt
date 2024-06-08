package com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase

import com.apoorvgupta.capabilities.network.rest.data.newsshots.NewsShots
import com.apoorvgupta.capabilities.network.rest.domain.newsshots.repo.NewsShotsRepo
import com.apoorvgupta.capabilities.network.rest.helpers.Resource
import kotlinx.coroutines.flow.Flow
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
     * @param postName
     * @return
     */
    override fun getIndividualNewsShots(postName: String): Flow<Resource<NewsShots?>> =
        newsShotsRepo.getIndividualNewsShots(postName = postName).transform { response ->
            emit(response)
        }
}
