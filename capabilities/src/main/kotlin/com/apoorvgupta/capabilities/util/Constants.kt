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
    const val NETWORK_NAMED_ARGUMENTS = "network_args"
    const val ENABLE_APP_CACHE = "enableAppCache"

    const val POST_PER_PAGE = 8
    const val DAILY = "daily"
}
