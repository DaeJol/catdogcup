package com.daejol.presentation.ui.worldcup

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.media.MediaScannerConnection
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.ImageLoader
import coil.request.CachePolicy
import coil.request.ErrorResult
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.daejol.domain.usecase.GetImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import okhttp3.internal.toImmutableList
import com.daejol.domain.usecase.SaveImageUseCase
import com.daejol.domain.usecase.AnimalType
import com.daejol.presentation.model.ImageModel
import java.io.File
import javax.inject.Inject
import kotlin.math.pow
import kotlin.random.Random

@HiltViewModel
class WorldCupViewModel @Inject constructor(
    private val imageUseCase: GetImageUseCase,
    private val saveImageUseCase: SaveImageUseCase,
) : ViewModel() {
    private val _worldCupType = mutableStateOf(AnimalType.CAT)
    val worldCupType: State<AnimalType> = _worldCupType

    private val _worldCupLevel = mutableStateOf("16강")
    val worldCupLevel: State<String> = _worldCupLevel

    private val _imageType = mutableStateOf("무작위")
    val imageType: State<String> = _imageType

    private val _bookmark = mutableStateOf(true)
    val bookmark: State<Boolean> = _bookmark

    private val _share = mutableStateOf(true)
    val share: State<Boolean> = _share

    private val _currentGameLevel = mutableIntStateOf(16)
    val currentGameLevel: State<Int> = _currentGameLevel

    private val _worldCupAnimalList = mutableStateOf(listOf<ImageModel>())

    private val _currentMatchImages = mutableStateOf(listOf<ImageModel>())
    val currentMatchImages: State<List<ImageModel>> = _currentMatchImages

    // 128 -> 64 -> 32 -> 16 -> 4 -> final
    private val _gameProgressImageList =
        mutableStateOf<MutableList<MutableList<ImageModel>>>(mutableListOf())

    fun setType(type: AnimalType) {
        _worldCupType.value = type
    }

    fun setLevel(level: String) {
        _worldCupLevel.value = level
    }

    fun setImageSelection(imageType: String) {
        _imageType.value = imageType
    }

    fun saveBookmark(save: Boolean) {
        _bookmark.value = save
    }

    fun allowShare(share: Boolean) {
        _share.value = share
    }

    fun updateGameLevel(level: Int) {
        _currentGameLevel.intValue = level
    }

    fun getAnimalList(
        context: Context,
        onFinish: () -> Unit
    ) {
        viewModelScope.launch {
            imageUseCase.getAnimalList(
                type = _worldCupType.value, randomImageCount = currentGameLevel.value
            ).catch {

            }.collect {
                val list = it.toImmutableList().map {
                    ImageModel(
                        imageEntity = it,
                        imageRequest = createImageRequest(
                            context = context, imageUrl = it.url ?: "",
                        )
                    )
                }
                _worldCupAnimalList.value = list
                onFinish.invoke()
            }
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

    fun initializeGame() {
        if (_gameProgressImageList.value.isEmpty() || _gameProgressImageList.value.last().size != 0) {
            var gameLevel = _currentGameLevel.intValue * 2
            _gameProgressImageList.value.removeAll { true }

            while (gameLevel % 2 == 0) {
                _gameProgressImageList.value.add(mutableListOf())
                gameLevel /= 2
            }

            val tempList = _worldCupAnimalList.value.toMutableList()
            while (_gameProgressImageList.value.first().size < _worldCupAnimalList.value.size) {
                val random = Random.nextInt(tempList.size)
                val element = tempList[random]
                _gameProgressImageList.value.first().add(element)
                tempList.remove(element)
            }

            // 다음 대결 상대 정하기
            var element = _gameProgressImageList.value.first()
            _currentMatchImages.value = element.toList()
        }
    }

    // 현재 누른 이미지는 [_gameProgressImageList] 에 넣고 패배한 이미지는 사라진다.
    fun updateMatch(
        winner: Int,
        onMatchEnd: () -> Unit
    ) {
        println("[keykat] -------------------------------------------------")
        _gameProgressImageList.value.forEach { it ->
            println("[keykat] 현재 게임 상황: _gameProgressImageList: ${it.size}")
        }

        removeSelectedMatch(winner)
        setNextMatchedImages()

        if (checkEndGame(onMatchEnd)) {
            return
        }

        println("[keykat] -------------------------------------------------")
        _gameProgressImageList.value.forEach { it ->
            println("[keykat] 이후 게임 상황: _gameProgressImageList: ${it.size}")
        }
    }

    private fun checkEndGame(onMatchEnd: () -> Unit): Boolean {
        if (_gameProgressImageList.value.last().size != 0) {
            _gameProgressImageList.value.forEach { it ->
                println("[keykat] checlEndGame: _gameProgressImageList: ${it}")
            }

            _currentMatchImages.value = listOf(_gameProgressImageList.value.last().last())
            onMatchEnd.invoke()
            return true
        }

        return false
    }

    private fun removeSelectedMatch(winner: Int) {
        for (i in 0..<_gameProgressImageList.value.size) {
            val element = _gameProgressImageList.value[i]
            if (element.size >= 2) {
                // 일단 현재 이미지가 리스트 내 어떤 이미지인지 판단하고
                val first = element.removeFirst()
                val second = element.removeFirst()

                // 승자조에 넣기
                if (winner == 0) {
                    _gameProgressImageList.value[i + 1].add(first.copy())
                } else {
                    _gameProgressImageList.value[i + 1].add(second.copy())
                }

                break
            }
        }
    }

    private fun setNextMatchedImages() {
        for (i in 0..<_gameProgressImageList.value.size) {
            val element = _gameProgressImageList.value[i]
            // 결과가 나왔을 땐 다음 게임 정보로 업데이트할 필요 없음
            if (element.size >= 2) {
                // 128 -> 64 -> 32 -> 16 -> 8 -> 4 -> final
                println("[keykat] ${(i)}강")
                _currentGameLevel.intValue =
                    (2.0).pow((_gameProgressImageList.value.size - i - 1).toDouble()).toInt()
                if (_currentGameLevel.value == 2) {
                    _worldCupLevel.value = "결승"
                } else {
                    _worldCupLevel.value = "${_currentGameLevel.intValue}강"
                }

                _currentMatchImages.value = element.toList()

                return
            }
        }
    }

    fun getWinnerImage(): ImageRequest? {
        return _gameProgressImageList.value.last().last().imageRequest
    }

    fun getWinnerName(): String? {
        return _gameProgressImageList.value.last().last().imageEntity.breeds?.last()?.name
    }

    fun getWinnerDescription(): String? {
        return _gameProgressImageList.value.last().last().imageEntity.breeds?.last()?.description
    }

    fun downloadWinnerImage(context: Context, onComplete: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                requestPermission()

                val loader = ImageLoader(context)
                val entity = _gameProgressImageList.value.last().last().imageEntity
                val request = getWinnerImage()?.newBuilder(
                    context = context
                )?.build()

                val result = (request?.let { loader.execute(it) } as SuccessResult).drawable
                val bitmap = (result as BitmapDrawable).bitmap
                val downloadResultFile =
                    saveImageUseCase.downloadImage(bitmap = bitmap, imageEntity = entity)

                downloadResultFile?.let { file ->
                    scanFile(context = context, f = file, onComplete = onComplete)
                }
            } catch (e: Exception) {

            }
        }
    }

    private fun requestPermission() {

    }

    private fun scanFile(context: Context, f: File, onComplete: () -> Unit) {
        MediaScannerConnection.scanFile(
            context,
            arrayOf(f.absolutePath),
            arrayOf("image/*")
        ) { _, _ ->
            onComplete.invoke()
        }
    }
}
