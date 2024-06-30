package com.salahafaghani.aigame.domain.repository

import com.salahafaghani.aigame.common.Resource
import com.salahafaghani.aigame.domain.model.GameLevel
import com.salahafaghani.aigame.domain.model.GameQuestion
import com.salahafaghani.aigame.domain.model.GameSubject

interface GameRepository {
    suspend fun getNewGame(subject: GameSubject, level: GameLevel): Resource<List<GameQuestion>>
}