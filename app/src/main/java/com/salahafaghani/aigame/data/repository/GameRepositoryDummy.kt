package com.salahafaghani.aigame.data.repository

import com.salahafaghani.aigame.common.Constant
import com.salahafaghani.aigame.common.Resource
import com.salahafaghani.aigame.data.dummy.Dummy
import com.salahafaghani.aigame.domain.model.GameLevel
import com.salahafaghani.aigame.domain.model.GameQuestion
import com.salahafaghani.aigame.domain.model.GameSubject
import com.salahafaghani.aigame.domain.repository.GameRepository
import kotlinx.coroutines.delay

class GameRepositoryDummy: GameRepository {
    override suspend fun getNewGame(subject: GameSubject, level: GameLevel): Resource<List<GameQuestion>> {
        delay(3000)
        return Resource.Success(
            Dummy.algorithmQuestions.take(Constant.NUMBER_OF_QUESTIONS)
        )
    }
}