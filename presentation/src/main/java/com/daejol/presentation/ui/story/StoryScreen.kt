package com.daejol.presentation.ui.story

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.daejol.presentation.ui.worldcup.WorldCupViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StoryScreen(
    viewModel: StoryViewModel,
) {
    val imageWidth = LocalConfiguration.current.screenWidthDp.dp
    val imageHeight = LocalConfiguration.current.screenHeightDp.dp
    val images = viewModel.storyImages.value

    println("[keykat] images: $images")
    println("[keykat] count::: ${images.size}")

    val pageState = rememberPagerState {
        images.size
    }

    Column {
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            state = pageState
        ) { page ->
            AsyncImage(
                model = images[page].imageRequest,
                contentDescription = "",
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