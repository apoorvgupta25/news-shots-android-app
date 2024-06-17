package com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase

import com.apoorvgupta.capabilities.network.rest.domain.newsshots.repo.NewsShotsRepo
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

/**
 * Get news shots by category use case impl
 *
 * @property newsShotsRepo
 * @constructor Create empty Get news shots by category use case impl
 *
 * @author Apoorv Gupta
 */
class GetNewsShotsByCategoryUseCaseImpl @Inject constructor(
    private val newsShotsRepo: NewsShotsRepo,
) : GetNewsShotsByCategoryUseCase {

    /**
     * Get news shots by category
     *
     * @param categoryName
     * @return
     */
    override fun getNewsShotsByCategory(categoryName: String) =
        newsShotsRepo.getNewsShotsByCategory(categoryName = categoryName).transform { response ->
            emit(response)
        }
}
