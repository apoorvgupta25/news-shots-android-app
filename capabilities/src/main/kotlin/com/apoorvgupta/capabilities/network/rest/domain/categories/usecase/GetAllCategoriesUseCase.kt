package com.apoorvgupta.capabilities.network.rest.domain.categories.usecase

import com.apoorvgupta.capabilities.network.rest.data.categories.Category
import com.apoorvgupta.capabilities.network.rest.helpers.Resource
import kotlinx.coroutines.flow.Flow

/**
 * @author Apoorv Gupta
 */
fun interface GetAllCategoriesUseCase {
    fun getAllCategories(): Flow<Resource<List<Category>?>>
}
