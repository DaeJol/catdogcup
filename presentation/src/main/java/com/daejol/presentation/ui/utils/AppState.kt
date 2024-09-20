package com.daejol.presentation.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.daejol.presentation.model.Screen
import com.daejol.presentation.ui.theme.Black100
import com.daejol.presentation.ui.theme.White100
import okhttp3.Route

@Stable
class AppState(
    val navController: NavHostController
) {
    private val disableBottomBarScreenList = listOf(
        Screen.WorldCupSelection.route,
        Screen.WorldCupPlay.route,
        Screen.WorldCupResult.route,
        Screen.MatchingQuestion.route,
        Screen.MatchingLoading.route,
        Screen.MatchingResult.route,
    )

    private val customColorList = mapOf(
        Screen.Story.route to Black100,
    )

    private val customIconColorList = mapOf(
        Screen.Story.route to White100,
    )

    private val customSystemBarColorList = mapOf(
        Screen.Story.route to Black100,
    )

    @Composable
    fun setBottomNavigationBarCustomColor(): Color? {
        val current = navController
            .currentBackStackEntryAsState().value?.destination?.route

        return customColorList[current]
    }

    @Composable
    fun setBottomNavigationBarIconCustomColor(): Color? {
        val current = navController
            .currentBackStackEntryAsState().value?.destination?.route

        return customIconColorList[current]
    }

    @Composable
    fun setSystemBarCustomColor(): Color? {
        val current = navController
            .currentBackStackEntryAsState().value?.destination?.route

        return customSystemBarColorList[current]
    }

    val shouldShowBottomBar: Boolean
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination?.route !in disableBottomBarScreenList


    val useSystemBarCustomColor: Boolean
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination?.route in customSystemBarColorList.keys

    val currentRoute: String?
        get() = navController.currentDestination?.route

    fun upPress() {
        navController.navigateUp()
    }

    fun navigateToBottomBarRoute(route: String) {
        if (route != currentRoute) {
            navController.navigate(route) {
                launchSingleTop = true
                restoreState = true
                popUpTo(findStartDestination(navController.graph).id) {
                    saveState = true
                }
            }
        }
    }
}

private fun NavBackStackEntry.lifecycleIsResumed() =
    this.lifecycle.currentState == Lifecycle.State.RESUMED

private val NavGraph.startDestination: NavDestination?
    get() = findNode(startDestinationId)

private tailrec fun findStartDestination(graph: NavDestination): NavDestination {
    return if (graph is NavGraph) findStartDestination(graph.startDestination!!) else graph
}
