package com.apoorvgupta.capabilities.network.rest.usecase

import com.apoorvgupta.capabilities.network.rest.api.MainRemoteDataRepository
import javax.inject.Inject

/**
 * Interface defining the contract for interacting with the App Main Screen use case.
 *
 * @author Apoorv Gupta
 */
class MainUseCaseImpl @Inject constructor(
    private val mainRemoteDataRepository: MainRemoteDataRepository,
) : MainUseCase
