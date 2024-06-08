package com.daejol.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daejol.presentation.theme.Blue10
import com.daejol.presentation.theme.Blue20
import com.daejol.presentation.theme.Green10
import com.daejol.presentation.theme.Green20
import com.daejol.presentation.theme.Yellow10
import com.daejol.presentation.theme.CatdogcupTheme
import com.daejol.presentation.theme.Typography
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import usecase.GetImageUsecase
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject lateinit var getImageUsecase: GetImageUsecase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CatdogcupTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        CoroutineScope(Dispatchers.IO).launch {
            getImageUsecase.getRandomCatImages(10)?.collect {
                it?.forEach { list ->
                    println("[keykat] list: $list")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Blue10
                ),
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // TODO: coil, glide 라이브러리 사용
                        Image(
                            painter = painterResource(id = R.drawable.catdog_app_bar_icon),
                            contentDescription = null,
                            modifier = Modifier
                                .size(28.dp),
                        )
                        Text(
                            text = stringResource(id = R.string.app_bar_title),
                            style = Typography.titleLarge
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CatOfTodayCard()
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                SingleWorldCupCard(stringResource(id = R.string.cat_world_cup), Yellow10)
                SingleWorldCupCard(stringResource(id = R.string.dog_world_cup), Green10)
                MixedWorldCup(title = stringResource(id = R.string.mixed_world_cup), color = Yellow10)
            }
            Spacer(modifier = Modifier.height(12.dp))
            PopularCatDog()
        }
    }
}

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
            Modifier.padding(dimensionResource(id = R.dimen.space_medium))
        ) {
            Text(
                text = stringResource(id = R.string.cat_of_today),
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                style = Typography.titleLarge
            )
            Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.space_medium)))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sample_cat_of_today),
                    contentDescription = null,
                    Modifier.size(128.dp)
                )
                Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.space_medium)))
                Column {
                    Text(
                        text = "러시안 블루",
                        style = Typography.titleLarge,
                        fontSize = 12.sp
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

@Composable
fun SingleWorldCupCard(
    title: String,
    color: Color
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = color
        ),
        modifier = Modifier
            .size(size = dimensionResource(id = R.dimen.world_cup_card_size))
    ) {
        Text(
            text = title,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.space_medium)),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun MixedWorldCup(
    title: String,
    color: Color
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = color
        ),
        modifier = Modifier
            .size(width = 125.dp, height = dimensionResource(id = R.dimen.world_cup_card_size))
    ) {
        Text(
            text = title,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.space_medium)),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun PopularCatDog() {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Blue20
        ),
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "인기 고양이 & 강아지",
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.space_medium)),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CatdogcupTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MainScreen()
        }
    }
}
