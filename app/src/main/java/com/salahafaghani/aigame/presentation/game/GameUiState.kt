package com.salahafaghani.aigame.presentation.game

import com.salahafaghani.aigame.common.Constant

data class GameUiState(
    var error: String? = null,
    var isLoading: Boolean = false,

    var isLastQuestion: Boolean = false,
    var questionNumber: Int = 1,
    var currentQuestion: String = "",
    var currentAnswers: List<String> = Array(Constant.NUMBER_OF_CHOICES) { "" }.toList(),
    var currentSelectedAnswer: Int = -1
)