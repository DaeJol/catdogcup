package com.daejol.presentation.ui.match

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.daejol.presentation.R
import com.daejol.presentation.data.MatchResult
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

    MatchResult.init()
    val index = remember {
        mutableIntStateOf(0)
    }

    val questions = remember {
        mutableStateOf(MatchResult.getQuestions())
    }

    var currentQuestion = remember {
        mutableStateOf(questions.value[index.intValue])
    }

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
                        Text(text = "테스트입니다:::${index.intValue}")
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
                                modifier = Modifier.padding(vertical = 4.dp),
                                endOfLine = true
                            )
                            RichText(
                                "${index.intValue + 1} / ${questions.value.size}",
                                textStyle = CustomTextStyle(
                                    fontColor = White100,
                                    fontFamily = MoveSans,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 36f
                                ),
                                lineHeight = 100.dp,
                                modifier = Modifier.padding(vertical = 4.dp),
                                endOfLine = true,
                            )
                            RichText(
                                currentQuestion.value.question,
                                textStyle = CustomTextStyle(
                                    fontFamily = Gimpo,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 18f
                                ),
                                modifier = Modifier.padding(top = 10.dp, start = 10.dp, end = 10.dp)
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
                    onClick = {
                        MatchResult.add(currentQuestion.value.answerList.first())

                        index.intValue += 1
                        currentQuestion.value = questions.value[index.intValue]

                        if (index.intValue == questions.value.size - 1) {
                            navController?.navigate(Screen.MatchingLoading.route)
                        }
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
                        text = currentQuestion.value.answerList.first().answer,
                        color = White100,
                        fontFamily = Pretendard,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        MatchResult.add(currentQuestion.value.answerList.last())
                        index.intValue += 1
                        currentQuestion.value = questions.value[index.intValue]

                        if (index.intValue == questions.value.size - 1) {
                            navController?.navigate(Screen.MatchingLoading.route)
                        }
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
                        text = currentQuestion.value.answerList.last().answer,
                        color = White100,
                        fontFamily = Pretendard,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
