package com.salahafaghani.aigame.common

import retrofit2.HttpException
import java.io.IOException

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
}

suspend fun <T> apiCall(apiCall: suspend () -> T): Resource<T> {
    return try {
        Resource.Success(apiCall.invoke())
    } catch (throwable: Throwable) {
        when (throwable) {
            is IOException -> Resource.Error(throwable.message!!)
            is HttpException -> Resource.Error(throwable.message!!)
            else -> {
                println(throwable.stackTraceToString())
                println(throwable.localizedMessage ?: "localizedMessage is null")
                println(throwable.message ?: "message is null")
                Resource.Error("Unknown error!")
            }
        }
    }
}