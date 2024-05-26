package com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase

import com.apoorvgupta.capabilities.network.rest.domain.newsshots.data.ErrorRecentNewsShotsDataResponseModel
import com.apoorvgupta.capabilities.network.rest.domain.newsshots.data.RecentNewsShotsDataResult
import com.apoorvgupta.capabilities.network.rest.domain.newsshots.repo.NewsShotsRepo
import com.apoorvgupta.capabilities.network.rest.data.model.NewsShots
import com.apoorvgupta.capabilities.network.rest.helpers.Resource
import com.apoorvgupta.core.utils.DataStatus
import com.apoorvgupta.core.utils.getValueOrEmpty
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

class GetRecentNewsShotsUseCaseImpl @Inject constructor(
    private val newsShotsRepo: NewsShotsRepo,
) : GetRecentNewsShotsUseCase {

    override fun getRecentNewsShots(): Flow<RecentNewsShotsDataResult> {
        return newsShotsRepo.getRecentNewsShots(3, "createdAt").transform { response ->
            when (response.status) {
                Resource.Status.SUCCESS -> {
                    emit(
                        RecentNewsShotsDataResult(
                            status = DataStatus.Success,
                            successResponseModel = response.data as List<NewsShots>,
                        ),
                    )
                }

                Resource.Status.LOADING -> {
                    emit(
                        RecentNewsShotsDataResult(
                            status = DataStatus.Loading,
                        ),
                    )
                }

                else -> {
                    emit(
                        RecentNewsShotsDataResult(
                            status = DataStatus.Error,
                            errorResponseModel = ErrorRecentNewsShotsDataResponseModel(
                                message = response.error?.message.getValueOrEmpty(),
                            ),
                        ),
                    )
                }
            }
        }
    }
}
