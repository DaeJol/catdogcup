package com.daejol.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.daejol.presentation.ui.home.HomeViewModel
import com.daejol.presentation.ui.story.StoryViewModel
import com.daejol.presentation.ui.utils.AppState
import com.daejol.presentation.ui.worldcup.WorldCupViewModel

@Composable
fun homeViewModel(): HomeViewModel = hiltViewModel()

@Composable
fun worldCupViewModel(): WorldCupViewModel = hiltViewModel()

@Composable
fun storyViewModel(): StoryViewModel = hiltViewModel()

@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController()
) = remember(navController) { AppState(navController) }
