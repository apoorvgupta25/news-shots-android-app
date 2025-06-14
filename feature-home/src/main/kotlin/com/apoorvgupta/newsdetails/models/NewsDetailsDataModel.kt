package com.apoorvgupta.newsdetails.models

import com.apoorvgupta.capabilities.network.rest.data.newsshots.NewsShots
import com.apoorvgupta.core.models.ErrorModel
import com.apoorvgupta.core.utils.DataStatus
import com.apoorvgupta.core.utils.EMPTY_STRING

/**
 * @author Apoorv Gupta
 */
data class NewsDetailsDataModel(
    val status: DataStatus = DataStatus.Empty,
    val errorModel: ErrorModel = ErrorModel(),
    val newsShotDetailsContent: NewsDetailsContent = NewsDetailsContent(),
    val newsShot: NewsShots = NewsShots.emptyValue,
)

data class NewsDetailsContent(
    val headingText: String = EMPTY_STRING,
    val subHeadingText: String = EMPTY_STRING,
    val categoryLabel: String = EMPTY_STRING,
    val articlesLabel: String = EMPTY_STRING,
)
