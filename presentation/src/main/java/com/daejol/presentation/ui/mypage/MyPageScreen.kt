package com.daejol.presentation.ui.mypage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.daejol.presentation.R
import com.daejol.presentation.data.SampleData
import com.daejol.presentation.ui.theme.CatdogcupTheme

@Composable
fun MyPageScreen(
    modifier: Modifier = Modifier,
    navController: NavController?
) {
    val animals = SampleData.animals

    CatdogcupTheme {
        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
                .padding(vertical = dimensionResource(id = R.dimen.space_xl))
        ) {
            MyAnimalContent(animal = animals[0])
            Spacer(modifier = modifier.height(dimensionResource(id = R.dimen.space_xxl)))
            BookmarkContent(
                navController = navController,
                animals = animals.subList(0, 10)
            )
            Spacer(modifier = modifier.height(dimensionResource(id = R.dimen.space_xxl)))
            AchievementContent(animals = animals)
            Spacer(modifier = modifier.height(dimensionResource(id = R.dimen.space_xxl)))
            EtcContent()
            Spacer(modifier = modifier.height(dimensionResource(id = R.dimen.space_xl)))
        }
    }
}

@Preview
@Composable
fun MyPageScreenPreview() {
    CatdogcupTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            MyPageScreen(
                modifier = Modifier.background(color = MaterialTheme.colorScheme.background),
                navController = null
            )
        }
    }
}
