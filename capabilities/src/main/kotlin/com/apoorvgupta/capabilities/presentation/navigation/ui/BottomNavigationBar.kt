/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.capabilities.presentation.navigation.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.apoorvgupta.capabilities.presentation.navigation.Destinations
import com.apoorvgupta.capabilities.presentation.theme.StrokeWidthSmall
import com.apoorvgupta.capabilities.presentation.theme.couple_internal_spacing
import com.apoorvgupta.capabilities.presentation.theme.md_theme_light_primary
import com.apoorvgupta.capabilities.presentation.theme.monuple_internal_spacing
import com.apoorvgupta.capabilities.presentation.theme.monuple_large_internal_spacing
import com.apoorvgupta.capabilities.presentation.theme.triple_internal_spacingg
import com.apoorvgupta.core.logger.AppLogger
import com.apoorvgupta.core.utils.EMPTY_STRING
import kotlin.math.roundToInt

/**
 * Composable function representing the Bottom Navigation Bar in the app.
 *
 * This Bottom Navigation Bar provides navigation between Home, Profile, and Settings screens.
 *
 * @param navController The NavController used for navigation within the app.
 *
 * @author Apoorv Gupta
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(
    navController: NavController,
    bottomBarHeight: Dp,
    bottomBarOffsetHeightPx: MutableState<Float>,
) {
    // State variables to track the selected item and current route.
    var currentRoute by remember { mutableStateOf(Destinations.HomeDestination.route) }

    val route = navController.currentBackStackEntryAsState().value?.destination?.route
    AppLogger.d { "CURRENT_STACK: $route $currentRoute" }

    if (route != null) {
        currentRoute = route
    }

    val items = listOf(
        BottomNavItem(
            displayBadge = false,
            navigationRoute = Destinations.HOME_ROUTE,
            position = 0,
            title = "Home",
            visible = true,
            badgeCount = 0,
            icon = Icons.Outlined.Home,
            filledIcon = Icons.Filled.Home,
        ),
        BottomNavItem(
            displayBadge = false,
            navigationRoute = Destinations.HOME_ROUTE,
            position = 1,
            title = "Home",
            visible = true,
            badgeCount = 0,
            icon = Icons.Outlined.Home,
            filledIcon = Icons.Filled.Home,
        ),
        BottomNavItem(
            displayBadge = false,
            navigationRoute = Destinations.HOME_ROUTE,
            position = 2,
            title = "Home",
            visible = true,
            badgeCount = 0,
            icon = Icons.Outlined.Home,
            filledIcon = Icons.Filled.Home,
        ),

        )

    // Testing CI
    // Build the Bottom Navigation Bar using Jetpack Compose.
    NavigationBar(
        containerColor = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .height(bottomBarHeight)
            .offset {
                IntOffset(
                    x = 0,
                    y = -bottomBarOffsetHeightPx.value.roundToInt(),
                )
            }
            .shadow(elevation = monuple_internal_spacing, spotColor = Color(0x26000000)),
    ) {
        items.forEach { item ->

            NavigationBarItem(
                alwaysShowLabel = true,
                icon = {
                    Icon(
                        imageVector = if (currentRoute == item.navigationRoute) item.filledIcon else item.icon,
                        contentDescription = EMPTY_STRING,
                        modifier = Modifier.size(triple_internal_spacingg),
                    )
                    if (item.displayBadge) {
                        BadgedBox(
                            modifier = Modifier
                                .padding(
                                    top = monuple_large_internal_spacing,
                                    start = couple_internal_spacing,
                                    end = monuple_large_internal_spacing,
                                    bottom = monuple_large_internal_spacing,
                                ),
                            badge = {
                                Badge(
                                    containerColor = if (currentRoute == item.navigationRoute) md_theme_light_primary else Color.Black,
                                    contentColor = Color.White,
                                    modifier = Modifier.border(width = StrokeWidthSmall, shape = CircleShape, color = Color.White),
                                ) {
                                    Text(text = item.badgeCount.toString())
                                }
                            },
                        ) {
                        }
                    }
                },
                label = {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.bodySmall,
                    )
                },
                selected = currentRoute == item.navigationRoute,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = md_theme_light_primary,
                    unselectedIconColor = Color.Black,
                    selectedTextColor = md_theme_light_primary,
                    unselectedTextColor = Color.Black,
                    indicatorColor = Color.White,
                ),
                onClick = {
                },
            )
        }
    }
}
