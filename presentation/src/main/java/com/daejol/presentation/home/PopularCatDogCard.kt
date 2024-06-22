package com.daejol.presentation.home

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
import androidx.compose.material.icons.filled.FavoriteBorder
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
import com.daejol.presentation.ui.theme.CatdogcupTheme
import com.daejol.presentation.ui.theme.MoveSans
import com.daejol.presentation.ui.theme.White100
import com.daejol.presentation.ui.theme.secondaryLight

@Composable
fun PopularCatDogCard(
    catdog: Catdog = Catdog("Russian Blue", 1),
    width: Dp = 140.dp
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.elevation_default)
        ),
        colors = CardDefaults.cardColors(
            containerColor = White100
        ),
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
                    .data("https://cdn2.thecatapi.com/images/cqg.jpg")
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(id = R.drawable.sample_cat),
                contentDescription = stringResource(R.string.popular_catdog_image),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.popular_catdog_image_height))
            )
            Column(
                modifier = Modifier
                    .padding(
                        horizontal = dimensionResource(id = R.dimen.space_xs),
                        vertical = dimensionResource(id = R.dimen.space_xxs)
                    )
            ) {
                Text(
                    text = "CAT NO.${catdog.ranking}",
                    fontSize = dimensionResource(id = R.dimen.text_xxxs).value.sp,
                    fontFamily = MoveSans,
                    fontWeight = FontWeight.Bold,
                    color = secondaryLight,
                    lineHeight = 8.sp
                )
                Text(
                    text = catdog.name,
                    fontSize = dimensionResource(id = R.dimen.text_xs).value.sp,
                    fontFamily = MoveSans,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 12.sp
                )
                Text(
                    text = "고양이 귀여움 어쩌구 저쩌구...\napi temperament에 있는 설명..",
                    fontSize = dimensionResource(id = R.dimen.text_xxxs).value.sp,
                    fontFamily = MoveSans,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 8.sp
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_xs)))
                Row {
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.size(12.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.FavoriteBorder,
                            contentDescription = stringResource(R.string.popular_catdog_like)
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
        PopularCatDogCard()
    }
}
