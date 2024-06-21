package com.daejol.presentation.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.daejol.presentation.R
import com.daejol.presentation.ui.theme.Typography
import com.daejol.presentation.ui.theme.White100

@Composable
fun WorldCupCard(
    @StringRes title: Int,
    @StringRes desc: Int,
    @StringRes button: Int,
    @DrawableRes painter: Int
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.elevation_default)
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.world_cup_card_height))
    ) {
        Row(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.space_m))
        ) {
            Column(
                Modifier.weight(1f)
            ) {
                Text(
                    text = stringResource(id = title),
                    fontSize = dimensionResource(id = R.dimen.text_s).value.sp,
                    style = Typography.titleLarge
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_s)))
                Text(
                    text = stringResource(id = desc),
                    fontSize = dimensionResource(id = R.dimen.text_xxs).value.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .height(dimensionResource(id = R.dimen.space_m))
                        .wrapContentWidth(),
//                    colors = ButtonColors(
//                        containerColor = Orange80,
//                        contentColor = White100,
//                        disabledContainerColor = Grey10,
//                        disabledContentColor = White100
//                    )
                ) {
                    Text(
                        text = stringResource(id = button),
                        fontSize = dimensionResource(id = R.dimen.text_xxs).value.sp,
                        color = White100,
                        style = Typography.titleLarge
                    )
                }
            }
            Image(
                painter = painterResource(id = painter),
                contentDescription = null,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.world_cup_card_image_size))
            )
        }
    }
}
