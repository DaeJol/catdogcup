package com.daejol.presentation.worldcup.top

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daejol.presentation.ui.theme.BorderRadius
import com.daejol.presentation.ui.theme.CustomRichText
import com.daejol.presentation.ui.theme.CustomTextStyle
import com.daejol.presentation.ui.theme.Orange100
import com.daejol.presentation.ui.theme.Padding
import com.daejol.presentation.ui.theme.RichTextDecoration
import com.daejol.presentation.ui.theme.White100

@Preview
@Composable
fun TopSectionTitleWidget() {
    val titleTextStyle = CustomTextStyle(
        fontSize = 24f,
        fontWeight = FontWeight.Bold
    )

    val subTitleTextStyle = CustomTextStyle(
        fontSize = 24f,
        fontWeight = FontWeight.SemiBold
    )

    val descTextStyle1 = CustomTextStyle(
        fontSize = 12f,
        fontWeight = FontWeight.Normal,
        fontColor = White100
    )

    val descTextStyle2 = CustomTextStyle()

    CustomRichText {
        RichText("고양이 월드컵에", textStyle = titleTextStyle, endOfLine = true)
        RichText("오신 걸 환영해요!", textStyle = titleTextStyle, endOfLine = true)
        RichText("", endOfLine = true)
        RichText("어떤 고양이를", textStyle = subTitleTextStyle, endOfLine = true)
        RichText("골라볼까요?", textStyle = subTitleTextStyle, endOfLine = true)
        RichText("", endOfLine = true)
        RichText(
            "월드컵 방식", textStyle = descTextStyle1, decoration = RichTextDecoration(
                background = Orange100,
                borderRadius = BorderRadius(100f, 100f, 100f, 100f),
                padding = Padding(6f, 2f, 6f, 2f)
            )
        )
        RichText("을 지정해주세요.", textStyle = descTextStyle2)
    }
}