package com.apoorvgupta.capabilities.network.rest.domain.categories.usecase

import com.apoorvgupta.capabilities.network.rest.data.categories.Category
import com.apoorvgupta.capabilities.network.rest.domain.categories.repo.CategoriesRepo
import com.apoorvgupta.capabilities.network.rest.helpers.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

/**
 * @author Apoorv Gupta
 */
class GetAllCategoriesUseCaseImpl @Inject constructor(
    private val categoriesRepo: CategoriesRepo,
) : GetAllCategoriesUseCase {

    /**
     * Gets all categories.
     *
     * @return the flow
     */
    override fun getAllCategories(): Flow<Resource<List<Category>?>> =
        categoriesRepo.getCategories().transform { response ->
            emit(response)
        }
}
