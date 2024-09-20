package com.daejol.presentation.ui.mypage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.daejol.presentation.R
import com.daejol.presentation.data.SampleData
import com.daejol.presentation.model.Animal
import com.daejol.presentation.ui.home.Title
import com.daejol.presentation.ui.theme.CatdogcupTheme
import com.daejol.presentation.ui.theme.Typography

@Composable
fun MyAnimalContent(
    modifier: Modifier = Modifier,
    animal: Animal
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(id = R.dimen.space_l))
    ) {
        Title(text = stringResource(id = R.string.my_page_main_achievement))
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_m)))
        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            AchievementItem(
                imageSize = dimensionResource(id = R.dimen.my_animal_image_size),
                animal = animal
            )
        }
    }
}

@Preview
@Composable
fun ProfileContentPreview() {
    CatdogcupTheme {
        MyAnimalContent(
            modifier = Modifier.background(color = MaterialTheme.colorScheme.background),
            animal = SampleData.animals[0]
        )
    }
}
