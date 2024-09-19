package com.daejol.presentation.ui.match

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.daejol.domain.usecase.AnswerData
import com.daejol.domain.usecase.GetImageUseCase
import com.daejol.domain.usecase.GetMatchQuestionUseCase
import com.daejol.domain.usecase.GetMatchResultUseCase
import com.daejol.domain.usecase.MatchData
import com.daejol.domain.usecase.MatchQuestionType
import com.daejol.presentation.model.ImageModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MatchViewModel @Inject constructor(
    private val matchQuestionUseCase: GetMatchQuestionUseCase,
    private val matchResultUseCase: GetMatchResultUseCase
): ViewModel() {
    private val _currentResult = mutableMapOf(
        MatchQuestionType.Extroversion to 0,
        MatchQuestionType.Introversion to 0,
        MatchQuestionType.Curious to 0,
        MatchQuestionType.Stable to 0,
        MatchQuestionType.Affectionate to 0,
        MatchQuestionType.Detached to 0,
        MatchQuestionType.Relaxed to 0,
        MatchQuestionType.Lively to 0
    )
    val currentResult: MutableMap<MatchQuestionType, Int> = _currentResult

    fun init() {
        currentResult.keys.forEach { key ->
            currentResult[key] = 0
        }
    }

    fun getQuestions(): List<MatchData> {
        return matchQuestionUseCase.matchQuestionData
    }

    fun add(answer: AnswerData) {
        currentResult[answer.answerType]?.plus(1)
    }

    fun calculateResult(): String {
        var result = ""
        matchQuestionUseCase.matchPairList.forEach { p ->
            result += if (currentResult[p.first]!! > currentResult[p.second]!!) {
                p.first.char
            } else {
                p.second.char
            }
        }

        return result
    }
}