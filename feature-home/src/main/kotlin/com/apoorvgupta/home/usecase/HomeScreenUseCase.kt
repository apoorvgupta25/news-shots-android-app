package com.apoorvgupta.home.usecase

import com.apoorvgupta.home.models.HomeDataModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Apoorv Gupta
 */
fun interface HomeScreenUseCase {
    fun getHomeScreenContentData(): Flow<HomeDataModel>
}
