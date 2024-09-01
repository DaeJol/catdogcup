package com.daejol.presentation.ui.match

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun MatchLoadingScreen(
    navController: NavController
) {
    val configuration = LocalConfiguration.current

    val sh = configuration.screenHeightDp.dp
    val sw = configuration.screenWidthDp.dp

    CatdogcupTheme(
        statusBarColor = Orange80
    ) {
        // A surface container using the 'background' color from the theme
        Column {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                color = Orange80
            ) {
                Column(
                    // 양쪽 벌어지게 만들고
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CustomRichText(
                        defaultFontWeight = FontWeight.SemiBold,
                        defaultFontFamily = MoveSans,
                        textAlign = RichTextAlign.Center
                    ) {
                        RichText(
                            text = stringResource(id = R.string.match_title_1),
                            textStyle = CustomTextStyle(
                                fontColor = White100,
                                fontFamily = Gimpo,
                                fontWeight = FontWeight.Normal,
                                fontSize = 24f
                            ),
                            lineHeight = 10.dp,
                            endOfLine = true
                        )
                        RichText(
                            stringResource(id = R.string.match_title_2),
                            textStyle = CustomTextStyle(
                                fontFamily = Gimpo,
                                fontWeight = FontWeight.Normal,
                                fontSize = 24f
                            ),
                            lineHeight = 30.dp,
                            endOfLine = true
                        )
                    }
                    // 스페이스 여백 공간 하나 만들고 (fillMax
                    GlideImage(
                        imageModel = R.drawable.image_math_result,
                        modifier = Modifier
                            .width(sw / 5 * 2)
                            .aspectRatio(1.0F),
                    )
                    Spacer(
                        modifier = Modifier
                            .height(50.dp)
                    )
                    Button(
                        onClick = {
                            navController.navigate(Screen.MatchingResult.route)
                        },
                        modifier = Modifier
                            .width(sw / 3 * 2),
                        colors = ButtonColors(
                            containerColor = Orange100,
                            contentColor = Orange100,
                            disabledContentColor = Orange100,
                            disabledContainerColor = Orange100
                        )
                    ) {
                        Text(
                            text = "결과 보러 가기",
                            color = White100,
                            fontSize = 20.sp,
                            fontFamily = Gimpo,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }
            }
        }
    }
}
