package com.apoorvgupta.home.models

import com.apoorvgupta.core.models.ErrorResponseModel
import com.apoorvgupta.core.utils.DataStatus

/**
 * @author Apoorv Gupta
 */
data class FinanceDataResult(
    var status: DataStatus = DataStatus.Empty,
    var successResponseModel: FinanceDataResponse = FinanceDataResponse(),
    var errorResponseModel: ErrorResponseModel = ErrorResponseModel.emptyValue,
) {
    companion object {
        val emptyValue = FinanceDataResult()
    }
}
