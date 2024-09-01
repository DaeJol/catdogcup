package com.daejol.presentation.ui.match

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.daejol.presentation.R
import com.daejol.presentation.model.Screen
import com.daejol.presentation.ui.theme.CatdogcupTheme
import com.daejol.presentation.ui.theme.CustomRichText
import com.daejol.presentation.ui.theme.CustomTextStyle
import com.daejol.presentation.ui.theme.Gimpo
import com.daejol.presentation.ui.theme.MoveSans
import com.daejol.presentation.ui.theme.Orange100
import com.daejol.presentation.ui.theme.Orange80
import com.daejol.presentation.ui.theme.Pretendard
import com.daejol.presentation.ui.theme.RichTextAlign
import com.daejol.presentation.ui.theme.White100
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun MatchStartScreen(
    navController: NavController? = null
) {
    val configuration = LocalConfiguration.current

    val sh = configuration.screenHeightDp.dp
    val sw = configuration.screenWidthDp.dp

    return CatdogcupTheme(
        statusBarColor = Orange80
    ) {
        // A surface container using the 'background' color from the theme
        Column {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(sh / 3 * 2),
                color = Orange80
            ) {
                Column(
                    // 가운데 정렬하고
                    horizontalAlignment = Alignment.CenterHorizontally,
                    // 양쪽 벌어지게 만들고
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "나의 단짝을\n찾아보세요.",
                        // CustomFontStyle에서 생성
                        style = CustomTextStyle(
                            fontFamily = Pretendard,
                            fontSize = 30F,
                            fontWeight = FontWeight.Bold,
                            fontColor = White100
                        ).style,
                        // 텍스트의 top 패딩 주기
                        modifier = Modifier
                            .padding(top = 80.dp)
                    )
                    CustomRichText(
                        defaultFontWeight = FontWeight.SemiBold,
                        defaultFontFamily = MoveSans,
                        textAlign = RichTextAlign.Center
                    ) {
                        RichText("질문에 답변하고", endOfLine = true)
                        RichText("나와 성격이 비슷한", endOfLine = true)
                        RichText(
                            "강아지",
                            textStyle = CustomTextStyle(
                                fontColor = White100,
                                fontFamily = Gimpo,
                                fontWeight = FontWeight.Normal
                            ),
                        )
                        RichText("와 ")
                        RichText(
                            "고양이",
                            textStyle = CustomTextStyle(
                                fontColor = White100,
                                fontFamily = Gimpo,
                                fontWeight = FontWeight.Normal
                            ),
                        )
                        RichText("를 찾아보세요.", endOfLine = true)
                        RichText("", endOfLine = true)
                        RichText("준비 되셨나요?")
                    }

                    // 스페이스 여백 공간 하나 만들고 (fillMax
                    GlideImage(
                        imageModel = R.drawable.personal_match_screen_1,
                        modifier = Modifier
                            .width(sw / 5 * 2)
                            .aspectRatio(1.0F),
                        alignment = Alignment.BottomCenter
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    navController?.navigate(Screen.MatchingQuestion.route)
                },
                modifier = Modifier
                    .width(sw / 3 * 2)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonColors(
                    containerColor = Orange100,
                    contentColor = Orange100,
                    disabledContentColor = Orange100,
                    disabledContainerColor = Orange100
                )
            ) {
                Text(
                    text = "내 단짝 찾으러 가기",
                    color = White100,
                    fontFamily = Pretendard,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
