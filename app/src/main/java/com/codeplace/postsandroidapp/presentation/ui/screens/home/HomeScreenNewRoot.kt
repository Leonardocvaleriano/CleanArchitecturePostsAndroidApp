package com.codeplace.postsandroidapp.presentation.ui.screens.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.codeplace.postsandroidapp.presentation.ui.navigation.utils.BottomNavItems
import com.codeplace.postsandroidapp.presentation.ui.navigation.utils.ScreenRoutes


@Composable
fun HomeScreenNewRoot(
    navController: NavHostController
){

    val items = mutableListOf(
        BottomNavItems.Home,
        BottomNavItems.Favorites,
        BottomNavItems.Profile,
    )

    Scaffold(
        bottomBar = {
            BottomAppBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    NavigationBarItem(
                        icon = {
                            when(screen.route){
                                BottomNavItems.Home.route -> Icon(imageVector = Icons.Filled.Home, contentDescription = null)
                                BottomNavItems.Favorites.route -> Icon(imageVector = Icons.Filled.Home, contentDescription = null)
                                BottomNavItems.Profile.route -> Icon(imageVector = Icons.Filled.Home, contentDescription = null)
                            }

                        },
                        onClick = {
                            navController.navigate(screen.route)
                        },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route::class.qualifiedName } == true
                    )
                }
            }
        }
    ) { innerPadding ->

        HomeNavGraph(
            innerPadding = innerPadding
        )

    }


}

