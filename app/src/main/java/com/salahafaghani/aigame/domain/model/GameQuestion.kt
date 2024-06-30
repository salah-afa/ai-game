package com.salahafaghani.aigame.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class GameQuestion (
    val question: String,
    val answers: List<String>,
    val correctAnswerIndex: Int
): Parcelable