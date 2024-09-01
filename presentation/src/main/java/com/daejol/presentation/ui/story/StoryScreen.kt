package com.daejol.presentation.ui.story

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.daejol.presentation.ui.theme.Black100
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

    LaunchedEffect(key1 = images) {
        launch {
            delay(3000)
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
    }

    Column(
        modifier = Modifier
            .background(Black100)
    ) {
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
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
                    .padding(5.dp),
            )
        }
    }
}

@Composable
fun TimerWidget() {
    Row {
        
    }
}