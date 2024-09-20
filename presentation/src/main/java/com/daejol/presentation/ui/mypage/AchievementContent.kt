package com.daejol.presentation.ui.mypage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.daejol.presentation.R
import com.daejol.presentation.data.SampleData
import com.daejol.presentation.model.Animal
import com.daejol.presentation.ui.home.Title
import com.daejol.presentation.ui.theme.CatdogcupTheme
import com.daejol.presentation.ui.theme.Typography

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AchievementContent(
    modifier: Modifier = Modifier,
    animals: List<Animal>
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(id = R.dimen.space_l))
    ) {
        Title(text = stringResource(id = R.string.my_page_title_achievement))
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_m)))
        FlowRow(
            maxItemsInEachRow = 3,
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.space_s), Alignment.CenterVertically),
            modifier = Modifier.fillMaxWidth()
        ) {
            animals.forEach {
                AchievementItem(animal = it)
            }
        }
    }
}

@Composable
fun AchievementItem(
    modifier: Modifier = Modifier,
    imageSize: Dp = dimensionResource(id = R.dimen.achievement_image_size),
    animal: Animal
) {
    Column(
        modifier = modifier
            .width(IntrinsicSize.Min)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(animal.imageUrl)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.sample_cat),
            contentDescription = stringResource(id = R.string.my_page_achievement_image),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(imageSize)
                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.achievement_image_rounded_corner_shape_size)))
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = animal.name,
            textAlign = TextAlign.Center,
            style = Typography.labelSmall,
            maxLines = 2,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun AchievementContentPreview() {
    CatdogcupTheme {
        AchievementContent(
            modifier = Modifier.background(color = MaterialTheme.colorScheme.background),
            animals = SampleData.animals
        )
    }
}
