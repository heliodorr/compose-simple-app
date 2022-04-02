package com.test.tuturu.presentation.vm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.tuturu.common.Status
import com.test.tuturu.domain.usecase.GetStarshipsUseCase
import com.test.tuturu.presentation.state.ItemState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel(
    val getStarshipsUseCase: GetStarshipsUseCase
):ViewModel() {

    private val _starshipState = mutableStateOf(ItemState())
    val itemState: State<ItemState> = _starshipState

    init {

            getStarshipsUseCase().onEach { response ->
                when (response) {
                    is Status.Loading -> _starshipState.value = ItemState()

                    is Status.Success -> _starshipState.value = ItemState(
                        data = response.data ?: emptyList(),
                        isLoading = false
                    )

                }

            }.launchIn(viewModelScope)


    }








}

