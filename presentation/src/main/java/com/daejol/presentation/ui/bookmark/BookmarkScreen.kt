package com.daejol.presentation.ui.bookmark

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.daejol.presentation.R
import com.daejol.presentation.data.SampleData
import com.daejol.presentation.ui.home.Title
import com.daejol.presentation.ui.theme.CatdogcupTheme

@Composable
fun BookmarkScreen(
    modifier: Modifier = Modifier
) {
    val animals = SampleData.animals

    CatdogcupTheme {
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(3),
            verticalItemSpacing = 4.dp,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            modifier = modifier.padding(dimensionResource(id = R.dimen.space_l))
        ) {
            item(span = StaggeredGridItemSpan.FullLine) {
                Title(text = stringResource(id = R.string.my_page_title_bookmark))
            }
            item(span = StaggeredGridItemSpan.FullLine) {
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_l)))
            }
            items(animals) { animal ->
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(animal.imageUrl)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(id = R.drawable.sample_cat),
                    contentDescription = "북마크한 고양이 & 강아지"
                )
            }
        }
    }
}

@Preview
@Composable
fun BookmarkScreenPreview() {
    CatdogcupTheme {
        BookmarkScreen(
            Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
        )
    }
}
