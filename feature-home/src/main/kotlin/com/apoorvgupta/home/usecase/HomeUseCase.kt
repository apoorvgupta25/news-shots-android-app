package com.apoorvgupta.home.usecase

import com.apoorvgupta.home.models.FinanceDataResult
import com.apoorvgupta.home.models.HomeDataModel
import kotlinx.coroutines.flow.Flow

/**
 * A use case interface for fetching various types of data related to the home screen.
 *
 * @author Apoorv Gupta
 */
interface HomeUseCase {

    /**
     * Retrieves banner data for the specified campaign and app version.
     *
     */
    suspend fun getRefreshData(): Flow<FinanceDataResult>

    /**
     * This function returns the home screen content.
     */
    fun getHomeScreenData(): HomeDataModel
}
