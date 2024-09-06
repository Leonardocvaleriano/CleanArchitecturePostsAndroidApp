package com.codeplace.postsandroidapp.presentation.ui.navigation.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomNavigation(
    val label: String,
    val iconFilled: ImageVector,
    val iconOutlined: ImageVector,
    val route: ScreenRoutes,
) {
    EXPLORE(
        label = "Explore",
        iconFilled = Icons.Filled.Search,
        iconOutlined = Icons.Outlined.Search,
        route = ScreenRoutes.Home
    ),
    FAVORITES(
        "Favorites",
        iconFilled = Icons.Filled.Favorite,
        iconOutlined = Icons.Outlined.FavoriteBorder,
        ScreenRoutes.Favorites
    ),
    SETTINGS (
        "Settings",
        iconFilled = Icons.Filled.Settings,
        iconOutlined = Icons.Outlined.Settings,
        ScreenRoutes.Settings
    )

}