package com.daejol.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.daejol.presentation.model.Graph
import com.daejol.presentation.model.Screen
import com.daejol.presentation.ui.bookmark.BookmarkScreen
import com.daejol.presentation.ui.mypage.MyPageScreen

fun NavGraphBuilder.myPageNavGraph(
    navController: NavController
) {
    navigation(startDestination = Screen.MyPage.route, route = Graph.MyPage.route) {
        composable(route = Screen.MyPage.route) {
            MyPageScreen(navController = navController)
        }
        composable(route = Screen.Bookmark.route) {
            BookmarkScreen()
        }
    }
}
