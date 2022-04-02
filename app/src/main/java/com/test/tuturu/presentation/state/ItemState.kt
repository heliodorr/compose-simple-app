package com.test.tuturu.presentation.state

import com.test.tuturu.domain.model.Item

data class ItemState(
    val data: List<Item> = emptyList(),
    var isLoading: Boolean = true
)
