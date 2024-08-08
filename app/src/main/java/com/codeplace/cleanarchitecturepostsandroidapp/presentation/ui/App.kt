package com.codeplace.cleanarchitecturepostsandroidapp.presentation.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.codeplace.cleanarchitecturepostsandroidapp.presentation.ui.screens.comments.CommentsScreenRoot
import com.codeplace.cleanarchitecturepostsandroidapp.presentation.ui.screens.home.HomeScreenRoot

@Composable
fun App() {

    val navController = rememberNavController()
    NavHost(navController, startDestination = HomeRoute) {
        composable<HomeRoute> {
            HomeScreenRoot (
                onCardClick = { id ->
                    navController.navigate(CommentsRoute(id))
                }
            )
        }
        composable<CommentsRoute> { backStackEntry ->
            val commentsRoute: CommentsRoute = backStackEntry.toRoute()
            CommentsScreenRoot(
               id = commentsRoute.id
            )
        }
    }

}