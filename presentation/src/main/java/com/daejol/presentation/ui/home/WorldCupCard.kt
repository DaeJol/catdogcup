package com.daejol.presentation.ui.home

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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.daejol.presentation.R
import com.daejol.presentation.ui.theme.CatdogcupTheme
import com.daejol.presentation.ui.theme.Typography

@Composable
fun WorldCupCard(
    @StringRes title: Int = R.string.cat_world_cup_title,
    @StringRes desc: Int = R.string.cat_world_cup_desc,
    @StringRes button: Int = R.string.cat_world_cup_button,
    @DrawableRes painter: Int = R.drawable.cat,
    onClick: () -> Unit
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.elevation_default)
        ),
        onClick = { onClick.invoke() },
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(dimensionResource(id = R.dimen.space_l))
        ) {
            Column(
                Modifier.weight(1f)
            ) {
                Text(
                    text = stringResource(id = title),
                    fontSize = dimensionResource(id = R.dimen.text_l).value.sp,
                    style = Typography.titleSmall
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_xs)))
                Text(
                    text = stringResource(id = desc),
                    style = Typography.bodySmall
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_m)))
                val colorScheme = MaterialTheme.colorScheme
                val cornerRadius = dimensionResource(id = R.dimen.world_cup_card_text_corner_radius)
                Text(
                    text = stringResource(id = button),
                    color = colorScheme.onPrimary,
                    style = Typography.titleSmall,
                    modifier = Modifier
                        .drawBehind {
                            drawRoundRect(
                                color = colorScheme.inversePrimary,
                                cornerRadius = CornerRadius(
                                    cornerRadius.toPx(),
                                    cornerRadius.toPx()
                                )
                            )
                        }
                        .padding(dimensionResource(id = R.dimen.space_xxxs))
                )
            }
            Column {
                Image(
                    painter = painterResource(id = painter),
                    contentDescription = null,
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.world_cup_card_image_size))
                )
                Spacer(
                    modifier = Modifier.height(dimensionResource(id = R.dimen.space_s))
                )
            }
        }
    }
}

@Preview
@Composable
fun WorldCupCardPreview() {
    CatdogcupTheme {
        WorldCupCard(onClick = {})
    }
}
