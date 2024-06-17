package com.apoorvgupta.capabilities.network.rest.domain.categories.repo

import com.apoorvgupta.capabilities.network.rest.data.categories.Category
import com.apoorvgupta.capabilities.network.rest.helpers.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Categories repo
 *
 * @constructor Create empty Categories repo
 *
 * @author Apoorv Gupta
 */
fun interface CategoriesRepo {
    fun getCategories(): Flow<Resource<List<Category>?>>
}
