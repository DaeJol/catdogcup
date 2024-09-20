package com.daejol.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.daejol.presentation.model.Graph
import com.daejol.presentation.ui.homeViewModel
import com.daejol.presentation.ui.worldCupViewModel

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier
) {
    val homeViewModel = homeViewModel()
    val worldCupViewModel = worldCupViewModel()

    val homeUiState by homeViewModel.uiState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = Graph.Home.route,
        modifier = modifier
    ) {
        homeNavGraph(navController, homeViewModel, worldCupViewModel, homeUiState)
        matchingNavGraph(navController)
        composable(route = Graph.Story.route) {
            // TODO: 스토리 화면
        }
        myPageNavGraph(navController)
    }
}
