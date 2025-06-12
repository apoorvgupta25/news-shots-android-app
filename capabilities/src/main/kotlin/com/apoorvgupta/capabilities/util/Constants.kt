/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.capabilities.util

/**
 * Object containing constants used in the application.
 *
 * @author Apoorv Gupta
 */
object Constants {
    // Constant for named arguments in Hilt to avoid the conflict with different provider.

    const val IMAGE_BASE_URL = "https://news-shots-backend.onrender.com/api/daily/photo/"
    const val POST_PER_PAGE = 8
    const val DAILY = "Daily"
    const val DAILY_POST_LIMIT = 3
    const val DAILY_POST_SORT_BY_CREATED = "createdAt"
}
