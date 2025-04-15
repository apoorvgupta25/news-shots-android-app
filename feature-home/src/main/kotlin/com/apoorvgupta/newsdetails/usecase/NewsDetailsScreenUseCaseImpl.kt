package com.apoorvgupta.newsdetails.usecase

import com.apoorvgupta.capabilities.network.rest.data.newsshots.NewsShots
import com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase.GetIndividualNewsShotsUseCase
import com.apoorvgupta.capabilities.network.rest.helpers.Resource
import com.apoorvgupta.core.models.ErrorModel
import com.apoorvgupta.core.utils.DataStatus
import com.apoorvgupta.core.utils.getValueOrEmpty
import com.apoorvgupta.newsdetails.models.NewsDetailsContent
import com.apoorvgupta.newsdetails.models.NewsDetailsDataModel
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

/**
 * @author Apoorv Gupta
 */
class NewsDetailsScreenUseCaseImpl @Inject constructor(
    private val getIndividualNewsShotsUseCase: GetIndividualNewsShotsUseCase
) : NewsDetailsScreenUseCase {

    override fun getNewsDetailsContentData(postLink: String) =
        getIndividualNewsShotsUseCase.getIndividualNewsShots(postLink).transform {
            when (it.status) {
                Resource.Status.NONE, Resource.Status.ERROR -> {
                    emitNewsDetailError(
                        statusCode = it.error?.code.getValueOrEmpty(),
                        message = it.error?.message.getValueOrEmpty(),
                    )
                }

                Resource.Status.SUCCESS -> {
                    emit(
                        getNewsDetailsData(
                            it.data ?: NewsShots.emptyValue
                        )
                    )
                }

                else -> {
                    // Do Nothing.
                }

            }
        }


    private fun getNewsDetailsData(
        newsShot: NewsShots,
    ): NewsDetailsDataModel = NewsDetailsDataModel(
        status = DataStatus.Success,
        newsShotDetailsContent = NewsDetailsContent(
            headingText = "NewsShots Daily",
            subHeadingText = "Get daily news in 3 mins",
            categoryLabel = "Browse By Category",
            articlesLabel = "Latest articles",
        ),
        newsShot = newsShot,
    )

    private suspend fun FlowCollector<NewsDetailsDataModel>.emitNewsDetailError(
        statusCode: Int,
        message: String,
    ) {
        emit(
            NewsDetailsDataModel(
                status = DataStatus.Error,
                errorModel = ErrorModel(
                    errorCode = statusCode,
                    message = message,
                ),
            ),
        )
    }
}

