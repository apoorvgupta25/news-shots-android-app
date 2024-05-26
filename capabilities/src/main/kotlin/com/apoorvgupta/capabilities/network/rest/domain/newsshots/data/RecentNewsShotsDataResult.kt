package com.apoorvgupta.capabilities.network.rest.domain.newsshots.data

import com.apoorvgupta.capabilities.network.rest.data.model.NewsShots
import com.apoorvgupta.core.utils.DataStatus
import com.apoorvgupta.core.utils.EMPTY_STRING

/**
 * Data class representing the response of a login operation.
 *
 * @param status The status of the login operation, indicating whether it's empty, successful, or in error.
 * @param successResponseModel The model containing data for a successful login response.
 * @param errorResponseModel The model containing data for an error response in the login operation.
 *
 * @author Apoorv Gupta
 */
data class RecentNewsShotsDataResult(
    var status: DataStatus = DataStatus.Empty,
    var successResponseModel: List<NewsShots> = emptyList(),
    var errorResponseModel: ErrorRecentNewsShotsDataResponseModel = ErrorRecentNewsShotsDataResponseModel.emptyValue,
) {
    companion object {
        val emptyValue = RecentNewsShotsDataResult()
    }
}

data class ErrorRecentNewsShotsDataResponseModel(
    val title: String = EMPTY_STRING,
    val message: String = EMPTY_STRING,
) {
    companion object {
        val emptyValue = ErrorRecentNewsShotsDataResponseModel()
    }
}