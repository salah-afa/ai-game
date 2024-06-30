package com.salahafaghani.aigame.data.remote.dto

import com.salahafaghani.aigame.domain.model.GameQuestion

data class GameQuestionDto (
    val question: String,
    val answers: List<String>,
    val correctAnswerIndex: Int
) {
    fun toGameQuestion(): GameQuestion {
        return GameQuestion(
            question = question,
            answers =  answers,
            correctAnswerIndex = correctAnswerIndex
        )
    }
}