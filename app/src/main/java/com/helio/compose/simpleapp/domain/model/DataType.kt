package com.helio.compose.simpleapp.domain.model

enum class DataType {
    STARSHIPS,
    PLANETS;

    companion object {
        fun getByValue(value: String): DataType {
            return DataType.values().find { it.name.equals(value) } ?: PLANETS
        }
    }

}