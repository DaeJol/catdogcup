package com.daejol.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daejol.presentation.R
import com.daejol.presentation.ui.theme.Green20
import com.daejol.presentation.ui.theme.Typography

@Composable
fun CatOfTodayCard() {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Green20
        ),
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        Column(
            Modifier.padding(dimensionResource(id = R.dimen.space_m))
        ) {
            Text(
                text = stringResource(id = R.string.cat_of_today),
                textAlign = TextAlign.Center,
                fontSize = dimensionResource(id = R.dimen.text_l).value.sp,
                style = Typography.titleLarge
            )
            Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.space_m)))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sample_cat_of_today),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(128.dp)
                        .clip(RoundedCornerShape(dimensionResource(id = R.dimen.rounded_corner_size)))
                        .background(Color.White)
                )
                Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.space_m)))
                Column {
                    Text(
                        text = "러시안 블루",
                        style = Typography.titleLarge,
                        fontSize = dimensionResource(id = R.dimen.text_xs).value.sp
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = "복을 불러오는 고양이에요.\n" +
                                "항상 다정다감하고 집사랑 잘 놀아주지만,\n" +
                                "때때로 우울함에 빠져서 시무룩하고 잘 삐친답니다....",
                        fontSize = 10.sp,
                        lineHeight = 14.sp
                    )
                    Text(
                        text = stringResource(id = R.string.cat_of_today_more),
                        fontSize = 10.sp,
                        modifier = Modifier.clickable { /* TODO */ }
                    )
                }
            }
        }
    }
}
