package com.daejol.presentation.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.daejol.presentation.R
import com.daejol.presentation.data.SampleData
import com.daejol.presentation.model.Animal
import com.daejol.presentation.ui.theme.CatdogcupTheme
import com.daejol.presentation.ui.theme.MoveSans
import com.daejol.presentation.ui.theme.secondaryLight
import com.daejol.presentation.ui.utils.sp

@Composable
fun PopularAnimalCard(
    ranking: Int,
    animal: Animal,
    width: Dp,
    onClick: (Animal) -> Unit
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.elevation_default)
        ),
//        colors = CardDefaults.cardColors(
//            containerColor = White100
//        ),
        onClick = { onClick(animal) },
        modifier = Modifier
            .wrapContentHeight()
            .width(width)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(animal.imageUrl)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(id = R.drawable.sample_cat),
                contentDescription = stringResource(R.string.popular_animal_image),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.popular_animal_image_height))
            )
            Column(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.space_xs))
            ) {
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_xxs)))
                Text(
                    text = "CAT NO.${ranking}",
                    fontSize = dimensionResource(id = R.dimen.text_xs).value.sp,
                    fontFamily = MoveSans,
                    fontWeight = FontWeight.Bold,
                    color = secondaryLight,
                    lineHeight = dimensionResource(id = R.dimen.text_xxs).value.sp
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_xxs)))
                Text(
                    text = animal.name,
                    fontSize = dimensionResource(id = R.dimen.text_m).value.sp,
                    fontFamily = MoveSans,
                    fontWeight = FontWeight.Bold,
                    lineHeight = dimensionResource(id = R.dimen.text_s).value.sp
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_xxs)))
                Text(
                    text = "고양이 귀여움 어쩌구 저쩌구...\napi temperament에 있는 설명..",
                    fontSize = dimensionResource(id = R.dimen.text_xs).value.sp,
                    fontFamily = MoveSans,
                    fontWeight = FontWeight.Bold,
                    lineHeight = dimensionResource(id = R.dimen.text_s).value.sp
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_xxs)))
                Row {
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.size(dimensionResource(id = R.dimen.popular_animal_card_icon_size))
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.BookmarkBorder,
                            contentDescription = stringResource(R.string.popular_animal_like)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PopularCatDogCardPreView() {
    CatdogcupTheme {
        PopularAnimalCard(
            ranking = 1,
            animal = SampleData.animals[0],
            width = 140.dp,
            onClick = {}
        )
    }
}
