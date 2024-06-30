package com.salahafaghani.aigame.di

import com.salahafaghani.aigame.data.remote.chatgpt.ChatGPT
import com.salahafaghani.aigame.data.repository.GameRepositoryDummy
import com.salahafaghani.aigame.data.repository.GameRepositoryImpl
import com.salahafaghani.aigame.domain.repository.GameRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideChatGPT(): ChatGPT {
        return ChatGPT()
    }

    @Provides
    @Singleton
    fun provideGameRepository(chatGPT: ChatGPT): GameRepository {
        return GameRepositoryImpl(chatGPT)
//        return  GameRepositoryDummy()
    }
}