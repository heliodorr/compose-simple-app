package com.test.tuturu.presentation.vm.state

import com.test.tuturu.domain.model.Item

data class ItemsState(
    val data: List<Item> = emptyList(),
    var isLoading: Boolean = true
)
