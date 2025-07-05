package com.apoorvgupta.home.models

import com.apoorvgupta.capabilities.network.rest.data.categories.Category
import com.apoorvgupta.capabilities.network.rest.data.newsshots.NewsShots
import com.apoorvgupta.core.models.ErrorModel
import com.apoorvgupta.core.utils.DataStatus
import com.apoorvgupta.core.utils.emptyValue

/**
 * Data class representing data model required for Home Screen
 *
 * @property status The [DataStatus] representing the current status of the Search Landing screen data.
 * @property label
 * @constructor Create empty Home data model
 *
 * @author Apoorv Gupta
 */
data class HomeDataModel(
    val status: DataStatus = DataStatus.Empty,
    val errorModel: ErrorModel = ErrorModel(),
    val homeContent: HomeContent = HomeContent(),
    val newsShotsList: List<NewsShots> = emptyList(),
    val categoriesList: List<Category> = emptyList(),
)

data class HomeContent(
    val headingText: String = String.emptyValue(),
    val subHeadingText: String = String.emptyValue(),
    val categoryLabel: String = String.emptyValue(),
    val articlesLabel: String = String.emptyValue(),
)
