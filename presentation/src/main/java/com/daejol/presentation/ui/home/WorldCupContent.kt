package com.daejol.presentation.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.daejol.domain.usecase.WorldCupType
import com.daejol.presentation.R
import com.daejol.presentation.model.Screen
import com.daejol.presentation.ui.theme.CatdogcupTheme
import com.daejol.presentation.ui.worldCupViewModel

@Composable
fun WorldCupContent(
    navController: NavController? = null
) {
    val worldCupViewModel = worldCupViewModel()

    Column(
        modifier = Modifier.padding(dimensionResource(id = R.dimen.space_m))
    ) {
        Title(text = stringResource(id = R.string.world_cup_title))
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_m)))
        WorldCupCard(
            R.string.cat_world_cup_title,
            R.string.cat_world_cup_desc,
            R.string.cat_world_cup_button,
            R.drawable.cat,
            onClick = {
                worldCupViewModel.setType(WorldCupType.CAT)
                navController?.navigate(Screen.WorldCupSelection.route)
            }
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_m)))
        WorldCupCard(
            R.string.dog_world_cup_title,
            R.string.dog_world_cup_desc,
            R.string.dog_world_cup_button,
            R.drawable.dog,
            onClick = {
                worldCupViewModel.setType(WorldCupType.DOG)
                navController?.navigate(Screen.WorldCupSelection.route)
            }
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_m)))
        WorldCupCard(
            R.string.mixed_world_cup_title,
            R.string.mixed_world_cup_desc,
            R.string.mixed_world_cup_button,
            R.drawable.catdog,
            onClick = {
                worldCupViewModel.setType(WorldCupType.COMBINED)
                navController?.navigate(Screen.WorldCupSelection.route)
            }
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
