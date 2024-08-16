package com.codeplace.postsandroidapp.presentation.ui.screens.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.codeplace.postsandroidapp.presentation.ui.navigation.utils.ScreenRoutes
import com.codeplace.postsandroidapp.presentation.ui.screens.comments.CommentsScreenRoot

@Composable
fun HomeNavGraph(
    innerPadding: PaddingValues,
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.Home,
        Modifier.padding(innerPadding)
    ) {
        composable<ScreenRoutes.Home> {
            HomeScreenRoot(
                onCardClick = { id ->
                    navController.navigate(ScreenRoutes.Comments(id))
                }
            )
        }
        composable<ScreenRoutes.Comments> { backStackEntry ->
            val commentsRoute: ScreenRoutes.Comments = backStackEntry.toRoute()
            CommentsScreenRoot(
                id = commentsRoute.id
            )
        }
    }

}
