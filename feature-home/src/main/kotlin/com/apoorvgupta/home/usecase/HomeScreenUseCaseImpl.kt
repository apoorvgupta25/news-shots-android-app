package com.apoorvgupta.home.usecase

import com.apoorvgupta.capabilities.network.rest.data.model.NewsShots
import com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase.GetRecentNewsShotsUseCase
import com.apoorvgupta.capabilities.network.rest.helpers.Resource
import com.apoorvgupta.core.models.ErrorModel
import com.apoorvgupta.core.utils.DataStatus
import com.apoorvgupta.core.utils.getValueOrEmpty
import com.apoorvgupta.home.models.HomeContent
import com.apoorvgupta.home.models.HomeDataModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.combineTransform
import javax.inject.Inject

/**
 * @author Apoorv Gupta
 */
class HomeScreenUseCaseImpl @Inject constructor(
    private val getRecentNewsShotsUseCase: GetRecentNewsShotsUseCase,
) : HomeScreenUseCase {
    override fun getHomeScreenContentData(): Flow<HomeDataModel> {
        return getRecentNewsShotsUseCase.getRecentNewsShots()
            .combineTransform(getRecentNewsShotsUseCase.getRecentNewsShots()) { it, it1 ->

                when {
                    it.status == Resource.Status.ERROR -> {
                        emitHomeError(
                            statusCode = it.error?.code.getValueOrEmpty(),
                            message = it.error?.message.getValueOrEmpty(),
                        )
                    }

                    it1.status == Resource.Status.ERROR -> {
                        emitHomeError(
                            statusCode = it1.error?.code.getValueOrEmpty(),
                            message = it1.error?.message.getValueOrEmpty(),
                        )
                    }

                    it.status == Resource.Status.SUCCESS && it1.status == Resource.Status.SUCCESS -> {
                        emitHomeSuccess(
                            getHomeData(
                                it.data,
                                it1.data,
                            ),
                        )
                    }

                    else -> {
                        // Do nothing.
                    }
                }
            }
    }

    private fun getHomeData(
        data: List<NewsShots>?,
        data1: List<NewsShots>?,
    ): HomeDataModel {
        return HomeDataModel(
            status = DataStatus.Success,
            homeContent = HomeContent(
                sendText = "Send",
            ),
            newsShotsList = data.getValueOrEmpty(),
        )
    }

    private suspend fun FlowCollector<HomeDataModel>.emitHomeSuccess(data: HomeDataModel) {
        return emit(data)
    }

    private suspend fun FlowCollector<HomeDataModel>.emitHomeError(
        statusCode: Int,
        message: String,
    ) {
        emit(
            HomeDataModel(
                status = DataStatus.Error,
                errorModel = ErrorModel(
                    errorCode = statusCode,
                    message = message,
                ),
            ),
        )
    }
}
