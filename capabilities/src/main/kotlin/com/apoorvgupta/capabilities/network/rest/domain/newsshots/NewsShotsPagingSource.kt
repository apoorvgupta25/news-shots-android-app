package com.apoorvgupta.capabilities.network.rest.domain.newsshots

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.apoorvgupta.capabilities.network.rest.api.RemoteDataSource
import com.apoorvgupta.capabilities.network.rest.data.newsshots.NewsShots
import com.apoorvgupta.capabilities.network.rest.helpers.Resource
import com.apoorvgupta.core.utils.EMPTY_STRING
import com.apoorvgupta.core.utils.getValueOrEmpty
import javax.inject.Inject

/**
 * @author Apoorv Gupta
 */
class NewsShotsPagingSource @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val perPageLimit: Int,
    private val categoryName: String = EMPTY_STRING,
) : PagingSource<Int, NewsShots>() {

    override fun getRefreshKey(state: PagingState<Int, NewsShots>) =
        state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(8)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(8)
        }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewsShots> {
        val page = params.key ?: 0

        val response = if (categoryName.isEmpty()) {
            remoteDataSource.getDailyNewsShots(perPageLimit, "createdAt", page)
        } else {
            remoteDataSource.getNewsShotsByCategory(categoryName, perPageLimit, page)
        }

        return try {
            if (response.status != Resource.Status.SUCCESS) {
                return LoadResult.Error(
                    Exception(
                        response.error?.message.getValueOrEmpty(),
                    ),
                )
            }

            LoadResult.Page(
                data = response.data ?: emptyList(),
                prevKey = if (page == 0) null else page.minus(8),
                nextKey = if (response.data.isNullOrEmpty()) null else page.plus(8),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}