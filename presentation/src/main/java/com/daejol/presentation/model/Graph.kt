package com.daejol.presentation.model

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Extension
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.ui.graphics.vector.ImageVector
import com.daejol.presentation.R

sealed class Graph(
    val route: String,
    @StringRes val resourceId: Int,
    val icon : ImageVector
) {
    data object Home : Graph("graph_home", R.string.home, Icons.Filled.Home)

    data object Matching : Graph("graph_matching", R.string.matching, Icons.Filled.Extension)

    data object Story : Graph("graph_story", R.string.story, Icons.Filled.PhotoLibrary)

    data object MyPage : Graph("graph_my_page", R.string.my_page, Icons.Filled.Person)
}
