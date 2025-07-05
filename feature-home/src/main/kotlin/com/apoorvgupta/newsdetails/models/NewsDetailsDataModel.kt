package com.apoorvgupta.newsdetails.models

import com.apoorvgupta.capabilities.network.rest.data.newsshots.NewsShots
import com.apoorvgupta.core.models.ErrorModel
import com.apoorvgupta.core.utils.DataStatus

/**
 * @author Apoorv Gupta
 */
data class NewsDetailsDataModel(
    val status: DataStatus = DataStatus.Empty,
    val errorModel: ErrorModel = ErrorModel(),
    val newsShot: NewsShots = NewsShots.emptyValue,
)
