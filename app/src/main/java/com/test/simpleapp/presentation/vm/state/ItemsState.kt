package com.test.simpleapp.presentation.vm.state

import com.test.simpleapp.domain.model.Item


data class ItemsState(
    val data: List<Item> = emptyList(),
    var isLoading: Boolean = true
)
