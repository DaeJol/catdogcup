package com.daejol.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daejol.presentation.R
import com.daejol.presentation.ui.theme.CatdogcupTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PopularCatDogContent(
    catdogs: List<Catdog> = listOf(
        Catdog("Russian Blue", 1),
        Catdog("Keykat", 2),
        Catdog("Snow Cat", 3),
        Catdog("Grasskitty", 4)
    )
) {
    Column(
        modifier = Modifier.padding(dimensionResource(id = R.dimen.space_m))
    ) {
        Title(text = R.string.popular_catdog_title)
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_m)))
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            maxItemsInEachRow = 2
        ) {
            val configuration = LocalConfiguration.current
            val screenWidth = configuration.screenWidthDp

            catdogs.forEach {
                PopularCatDogCard(it, (screenWidth / 2 - 22).dp)
            }
        }
    }
}

@Preview
@Composable
fun PopularCatDogContentPreview() {
    CatdogcupTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            PopularCatDogContent()
        }
    }
}

data class Catdog(
    val name: String,
    val ranking: Int
)
