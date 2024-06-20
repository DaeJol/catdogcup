package com.daejol.presentation.worldcup

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WorldCupViewModel @Inject constructor(): ViewModel() {
    private val _worldCupLevel = mutableStateOf("16강")
    val worldCupLevel: State<String> = _worldCupLevel

    private val _imageType = mutableStateOf("무작위")
    val imageType: State<String> = _imageType

    private val _bookmark = mutableStateOf(true)
    val bookmark: State<Boolean> = _bookmark

    private val _share = mutableStateOf(true)
    val share: State<Boolean> = _share

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
}