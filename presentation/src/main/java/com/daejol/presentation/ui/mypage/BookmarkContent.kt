package com.daejol.presentation.ui.mypage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.daejol.presentation.R
import com.daejol.presentation.data.SampleData
import com.daejol.presentation.model.Animal
import com.daejol.presentation.model.Screen
import com.daejol.presentation.ui.home.Title
import com.daejol.presentation.ui.theme.CatdogcupTheme

@Composable
fun BookmarkContent(
    modifier: Modifier = Modifier,
    navController: NavController?,
    animals: List<Animal>
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(end = 0.dp)
    ) {
        Row(
            modifier = modifier.padding(start = dimensionResource(id = R.dimen.space_l))
        ) {
            Title(
                text = stringResource(id = R.string.my_page_title_bookmark),
                modifier = modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )
            IconButton(onClick = { navController?.navigate(Screen.Bookmark.route) }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = stringResource(id = R.string.my_page_bookmark_more)
                )
            }
        }
        LazyRow(
            modifier = modifier,
            contentPadding = PaddingValues(horizontal = dimensionResource(id = R.dimen.space_l))
        ) {
            items(animals) { animal ->
                BookmarkItem(animal)
            }
        }
    }
}

@Composable
private fun BookmarkItem(
    animal: Animal
) {
    Box(
        modifier = Modifier.size(88.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(animal.imageUrl)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.sample_cat),
            contentDescription = stringResource(id = R.string.my_page_bookmarked_image),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun BookmarkContentPreview() {
    CatdogcupTheme {
        BookmarkContent(
            modifier = Modifier.background(color = MaterialTheme.colorScheme.background),
            navController = null,
            animals = SampleData.animals
        )
    }
}
