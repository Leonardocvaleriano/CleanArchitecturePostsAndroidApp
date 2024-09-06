package com.codeplace.postsandroidapp.presentation.ui.navigation


import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.codeplace.postsandroidapp.presentation.ui.navigation.utils.BottomNavigation
import com.codeplace.postsandroidapp.presentation.ui.navigation.utils.ScreenRoutes
import com.codeplace.postsandroidapp.presentation.ui.screens.comments.CommentsScreenRoot
import com.codeplace.postsandroidapp.presentation.ui.screens.explore.HomeScreenRoot
import com.codeplace.postsandroidapp.presentation.ui.screens.favorites.FavoritesScreenRoot
import com.codeplace.postsandroidapp.presentation.ui.screens.search.SearchScreenRoot
import com.codeplace.postsandroidapp.presentation.ui.screens.settings.SettingsScreenRoot
import com.codeplace.postsandroidapp.presentation.ui.screens.settings.theme.ThemeScreenRoot
import com.example.compose.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationRoot(

) {
    AppTheme(

    ) {
        Surface(color = MaterialTheme.colorScheme.surface) {

            val navController = rememberNavController()

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
                ?: BottomNavigation.EXPLORE.route::class.qualifiedName.orEmpty()
            val currentRouteTrimmed by remember(currentRoute) {
                derivedStateOf { currentRoute.substringBefore("?") }
            }

            Scaffold(
                contentWindowInsets = WindowInsets(0.dp),
                bottomBar = {
                    BottomAppBar(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
                        contentColor = MaterialTheme.colorScheme.secondaryContainer
                    ) {
                        BottomNavigation.entries
                            .forEachIndexed { index, bottomNavigationItem ->

                                val isSelected by remember(currentRoute) {
                                    derivedStateOf { currentRouteTrimmed == bottomNavigationItem.route::class.qualifiedName }
                                }
                                NavigationBarItem(

                                    selected = isSelected,
                                    label = {
                                        Text(
                                            text = bottomNavigationItem.label,
                                            style = MaterialTheme.typography.labelSmall,
                                            color = if (isSelected) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurfaceVariant,
                                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium

                                        )
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = if (isSelected) bottomNavigationItem.iconFilled else bottomNavigationItem.iconOutlined,
                                            contentDescription = bottomNavigationItem.label,
                                            tint = if (isSelected) MaterialTheme.colorScheme.onSecondaryContainer else MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    },
                                    onClick = {
                                        navController.navigate(bottomNavigationItem.route)
                                    }
                                )
                            }

                    }
                }) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = ScreenRoutes.HomeGraph,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        navigation<ScreenRoutes.HomeGraph>(
                            startDestination = ScreenRoutes.Home
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

                            composable<ScreenRoutes.Search> {
                                SearchScreenRoot()
                            }

                            composable<ScreenRoutes.Favorites> {
                                FavoritesScreenRoot()
                            }

                            composable<ScreenRoutes.Settings> {
                                SettingsScreenRoot(
                                    onThemeClick = {
                                        navController.navigate(ScreenRoutes.Theme)
                                    }
                                )
                            }
                            composable<ScreenRoutes.Theme> {
                                ThemeScreenRoot()
                            }

                        }
                    }
                }

            }


        }
    }

