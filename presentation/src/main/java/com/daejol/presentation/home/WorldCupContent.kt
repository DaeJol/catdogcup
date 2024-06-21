package com.daejol.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.daejol.presentation.R
import com.daejol.presentation.ui.theme.CatdogcupTheme

@Composable
fun WorldCupContent() {
    Column(
        modifier = Modifier.padding(dimensionResource(id = R.dimen.space_m))
    ) {
        Title(text = R.string.home_app_bar_title)
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_m)))
        WorldCupCard(
            R.string.cat_world_cup_title,
            R.string.cat_world_cup_desc,
            R.string.cat_world_cup_button,
            R.drawable.cat
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_m)))
        WorldCupCard(
            R.string.dog_world_cup_title,
            R.string.dog_world_cup_desc,
            R.string.dog_world_cup_button,
            R.drawable.dog
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_m)))
        WorldCupCard(
            R.string.mixed_world_cup_title,
            R.string.mixed_world_cup_desc,
            R.string.mixed_world_cup_button,
            R.drawable.catdog
        )
    }
}

@Preview
@Composable
fun WorldCupContentPreview() {
    CatdogcupTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            WorldCupContent()
        }
    }
}
