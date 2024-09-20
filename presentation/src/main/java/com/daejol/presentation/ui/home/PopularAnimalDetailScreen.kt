package com.daejol.presentation.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.FileDownload
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.UrlAnnotation
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.daejol.presentation.R
import com.daejol.presentation.data.SampleData
import com.daejol.presentation.model.Animal
import com.daejol.presentation.model.HomeUiState
import com.daejol.presentation.ui.theme.CatdogcupTheme
import com.daejol.presentation.ui.theme.Typography

@Composable
fun PopularAnimalDetailScreen(
    homeUiState: HomeUiState,
    navController: NavController?
) {
    CatdogcupTheme {
        Scaffold { innerPadding ->
            Box {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                ) {
                    AnimalDetailImage(homeUiState.breed.imageUrl)
                    AnimalDetailDescription(homeUiState.breed)
                }
                PopularAnimalBackButton(navController = navController)
            }
        }
    }
}

@Composable
private fun AnimalDetailImage(
    imageUrl: String
) {
    Box {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            placeholder = painterResource(id = R.drawable.sample_cat),
            contentDescription = stringResource(id = R.string.popular_animal_image),
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.space_xs))
        ) {
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Outlined.FileDownload,
                    contentDescription = "이미지 다운로드",
                    modifier = Modifier.size(dimensionResource(id = R.dimen.detail_icon_button_size))
                )
            }
        }
    }
}

@Composable
private fun PopularAnimalBackButton(
    navController: NavController?
) {
    Row(
        modifier = Modifier.padding(dimensionResource(id = R.dimen.space_xs))
    ) {
        IconButton(
            onClick = { navController?.navigateUp() },
        ) {
            Icon(
                imageVector = Icons.Outlined.ArrowBackIosNew,
                contentDescription = stringResource(id = R.string.popular_animal_back),
                modifier = Modifier.size(dimensionResource(id = R.dimen.detail_icon_button_size))
            )
        }
    }
}

@Composable
private fun AnimalDetailDescription(
    animal: Animal
) {
    Column(
        modifier = Modifier.padding(dimensionResource(id = R.dimen.space_m))
    ) {
        Row {
            Text(
                text = animal.name,
                style = Typography.headlineLarge,
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )
            IconButton(onClick = { /* TODO: 좋아요 */ }) {
                Icon(
                    imageVector = Icons.Outlined.BookmarkBorder,
                    contentDescription = stringResource(id = R.string.popular_animal_like)
                )
            }
        }
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_l)))
        AnimalDetailAttribute(title = "Weight", desc = animal.weight)
        AnimalDetailAttribute(title = "Temperament", desc = animal.temperament.toString())
        AnimalDetailAttribute(title = "Origin", desc = animal.origin)
        AnimalDetailAttribute(title = "Description", desc = animal.description)
        AnimalDetailAttribute(title = "Life Span", desc = animal.lifeSpan)
        AnimalDetailAttribute(
            title = "Wikipedia URL",
            desc = animal.wikipediaUrl,
            isClickable = true
        )
    }
}

@Composable
private fun AnimalDetailAttribute(
    title: String,
    desc: String,
    isClickable: Boolean = false
) {
    Column {
        Text(
            text = title,
            style = Typography.titleLarge
        )
        if (isClickable) {
            val annotatedString = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(color = MaterialTheme.colorScheme.primary)
                ) {
                    append(desc)
                }

                addStringAnnotation(
                    tag = "URL",
                    annotation = desc,
                    start = 0,
                    end = desc.length
                )
            }
            val uriHandler = LocalUriHandler.current

            ClickableText(annotatedString) {
                annotatedString
                    .getStringAnnotations("URL", it, it)
                    .firstOrNull()?.let { stringAnnotation ->
                        uriHandler.openUri(stringAnnotation.item)
                    }
            }
        } else {
            Text(
                text = desc,
                style = Typography.bodyMedium
            )
        }
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_l)))
    }
}

@Preview
@Composable
fun PopularAnimalDetailScreenPreview() {
    CatdogcupTheme {
        PopularAnimalDetailScreen(
            homeUiState = HomeUiState(SampleData.animals[0]),
            navController = null
        )
    }
}
