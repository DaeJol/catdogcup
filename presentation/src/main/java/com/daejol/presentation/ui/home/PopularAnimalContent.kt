package com.daejol.presentation.ui.home

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daejol.presentation.R
import com.daejol.presentation.data.SampleData
import com.daejol.presentation.model.Animal
import com.daejol.presentation.ui.theme.CatdogcupTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PopularAnimalContent(
    animals: List<Animal>,
    onClick: (Animal) -> Unit
) {
    Column(
        modifier = Modifier.padding(dimensionResource(id = R.dimen.space_m))
    ) {
        Title(text = stringResource(id = R.string.popular_animal_title))
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_m)))
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            maxItemsInEachRow = 2
        ) {
            val configuration = LocalConfiguration.current
            val screenWidth = configuration.screenWidthDp

            animals.forEachIndexed { i, animal ->
                PopularAnimalCard(
                    ranking = i + 1,
                    animal = animal,
                    width = (screenWidth / 2 - 22).dp,
                    onClick = onClick
                )
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
            PopularAnimalContent(
                animals = SampleData.animals,
                onClick = {}
            )
        }
    }
}
