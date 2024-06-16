package com.daejol.presentation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int,
    val icon : ImageVector
) {
    // TODO: 아이콘 수정
    data object Home : Screen("home", R.string.home, Icons.Filled.Home)

    data object Category : Screen("category", R.string.category, Icons.Filled.Menu)

    data object Bookmark : Screen("bookmark", R.string.bookmark, Icons.Filled.Star)

    data object MyPage : Screen("my_page", R.string.my_page, Icons.Filled.Person)
}
