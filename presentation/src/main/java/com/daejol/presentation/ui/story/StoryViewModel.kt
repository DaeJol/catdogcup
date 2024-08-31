package com.daejol.presentation.ui.story

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.imageLoader
import coil.request.CachePolicy
import coil.request.ErrorResult
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.daejol.domain.usecase.GetImageUseCase
import com.daejol.domain.usecase.AnimalType
import com.daejol.presentation.model.ImageModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import okhttp3.internal.toImmutableList
import javax.inject.Inject

@HiltViewModel
class StoryViewModel @Inject constructor(
    private val imageUseCase: GetImageUseCase,
): ViewModel() {
    private val _storyImages = mutableStateOf(listOf<ImageModel>())
    val storyImages: State<List<ImageModel>> = _storyImages

    fun getStoryImages(
        context: Context,
    ) {
        println("[keykat] getStoryImage")
        var list: List<ImageModel> = listOf()
        viewModelScope.launch {
            imageUseCase.getAnimalList(
                type = AnimalType.COMBINED, randomImageCount = 128,
            ).catch {

            }.collect {
                list = it.toImmutableList().map {
                    val request = ImageRequest
                        .Builder(context)
                        .data(it.url)
                        .build()

                    context.imageLoader.enqueue(request = request)

                    ImageModel(
                        imageEntity = it,
                        imageRequest = request
                    )
                }
            }

//            println("[keykat] list ::: $list")
//            println("[keykat] list size: ${list.size}")
            _storyImages.value = list
        }
    }

    private fun createImageRequest(
        context: Context,
        imageUrl: String
    ): ImageRequest {
        val listener = object : ImageRequest.Listener {
            override fun onError(request: ImageRequest, result: ErrorResult) {
                super.onError(request, result)
            }

            override fun onSuccess(request: ImageRequest, result: SuccessResult) {
                super.onSuccess(request, result)
            }
        }

        return ImageRequest.Builder(context)
            .data(imageUrl)
            .listener(listener)
            .memoryCacheKey(imageUrl)
            .diskCacheKey(imageUrl)
//            .placeholder(placeholder)
//            .error(placeholder)
//            .fallback(placeholder)
            .diskCachePolicy(CachePolicy.ENABLED)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .build()
    }
}