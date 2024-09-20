package com.daejol.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.daejol.presentation.model.Graph
import com.daejol.presentation.model.Screen
import com.daejol.presentation.ui.match.MatchLoadingScreen
import com.daejol.presentation.ui.match.MatchQuestionScreen
import com.daejol.presentation.ui.match.MatchResultScreen
import com.daejol.presentation.ui.match.MatchStartScreen

fun NavGraphBuilder.matchingNavGraph(
    navController: NavController
) {
    navigation(startDestination = Screen.Matching.route, route = Graph.Matching.route) {
        composable(route = Screen.Matching.route) {
            MatchStartScreen(
                navController = navController
            )
        }
        composable(route = Screen.MatchingQuestion.route) {
            MatchQuestionScreen(
                navController = navController
            )
        }
        composable(route = Screen.MatchingLoading.route) {
            MatchLoadingScreen(
                navController = navController
            )
        }
        composable(route = Screen.MatchingResult.route) {
            MatchResultScreen(
                navController = navController
            )
        }
    }
}
