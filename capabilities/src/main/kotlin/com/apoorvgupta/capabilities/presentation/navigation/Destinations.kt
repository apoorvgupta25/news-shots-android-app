/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.capabilities.presentation.navigation

import kotlinx.serialization.Serializable

/**
 * Sealed class representing different destinations in the app.
 *
 * @author Apoorv Gupta
 */
// Splash Destination
@Serializable
object Splash

// Home Destination
@Serializable
object Home

// NewsShotsListing Destination
@Serializable
data class NewsShotsListing(
    val categoryName: String,
)

// Search Destination
@Serializable
object Search

// Bookmark Destination
@Serializable
object Bookmark
