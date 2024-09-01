package com.daejol.presentation.ui.story

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.daejol.presentation.ui.theme.Black100
import com.daejol.presentation.ui.theme.Orange100
import com.daejol.presentation.ui.theme.Orange60
import com.daejol.presentation.ui.theme.Orange80
import com.daejol.presentation.ui.theme.White100
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StoryScreen(
    viewModel: StoryViewModel,
) {
    val imageWidth = LocalConfiguration.current.screenWidthDp.dp
    val imageHeight = (LocalConfiguration.current.screenHeightDp * 0.6).dp
    val images = viewModel.storyImages.value

    val pageState = rememberPagerState {
        images.size
    }

    val ticks: MutableState<Long> = remember { mutableStateOf(0L) }
    val timeRange = 10L

    LaunchedEffect(Unit) {
        while (true) {
            if (ticks.value >= 100 * 10 * 10.2) {
                ticks.value = 0

                with(pageState) {
                    val target = if (currentPage < pageCount - 1) currentPage + 1 else 0

                    animateScrollToPage(
                        page = target,
                        animationSpec = tween(
                            durationMillis = 500,
                            easing = FastOutSlowInEasing
                        )
                    )
                }
            }

            delay(4)
            ticks.value += timeRange
        }
    }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Black100),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TimerWidget(ticks = ticks)
        HorizontalPager(
            modifier = Modifier
                .width(imageWidth)
                .height(imageHeight),
            verticalAlignment = Alignment.CenterVertically,
            state = pageState
        ) { page ->
            AsyncImage(
                model = images[page].imageRequest,
                contentDescription = "",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .width(imageWidth)
                    .height(imageHeight)
            )
        }
    }
}

@Composable
fun TimerWidget(
    ticks: MutableState<Long>,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        TimerWidgetItem(color = Orange60, ticks = ticks, min = 0.0, max = 3333.0)
        TimerWidgetItem(color = Orange80, ticks = ticks, min = 3333.0, max = 6666.0)
        TimerWidgetItem(color = Orange100, ticks = ticks, min = 6666.0, max = 9999.0)
    }
}

@Composable
fun TimerWidgetItem(
    color: Color,
    ticks: MutableState<Long>,
    min: Double,
    max: Double,
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp * 0.31
    val rateWidth = if (ticks.value < min) {
        0.toDouble()
    } else if (ticks.value / max < 1) {
        (ticks.value - min) / (max - min)
    } else {
        1.0
    }

    val barWidth = (screenWidth * rateWidth).dp

    Box(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .width(screenWidth.dp)
            .height(10.dp)
            .clip(RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.TopStart
    ) {
        Box(
            contentAlignment = Alignment.TopStart,
            modifier = Modifier
                .background(color)
                .width((barWidth))
                .height(10.dp)
        ) {

        }
        Box(
            contentAlignment = Alignment.TopStart,
            modifier = Modifier
                .background(Color.Transparent)
                .width(screenWidth.dp)
                .height(10.dp),
        ) {

        }
    }
}