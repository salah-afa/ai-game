package com.salahafaghani.aigame.domain.model

enum class GameSubject(val value: String) {
    DATA_STRUCTURE("Data Structure"),
    ALGORITHM("Algorithm");

    companion object {
        fun parse(value: String) = GameSubject.entries.first { it.value == value }
    }
}