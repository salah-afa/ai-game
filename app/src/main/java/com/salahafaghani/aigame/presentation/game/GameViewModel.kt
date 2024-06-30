package com.salahafaghani.aigame.presentation.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salahafaghani.aigame.common.Constant
import com.salahafaghani.aigame.common.Resource
import com.salahafaghani.aigame.domain.model.GameLevel
import com.salahafaghani.aigame.domain.model.GameQuestion
import com.salahafaghani.aigame.domain.model.GameSubject
import com.salahafaghani.aigame.domain.repository.GameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val repository: GameRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    private var questions: Array<GameQuestion> = emptyArray()
    private var selectedAnswers: Array<Int> = emptyArray()

    val score: Int
        get() {
            var score = 0
            for (i in questions.indices) {
                println("questions[$i].correctAnswerIndex = ${questions[i].correctAnswerIndex}")
                println("selectedAnswers[$i] = ${selectedAnswers[i]}")
                if (questions[i].correctAnswerIndex == selectedAnswers[i]) score++
            }
            println("score = $score")
            return  score
        }

    fun getNewGame(subject: GameSubject, level: GameLevel) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            when (val result = repository.getNewGame(subject, level)) {
                is Resource.Error -> {
                    _uiState.value = _uiState.value.copy(error = result.message, isLoading = false)
                }
                is Resource.Success -> {
                    questions = result.data?.toTypedArray() ?: emptyArray()
                    selectedAnswers = Array(questions.size) { - 1 }
                    _uiState.value = _uiState.value.copy(error = null, isLoading = false)
                    moveToQuestion(1)
                }
            }
        }
    }

    fun selectAnswer(number: Int) {
        selectedAnswers[_uiState.value.questionNumber - 1] = number
        _uiState.value = _uiState.value.copy(currentSelectedAnswer = number)
    }

    fun nextQuestion(onSubmit: () -> Unit) {
        if (_uiState.value.questionNumber == Constant.NUMBER_OF_QUESTIONS) {
            onSubmit()
        } else {
            val questionNumber = _uiState.value.questionNumber + 1
            moveToQuestion(questionNumber)
        }
    }

    fun previousQuestion() {
        val questionNumber = _uiState.value.questionNumber - 1
        moveToQuestion(questionNumber)
    }

    private fun moveToQuestion(number: Int) {
        _uiState.value = _uiState.value.copy(
            questionNumber = number,
            isLastQuestion = number == Constant.NUMBER_OF_QUESTIONS,
            currentQuestion = questions[number - 1].question,
            currentAnswers = questions[number - 1].answers,
            currentSelectedAnswer = selectedAnswers[number - 1]
        )
    }
}