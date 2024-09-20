package com.daejol.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.daejol.presentation.model.Graph
import com.daejol.presentation.model.HomeUiState
import com.daejol.presentation.model.Screen
import com.daejol.presentation.ui.home.HomeScreen
import com.daejol.presentation.ui.home.HomeViewModel
import com.daejol.presentation.ui.home.PopularAnimalDetailScreen
import com.daejol.presentation.ui.worldcup.WorldCupViewModel
import com.daejol.presentation.ui.worldcup.play.WorldCupPlayScreen
import com.daejol.presentation.ui.worldcup.result.WorldCupResultScreen
import com.daejol.presentation.ui.worldcup.selection.WorldCupScreen

fun NavGraphBuilder.homeNavGraph(
    navController: NavController,
    homeViewModel: HomeViewModel,
    worldCupViewModel: WorldCupViewModel,
    homeUiState: HomeUiState
) {
    navigation(startDestination = Screen.Home.route, route = Graph.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                navController = navController,
                onDetailButtonClicked = {
                    homeViewModel.setBreed(it)
                    navController.navigate(Screen.AnimalDetail.route)
                }
            )
        }
        composable(route = Screen.WorldCupSelection.route) {
            WorldCupScreen(
                viewModel = worldCupViewModel,
                type = "CAT",
                navController = navController
            )
        }
        composable(route = Screen.WorldCupPlay.route) {
            WorldCupPlayScreen(
                viewModel = worldCupViewModel,
                navController = navController
            )
        }
        composable(route = Screen.WorldCupResult.route) {
            WorldCupResultScreen(
                viewModel = worldCupViewModel,
                navController = navController
            )
        }
        composable(route = Screen.AnimalDetail.route) {
            PopularAnimalDetailScreen(
                navController = navController,
                homeUiState = homeUiState
            )
        }
    }
}
