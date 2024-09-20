package com.daejol.presentation.ui

import android.app.Activity
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.stringResource
import androidx.core.view.ViewCompat
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.daejol.presentation.model.Screen

@Composable
fun MainApp() {
    val items = listOf(
        Screen.Home,
        Screen.Matching,
        Screen.Story,
        Screen.MyPage,
    )
    val appState = rememberAppState()
    val navController = appState.navController

    val barColor = if (appState.useSystemBarCustomColor) {
        appState.setSystemBarCustomColor()?.toArgb()
    } else {
        null
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            if (barColor != null) {
                (view.context as Activity).window.statusBarColor = barColor
            }
        }
    }

    Scaffold(
        bottomBar = {
            if (appState.shouldShowBottomBar) {
                NavigationBar(
                    containerColor = appState.setBottomNavigationBarCustomColor()
                        ?: MaterialTheme.colorScheme.primary,
                ) {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    items.forEach { screen ->
                        NavigationBarItem(
                            icon = {
                                screen.icon?.let {
                                    Icon(
                                        screen.icon,
                                        contentDescription = null,
                                        tint = appState.setBottomNavigationBarIconCustomColor()
                                            ?:  LocalContentColor.current


                                    )
                                }
                            },
                            label = { Text(stringResource(screen.resourceId)) },
                            selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                            onClick = {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        MainNavHost(navController, Modifier.padding(innerPadding))
    }
}
