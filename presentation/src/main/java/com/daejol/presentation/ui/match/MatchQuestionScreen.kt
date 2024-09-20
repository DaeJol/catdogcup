package com.daejol.presentation.ui.match

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
fun MatchQuestionScreen(
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
                    .height(sh / 9 * 5),
                color = Orange80
            ) {
                Column(
                    // 양쪽 벌어지게 만들고
                    verticalArrangement = Arrangement.SpaceBetween,
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Spacer(modifier = Modifier.height(20.dp))
                        CustomRichText(
                            defaultFontWeight = FontWeight.SemiBold,
                            defaultFontFamily = MoveSans,
                            textAlign = RichTextAlign.Center
                        ) {
                            RichText(
                                "Question No.",
                                textStyle = CustomTextStyle(
                                    fontColor = White100,
                                    fontFamily = MoveSans,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16f
                                ),
                                lineHeight = 10.dp,
                                endOfLine = true
                            )
                            RichText(
                                "5 / 10",
                                textStyle = CustomTextStyle(
                                    fontColor = White100,
                                    fontFamily = MoveSans,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 36f
                                ),
                                lineHeight = 100.dp,
                                endOfLine = true
                            )

                            // TODO: RichText 줄바꿈 되도록 수정할 것
                            RichText(
                                "집 밖에서 노는 것과 집 안에서 노는 것.",
                                textStyle = CustomTextStyle(
                                    fontFamily = Gimpo,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 18f
                                ),
                            )

                            // TODO: RichText 줄바꿈 되도록 수정할 것
                            RichText(
                                "어떤 것이 더 좋은가요?",
                                textStyle = CustomTextStyle(
                                    fontFamily = Gimpo,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 18f
                                ),
                            )
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        // 스페이스 여백 공간 하나 만들고 (fillMax
                        GlideImage(
                            imageModel = R.drawable.personal_match_screen_1,
                            modifier = Modifier
                                .width(sw / 6 * 2)
                                .aspectRatio(1.0F),
                            alignment = Alignment.BottomEnd
                        )
                        Spacer(
                            modifier = Modifier
                            .width(10.dp)
                        )
                    }
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.height(50.dp))
                Button(
                    onClick = {},
                    modifier = Modifier
                        .width(sw / 5 * 4),
                    colors = ButtonColors(
                        containerColor = Orange100,
                        contentColor = Orange100,
                        disabledContentColor = Orange100,
                        disabledContainerColor = Orange100
                    )
                ) {
                    Text(
                        text = "집 밖은 위험해! 집이 제일 좋아.",
                        color = White100,
                        fontFamily = Pretendard,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        navController?.navigate(Screen.MatchingLoading.route)
                    },
                    modifier = Modifier
                        .width(sw / 5 * 4),
                    colors = ButtonColors(
                        containerColor = Orange100,
                        contentColor = Orange100,
                        disabledContentColor = Orange100,
                        disabledContainerColor = Orange100
                    )
                ) {
                    Text(
                        text = "노는 건 무조건 밖이지! 집은 재미 없어.",
                        color = White100,
                        fontFamily = Pretendard,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
