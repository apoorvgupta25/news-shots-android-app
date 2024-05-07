package com.apoorvgupta.home.usecase

import com.apoorvgupta.capabilities.network.rest.helpers.Resource
import com.apoorvgupta.core.models.ErrorResponseModel
import com.apoorvgupta.core.utils.DataStatus
import com.apoorvgupta.core.utils.getValueOrEmpty
import com.apoorvgupta.home.data.remote.HomeDataRepository
import com.apoorvgupta.home.models.FinanceDataResponse
import com.apoorvgupta.home.models.FinanceDataResult
import com.apoorvgupta.home.models.HomeContent
import com.apoorvgupta.home.models.HomeDataModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

/**
 * Implementation of the [HomeUseCase] interface responsible for retrieving various types of data related to the home screen.
 *
 * @property homeDataRepository The repository for refreshing data from the backend.
 *
 * @author Apoorv Gupta
 */
class HomeUseCaseImpl @Inject constructor(
    private val homeDataRepository: HomeDataRepository,
) : HomeUseCase {

    /**
     * Retrieves earnings and incentives data for a specific campaign, region, and zone asynchronously.
     *
     * @param campaignId The unique identifier of the campaign.
     * @param campaign The name or description of the campaign.
     * @param regionCode The code representing the region where the data is being retrieved from.
     * @param zoneCode The code representing the specific zone within the region.
     * @return A [Flow] emitting [FinanceDataResult] objects containing the response data.
     */
    override suspend fun getRefreshData(): Flow<FinanceDataResult> {
        return homeDataRepository.getUserRefreshData("").transform { response ->
            when (response.status) {
                Resource.Status.SUCCESS -> {
                    emit(
                        FinanceDataResult(
                            status = DataStatus.Success,
                            successResponseModel = response.data as FinanceDataResponse,
                        ),
                    )
                }

                Resource.Status.ERROR -> {
                    emit(
                        FinanceDataResult(
                            status = DataStatus.Error,
                            errorResponseModel = ErrorResponseModel(
                                message = response.error?.message.getValueOrEmpty(),
                                errorCode = response.error?.errorCode.getValueOrEmpty(),
                            ),
                        ),
                    )
                }

                Resource.Status.LOADING -> {
                    emit(
                        FinanceDataResult(
                            status = DataStatus.Loading,
                        ),
                    )
                }

                else -> {}
            }
        }
    }

    override fun getHomeScreenData(): HomeDataModel {
        return HomeDataModel(
            homeContent = HomeContent(
                sendText = "send",
                errorText = "Error",
            ),
        )
    }
}
