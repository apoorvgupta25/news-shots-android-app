package com.apoorvgupta.home.models

import com.apoorvgupta.core.utils.DataStatus
import com.apoorvgupta.core.utils.EMPTY_STRING

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
    val homeContent: HomeContent = HomeContent(),
    val label: String = EMPTY_STRING,
    val currency: String = EMPTY_STRING,
    val showBottomSheet: Boolean = false,
    val isNotificationVisible: Boolean = false,
    val isBannerLoading: Boolean = true,
)

data class HomeContent(
    val sendText: String = EMPTY_STRING,
    val errorText: String = EMPTY_STRING,
)
