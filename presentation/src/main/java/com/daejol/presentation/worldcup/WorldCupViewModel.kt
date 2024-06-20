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

    fun setLevel(level: String) {
        _worldCupLevel.value = level
    }
}