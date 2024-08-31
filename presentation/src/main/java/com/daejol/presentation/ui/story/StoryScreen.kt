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
    val imageWidth = LocalConfiguration.current.screenWidthDp.dp / 5 * 4 - 10.dp
    val imageHeight = LocalConfiguration.current.screenWidthDp.dp / 5 * 4 - 20.dp

    viewModel.getStoryImages(LocalContext.current)
    val images = viewModel.storyImages.value

    println("[keykat] images: $images   count:: ${images.size}")

    val pageState = rememberPagerState {
        images.size
    }

    Column {
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            state = pageState
        ) {
            AsyncImage(
                model = images[pageState.currentPage],
                contentDescription = "",
                modifier = Modifier
                    .width(imageWidth)
                    .height(imageHeight)
                    .padding(5.dp)
                    .shadow(
                        elevation = 1.5.dp,
                        shape = RoundedCornerShape(
                            topStart = 20.dp,
                            topEnd = 20.dp
                        )
                    ),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun TimerWidget() {
    Row {
        
    }
}