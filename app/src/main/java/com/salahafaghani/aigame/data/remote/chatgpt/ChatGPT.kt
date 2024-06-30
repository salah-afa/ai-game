package com.salahafaghani.aigame.data.remote.chatgpt

import com.aallam.openai.api.chat.ChatCompletion
import com.aallam.openai.api.chat.ChatCompletionRequest
import com.aallam.openai.api.chat.ChatMessage
import com.aallam.openai.api.chat.ChatResponseFormat
import com.aallam.openai.api.chat.ChatRole
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI
import com.google.gson.Gson
import com.salahafaghani.aigame.BuildConfig
import com.salahafaghani.aigame.common.Constant
import com.salahafaghani.aigame.data.remote.dto.GameQuestionDto
import com.salahafaghani.aigame.data.remote.dto.GameResponseDto
import com.salahafaghani.aigame.domain.model.GameLevel
import com.salahafaghani.aigame.domain.model.GameSubject

class ChatGPT {

    suspend fun getNewGame(subject: GameSubject, level: GameLevel): List<GameQuestionDto> {
        val question = "Give me new ${Constant.NUMBER_OF_QUESTIONS} $level ${subject.value} questions with ${Constant.NUMBER_OF_CHOICES} options for each one and the correct answer with 0-based index. I want them in JSON format with these keys: \"question\", \"answers\", \"correctAnswerIndex\""
        println("question = $question")
        val response = ask(question)
        println("response = $response")
        if (response == null) {
             throw Exception("Not getting response")
        } else {
            return Gson().fromJson(response, GameResponseDto::class.java).questions
        }
    }

    private suspend fun ask(question: String): String? {
        val openAI = OpenAI(BuildConfig.CHATGPT_API_KEY)

        try {
            val chatCompletionRequest = ChatCompletionRequest(
                model = ModelId("gpt-3.5-turbo"),
                responseFormat = ChatResponseFormat.JsonObject,
                messages = listOf(
                    ChatMessage(
                        role = ChatRole.User,
                        content = question
                    )
                )
            )

            val completion: ChatCompletion = openAI.chatCompletion(chatCompletionRequest)

            return completion.choices.first().message.content
        } catch (e: Exception) {
            println("getGPTResponse: ERROR: ${e.message ?: ""}")
            return null
        }
    }

}