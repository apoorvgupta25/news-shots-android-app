package com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase

import com.apoorvgupta.capabilities.network.rest.domain.newsshots.repo.NewsShotsRepo
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

/**
 * Get searched news shots use case impl
 *
 * @property newsShotsRepo
 * @constructor Create empty Get searched news shots use case impl
 *
 * @author Apoorv Gupta
 */
class GetSearchedNewsShotsUseCaseImpl @Inject constructor(
    private val newsShotsRepo: NewsShotsRepo,
) : GetSearchedNewsShotsUseCase {

    /**
     * Get searched news shots
     *
     * @param searchKeyword
     * @return
     */
    override fun getSearchedNewsShots(searchKeyword: String) =
        newsShotsRepo.getSearchedNewsShots(searchKeyword = searchKeyword)
            .transform { response ->
                emit(response)
            }
}
