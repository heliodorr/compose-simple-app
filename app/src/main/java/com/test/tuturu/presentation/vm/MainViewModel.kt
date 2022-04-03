package com.test.tuturu.presentation.vm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.tuturu.common.Status
import com.test.tuturu.domain.usecase.GetStarshipsUseCase
import com.test.tuturu.presentation.vm.state.ItemsState
import kotlinx.coroutines.flow.*

class MainViewModel(
    val getStarshipsUseCase: GetStarshipsUseCase
):ViewModel() {

    private val _starshipState = mutableStateOf(ItemsState())
    val itemsState: State<ItemsState> = _starshipState

    init {

            getStarshipsUseCase().onEach { response ->
                when (response) {
                    is Status.Loading -> _starshipState.value = ItemsState()

                    is Status.Success -> _starshipState.value = ItemsState(
                        data = response.data ?: emptyList(),
                        isLoading = false
                    )

                }

            }.launchIn(viewModelScope)


    }








}

