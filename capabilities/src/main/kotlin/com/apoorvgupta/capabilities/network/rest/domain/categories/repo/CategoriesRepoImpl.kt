package com.apoorvgupta.capabilities.network.rest.domain.categories.repo

import android.content.Context
import com.apoorvgupta.capabilities.network.rest.api.RemoteDataSource
import com.apoorvgupta.capabilities.network.rest.data.categories.Category
import com.apoorvgupta.capabilities.network.rest.helpers.Resource
import com.apoorvgupta.capabilities.network.rest.helpers.makeSafeApiCall
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @author Apoorv Gupta
 */
class CategoriesRepoImpl @Inject constructor(
    @ApplicationContext val context: Context,
    private val remoteDataSource: RemoteDataSource,
) : CategoriesRepo {

    /**
     * Get categories
     *
     * @return
     */
    override fun getCategories(): Flow<Resource<List<Category>?>> =
        makeSafeApiCall(context) { remoteDataSource.getAllCategories() }
}
