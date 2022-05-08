package com.test.simpleapp.domain.common

import androidx.compose.ui.graphics.Color
import com.test.simpleapp.domain.model.Item

typealias StatusData = Status<List<Item>>

sealed class Status<T>(
    val data: T? = null,
    val message: String? = null,
    val color: Color = Color.Black
) {
    class Success<T>(data: T) : Status<T>(data)

    class Outdated<T>(data: T): Status<T>(
        data,
        color = Color.LightGray
    )

    class Error<T>(): Status<T>(
        color = Color.LightGray
    )

    class Loading<T>(): Status<T>()
}


