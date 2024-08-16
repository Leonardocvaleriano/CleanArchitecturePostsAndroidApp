package com.codeplace.postsandroidapp.presentation.ui.navigation.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

@Serializable
sealed class ScreenRoutes(){

    @Serializable
    data object HomeGraph : ScreenRoutes()

    @Serializable
    data object Home : ScreenRoutes()

    @Serializable
    data class Comments(val id: Int): ScreenRoutes()

    @Serializable
    data object Favorites : ScreenRoutes()

    @Serializable
    data object Profile : ScreenRoutes()
}

enum class BottomNavigation(val label: String, val icon: ImageVector, val route: ScreenRoutes) {
    HOME("Home", Icons.Outlined.Home, ScreenRoutes.Home),
    SEARCH("Favorite", Icons.Outlined.Favorite, ScreenRoutes.Favorites),
    PROFILE("Profile", Icons.Outlined.Person, ScreenRoutes.Profile);
}