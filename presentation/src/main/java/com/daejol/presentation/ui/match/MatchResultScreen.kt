package com.daejol.presentation.ui.match

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.daejol.presentation.R
import com.daejol.presentation.model.Screen
import com.daejol.presentation.ui.theme.CatdogcupTheme
import com.daejol.presentation.ui.theme.CustomRichText
import com.daejol.presentation.ui.theme.CustomTextStyle
import com.daejol.presentation.ui.theme.Gimpo
import com.daejol.presentation.ui.theme.MoveSans
import com.daejol.presentation.ui.theme.Orange100
import com.daejol.presentation.ui.theme.Orange80
import com.daejol.presentation.ui.theme.RichTextAlign
import com.daejol.presentation.ui.theme.White100
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun MatchResultScreen(
    viewModel: MatchViewModel,
    navController: NavController
) {
    val configuration = LocalConfiguration.current

    val sh = configuration.screenHeightDp.dp
    val sw = configuration.screenWidthDp.dp

    val result = viewModel.matchResult.value

    return CatdogcupTheme(
        statusBarColor = Orange80
    ) {
        // A surface container using the 'background' color from the theme
        Column {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(sh / 2 - 70.dp),
                color = Orange80
            ) {
                Column(
                    // 양쪽 벌어지게 만들고
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier
                        .height(30.dp))
                    CustomRichText(
                        defaultFontWeight = FontWeight.SemiBold,
                        defaultFontFamily = MoveSans,
                        textAlign = RichTextAlign.Center
                    ) {
                        RichText(
                            "당신은",
                            textStyle = CustomTextStyle(
                                fontFamily = Gimpo,
                                fontWeight = FontWeight.Normal,
                                fontSize = 24f
                            ),
                            lineHeight = 10.dp,
                            endOfLine = true
                        )
                        RichText(
                            "${result?.name}",
                            textStyle = CustomTextStyle(
                                fontColor = White100,
                                fontFamily = MoveSans,
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 32f
                            ),
                            modifier = Modifier
                                .padding(vertical = 4.dp),
                            endOfLine = true
                        )
                        RichText(
                            "유형이에요",
                            textStyle = CustomTextStyle(
                                fontFamily = Gimpo,
                                fontWeight = FontWeight.Normal,
                                fontSize = 24f
                            ),
                            lineHeight = 30.dp,
                            endOfLine = true
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .height(70.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp)
                        .background(Orange80)
                    )
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp)
                        .background(Color.Transparent)
                    )
                }
                // 스페이스 여백 공간 하나 만들고 (fillMax
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(result?.imageUrl)
                        .build(),
                    placeholder = painterResource(id = R.drawable.catdogcup_logo),
                    contentDescription = "고양이 매칭 결과",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(sw / 2)
                        .aspectRatio(1.0F)
                        .clip(CircleShape)
                        .border(
                            width = 3.dp, // 너비 5dp
                            color = White100, // 색상 파란색
                            shape = CircleShape // 네모 모양
                        ),
                )
            }
            Spacer(modifier = Modifier
                .height(70.dp))

            CustomRichText {
                RichText(
                    text = "${result?.description}".trimIndent(),
                    textStyle = CustomTextStyle(
                        fontFamily = Gimpo,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14f
                    ),
                    modifier = Modifier
                        .width(sw / 10 * 9)
                        .padding(start = 10.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(bottom = 40.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Bottom
            ) {
                Button(
                    onClick = {
                        navController.navigate(Screen.Home.route)
                    },
                    modifier = Modifier
                        .width(sw / 5 * 2)
                        .border(
                            width = 3.dp,
                            color = Orange80,
                            shape = CircleShape
                        ),
                ) {
                    Text(
                        text = stringResource(id = R.string.match_result_go_home),
                        fontSize = 16.sp,
                        fontFamily = Gimpo,
                        fontWeight = FontWeight.Normal,
                        color = Orange80,
                    )
                }
                Button(
                    onClick = {
                        viewModel.matchResult.value = null
                        navController.navigate(Screen.Matching.route)
                    },
                    modifier = Modifier
                        .width(sw / 5 * 2),
                    colors = ButtonColors(
                        containerColor = Orange100,
                        contentColor = Orange100,
                        disabledContentColor = Orange100,
                        disabledContainerColor = Orange100
                    )
                ) {
                    Text(
                        text = stringResource(id = R.string.match_result_one_more),
                        color = White100,
                        fontSize = 16.sp,
                        fontFamily = Gimpo,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }
    }
}
