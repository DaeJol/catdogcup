package com.daejol.presentation.worldcup

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.daejol.presentation.R
import com.daejol.presentation.ui.theme.Orange80

@Preview
@Composable
fun TopSectionCatImageWidget(
    @PreviewParameter(WorldCupPreviewParameterProvider::class) type: WorldCupType
) {
    val image = when (type) {
        WorldCupType.CAT -> R.drawable.main_cat
        WorldCupType.DOG -> R.drawable.main_dog
        WorldCupType.COMBINED -> R.drawable.main_combined
        else -> null
    }

    val width = 140.dp
    val height = 180.dp

    return Box {
        HalfOval(width = width, height = height, color = Orange80)
        Box {
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .width(width = width)
                    .height(height = height),
            ) {
                image?.let {
                    Image(
                        painterResource(image),
                        modifier = Modifier
                            .width(width)
                            .height(height)
                            .padding(20.dp, 0.dp, 0.dp, 0.dp),
                        alignment = Alignment.CenterStart,
                        contentDescription = "",
                    )
                }
            }
        }
    }
}

/*
반원에 옆에 사각형 모양의 디자인을 만드려고 한 커스텀 도형으로, 유사하게 쓰는 곳이 있으면
참고할 것
 */
@Composable
fun HalfOval(
    width: Dp,
    height: Dp,
    color: Color = Color.Transparent
) {

    return Box(
    ) {
        Canvas(
            modifier = Modifier
                .width(width / 2)
                .height(height / 2),
            onDraw = {
                val path = Path().apply {
                    addOval(
                        Rect(
                            0f,
                            0f,
                            (width).toPx(),
                            height.toPx()
                        )
                    )
                }

                drawPath(
                    path = path,
                    color = color,
                )
            }
        )
        Canvas(
            modifier = Modifier,
            onDraw = {
                drawRect(
                    color = color,
                    topLeft = Offset(
                        (width / 2).toPx(),
                        0.dp.toPx()
                    ),
                    size = Size(
                        width = (width / 2).toPx(),
                        height = height.toPx()
                    ),
                )
            },
        )
    }
}