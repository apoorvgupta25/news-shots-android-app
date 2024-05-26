package com.apoorvgupta.capabilities.network.rest.domain.newsshots.repo

import android.content.Context
import com.apoorvgupta.capabilities.network.rest.api.RemoteDataSource
import com.apoorvgupta.capabilities.network.rest.data.model.NewsShots
import com.apoorvgupta.capabilities.network.rest.helpers.Resource
import com.apoorvgupta.capabilities.network.rest.helpers.makeSafeApiCall
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsShotsRepoImpl @Inject constructor(
    @ApplicationContext val context: Context,
    private val remoteDataSource: RemoteDataSource,
) : NewsShotsRepo {

    override fun getRecentNewsShots(limit: Int, sortBy: String): Flow<Resource<List<NewsShots>?>> =
        makeSafeApiCall(context) { remoteDataSource.getDailyNewsShots(limit, sortBy) }
}
