package com.apoorvgupta.home.usecase

import com.apoorvgupta.capabilities.network.rest.data.categories.Category
import com.apoorvgupta.capabilities.network.rest.data.newsshots.NewsShots
import com.apoorvgupta.capabilities.network.rest.domain.categories.usecase.GetAllCategoriesUseCase
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
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
) : HomeScreenUseCase {
    override fun getHomeScreenContentData(): Flow<HomeDataModel> {
        return getRecentNewsShotsUseCase.getRecentNewsShots()
            .combineTransform(getAllCategoriesUseCase.getAllCategories()) { newsShotsData, categoriesData ->

                when {
                    newsShotsData.status == Resource.Status.ERROR -> {
                        emitHomeError(
                            statusCode = newsShotsData.error?.code.getValueOrEmpty(),
                            message = newsShotsData.error?.message.getValueOrEmpty(),
                        )
                    }

                    categoriesData.status == Resource.Status.ERROR -> {
                        emitHomeError(
                            statusCode = categoriesData.error?.code.getValueOrEmpty(),
                            message = categoriesData.error?.message.getValueOrEmpty(),
                        )
                    }

                    newsShotsData.status == Resource.Status.SUCCESS && categoriesData.status == Resource.Status.SUCCESS -> {
                        emitHomeSuccess(
                            getHomeData(
                                newsShotsData.data,
                                categoriesData.data,
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
        newsShotsList: List<NewsShots>?,
        categoriesList: List<Category>?,
    ): HomeDataModel {
        return HomeDataModel(
            status = DataStatus.Success,
            homeContent = HomeContent(
                headingText = "NewsShots Daily",
                subHeadingText = "Get daily news in 3 mins",
                categoryLabel = "Browse By Category",
                articlesLabel = "Latest articles",
            ),
            newsShotsList = newsShotsList.getValueOrEmpty(),
            categoriesList = categoriesList.getValueOrEmpty(),
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
