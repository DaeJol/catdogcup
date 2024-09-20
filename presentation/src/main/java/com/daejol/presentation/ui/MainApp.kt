package com.daejol.presentation.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.daejol.presentation.R
import com.daejol.presentation.model.Graph
import com.daejol.presentation.navigation.MainNavHost

@Composable
fun MainApp() {
    val items = listOf(
        Graph.Home,
        Graph.Matching,
        Graph.Story,
        Graph.MyPage,
    )
    val appState = rememberAppState()
    val navController = appState.navController

    Scaffold(
        bottomBar = {
            if (appState.shouldShowBottomBar) {
                NavigationBar {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    items.forEach { screen ->
                        NavigationBarItem(
                            icon = {
                                screen.icon?.let {
                                    Icon(
                                        screen.icon,
                                        contentDescription = null
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
        },
        modifier = Modifier
            .padding(
                top = dimensionResource(id = R.dimen.space_xxl),
                bottom = dimensionResource(id = R.dimen.space_xl)
            )
//            .systemBarsPadding()
//            .statusBarsPadding()
//            .navigationBarsPadding()

    ) { innerPadding ->
        MainNavHost(navController, Modifier.padding(innerPadding))
    }
}
