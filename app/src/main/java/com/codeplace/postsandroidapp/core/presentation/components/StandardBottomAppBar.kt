package com.codeplace.postsandroidapp.core.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.codeplace.postsandroidapp.core.presentation.util.BottomNavigation

@Composable
fun StandardBottomAppBar(
    isBottomAppBarVisible: Boolean,
    navController: NavController
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
        ?: BottomNavigation.EXPLORE.route::class.qualifiedName.orEmpty()
    val currentRouteTrimmed by remember(currentRoute) {
        derivedStateOf { currentRoute.substringBefore("?") }
    }

    AnimatedVisibility(
        visible = isBottomAppBarVisible,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
    ){
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
                                text = stringResource(bottomNavigationItem.label),
                                style = MaterialTheme.typography.labelSmall,
                                color = if (isSelected) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurfaceVariant,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium

                            )
                        },
                        icon = {
                            Icon(
                                imageVector = if (isSelected) bottomNavigationItem.iconFilled else bottomNavigationItem.iconOutlined,
                                contentDescription = bottomNavigationItem.label.toString(),
                                tint = if (isSelected) MaterialTheme.colorScheme.onSecondaryContainer else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        },
                        onClick = {
                            navController.navigate(bottomNavigationItem.route)
                        }
                    )
                }
        }
    }




        }



@Preview
@Composable
fun StandardBottomAppBarPreview() {
    StandardBottomAppBar(
        isBottomAppBarVisible = true,
        navController = NavController(LocalContext.current)
    )
}