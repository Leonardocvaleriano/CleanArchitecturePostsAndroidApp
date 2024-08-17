package com.codeplace.postsandroidapp.presentation.ui.navigation.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

@Serializable
sealed class ScreenRoutes() {

    @Serializable
    data object HomeGraph : ScreenRoutes()

    @Serializable
    data object Home : ScreenRoutes()

    @Serializable
    data class Comments(val id: Int) : ScreenRoutes()

    @Serializable
    data object Search : ScreenRoutes()

    @Serializable
    data object Favorites : ScreenRoutes()

    @Serializable
    data object Settings : ScreenRoutes()


}

