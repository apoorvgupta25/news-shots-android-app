package com.apoorvgupta.capabilities.presentation.navigation.ui

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val displayBadge: Boolean,
    val navigationRoute: String,
    val position: Int,
    val title: String,
    val visible: Boolean,
    var badgeCount: Int,
    val icon: ImageVector,
    val filledIcon: ImageVector,
)
