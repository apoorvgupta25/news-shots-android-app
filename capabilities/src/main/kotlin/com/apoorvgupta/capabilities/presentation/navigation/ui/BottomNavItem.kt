package com.apoorvgupta.capabilities.presentation.navigation.ui

data class BottomNavItem(
    val displayBadge: Boolean,
    val navigationRoute: Any,
    val position: Int,
    val title: String,
    val visible: Boolean,
    var badgeCount: Int,
    val unselectedIcon: Int,
    val selectedIcon: Int,
)
