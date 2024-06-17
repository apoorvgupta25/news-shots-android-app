package com.apoorvgupta.capabilities.network.rest.domain.newsshots

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.apoorvgupta.capabilities.network.rest.api.RemoteDataSource
import com.apoorvgupta.capabilities.network.rest.data.newsshots.NewsShots
import com.apoorvgupta.core.logger.AppLogger
import javax.inject.Inject

/**
 * @author Apoorv Gupta
 */
class NewsShotsPagingSource @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val perPageLimit: Int,
) : PagingSource<Int, NewsShots>() {

    override fun getRefreshKey(state: PagingState<Int, NewsShots>) =
        state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(8)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(8)
        }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewsShots> {
        val page = params.key ?: 0
        AppLogger.d { "NewsShotsPagingSource: $page" }
        val response = remoteDataSource.getDailyNewsShots(perPageLimit, "createdAt", page/*(page+1)*perPageLimit*/)
        return try {
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
