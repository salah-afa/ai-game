package com.salahafaghani.aigame.domain.model

enum class GameLevel(val value: Int) {
    EASY(1),
    MEDIUM(2),
    HARD(3);

    companion object {
        fun parse(value: Int) = entries.first { it.value == value }
    }

    override fun toString(): String {
        return when(value) {
            1 -> "entry-level"
            2 -> "medium-level"
            3 -> "advanced-level"
            else -> "entry-level"
        }
    }
}