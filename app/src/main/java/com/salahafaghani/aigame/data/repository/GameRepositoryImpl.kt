package com.salahafaghani.aigame.data.repository

import com.salahafaghani.aigame.common.Resource
import com.salahafaghani.aigame.common.apiCall
import com.salahafaghani.aigame.data.remote.chatgpt.ChatGPT
import com.salahafaghani.aigame.domain.model.GameLevel
import com.salahafaghani.aigame.domain.model.GameQuestion
import com.salahafaghani.aigame.domain.model.GameSubject
import com.salahafaghani.aigame.domain.repository.GameRepository
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    private val chatGPT: ChatGPT
): GameRepository {
    override suspend fun getNewGame(subject: GameSubject, level: GameLevel): Resource<List<GameQuestion>> {
        return apiCall { chatGPT.getNewGame(subject, level).map { it.toGameQuestion() } }
    }
}