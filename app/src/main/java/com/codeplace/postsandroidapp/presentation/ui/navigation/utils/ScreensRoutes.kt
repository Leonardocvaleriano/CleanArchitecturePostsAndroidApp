package com.codeplace.postsandroidapp.presentation.ui.navigation.utils

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

    @Serializable
    data object Theme: ScreenRoutes()


}

