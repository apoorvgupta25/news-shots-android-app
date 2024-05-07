package com.apoorvgupta.home.models.refreshdata

import com.apoorvgupta.core.utils.DataStatus
import com.apoorvgupta.core.utils.EMPTY_STRING

/**
 * @author Apoorv Gupta
 */

/**
 * Data class representing the response of a login operation.
 *
 * @param status The status of the login operation, indicating whether it's empty, successful, or in error.
 * @param successResponseModel The model containing data for a successful login response.
 * @param errorResponseModel The model containing data for an error response in the login operation.
 *
 * @author Apoorv Gupta
 */
data class RefreshDataResult(
    var status: DataStatus = DataStatus.Empty,
    var successResponseModel: RefreshDataResponse = RefreshDataResponse(),
    var errorResponseModel: ErrorRefreshDataResponseModel = ErrorRefreshDataResponseModel.emptyValue,
) {
    companion object {
        val emptyValue = RefreshDataResult()
    }
}

data class ErrorRefreshDataResponseModel(
    val title: String = EMPTY_STRING,
    val message: String = EMPTY_STRING,
) {
    companion object {
        val emptyValue = ErrorRefreshDataResponseModel()
    }
}
