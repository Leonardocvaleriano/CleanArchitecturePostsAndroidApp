package com.codeplace.postsandroidapp.presentation.ui.navigation.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

@Serializable
sealed class BottomNavItems(
    val title: String,
    val route: String
){
    @Serializable
    object Home: BottomNavItems(title = "Home", "Home")
    @Serializable
    object Favorites: BottomNavItems(title = "Favorites", "Favorites")
    @Serializable
    object Profile: BottomNavItems(title = "Profile", "Profile")

}