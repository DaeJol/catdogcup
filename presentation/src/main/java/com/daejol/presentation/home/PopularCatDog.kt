package com.daejol.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daejol.presentation.R
import com.daejol.presentation.ui.theme.Blue20
import com.daejol.presentation.ui.theme.Typography


@Composable
fun PopularCatDog() {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Blue20
        ),
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.space_m))
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.popular_catdog),
                fontSize = dimensionResource(id = R.dimen.text_l).value.sp,
                style = Typography.titleLarge,
                color = Color.White
            )
            Text(
                text = stringResource(id = R.string.popular_catdog_desc),
                fontSize = dimensionResource(id = R.dimen.text_xs).value.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.space_s)))
            LazyRow(
                Modifier.height(160.dp)
            ) {
                item(5) {
                    Image(
                        painter = painterResource(id = R.drawable.sample_cat_of_today),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.rounded_corner_size)))
                            .background(Color.White)
                    )
                }
            }
        }
    }
}
