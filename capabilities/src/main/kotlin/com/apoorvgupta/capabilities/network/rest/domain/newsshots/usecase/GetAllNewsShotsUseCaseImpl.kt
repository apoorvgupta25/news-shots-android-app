package com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase

import com.apoorvgupta.capabilities.network.rest.domain.newsshots.repo.NewsShotsRepo
import javax.inject.Inject

/**
 * @author Apoorv Gupta
 */

class GetAllNewsShotsUseCaseImpl @Inject constructor(
    private val newsShotsRepo: NewsShotsRepo,
) : GetAllNewsShotsUseCase {

    override fun getAllNewsShots() = newsShotsRepo.getAllNewsShots()
}
