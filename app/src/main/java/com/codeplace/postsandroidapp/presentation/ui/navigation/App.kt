package com.codeplace.postsandroidapp.presentation.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.codeplace.postsandroidapp.presentation.ui.navigation.utils.BottomNavigation
import com.codeplace.postsandroidapp.presentation.ui.navigation.utils.ScreenRoutes
import com.codeplace.postsandroidapp.presentation.ui.screens.comments.CommentsScreenRoot
import com.codeplace.postsandroidapp.presentation.ui.screens.favorites.FavoritesScreenRoot
import com.codeplace.postsandroidapp.presentation.ui.screens.home.HomeScreenRoot
import com.codeplace.postsandroidapp.presentation.ui.screens.profile.ProfileScreenRoot
import com.example.compose.AppTheme

@Composable
fun App() {
    AppTheme {
        Surface(color = MaterialTheme.colorScheme.surface) {

            val navController = rememberNavController()

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
                ?: BottomNavigation.HOME.route::class.qualifiedName.orEmpty()

            val currentRouteTrimmed by remember(currentRoute) {
                derivedStateOf { currentRoute.substringBefore("?") }
            }

            Scaffold(
                bottomBar = {
                    BottomAppBar {
                        BottomNavigation.entries
                            .forEachIndexed { index, bottomNavigationItem ->

                                val isSelected by remember(currentRoute) {
                                    derivedStateOf { currentRouteTrimmed == bottomNavigationItem.route::class.qualifiedName }
                                }

                                NavigationBarItem(
                                    selected = isSelected,
                                    label = { Text(bottomNavigationItem.label) },
                                    icon = {
                                        Icon(
                                            imageVector = bottomNavigationItem.icon,
                                            contentDescription = bottomNavigationItem.label
                                        )
                                    },
                                    onClick = {
                                        navController.navigate(bottomNavigationItem.route)
                                    }
                                )
                    }
                }}){
                paddingValues ->

                NavHost(navController = navController, startDestination = ScreenRoutes.HomeGraph, Modifier.padding(paddingValues)){
                    navigation<ScreenRoutes.HomeGraph>(
                        startDestination = ScreenRoutes.Home
                    ){
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

                        composable<ScreenRoutes.Favorites> {
                            FavoritesScreenRoot()
                        }

                        composable<ScreenRoutes.Profile> {
                            ProfileScreenRoot()

                        }


                    }
                }
            }


        }
    }

}
