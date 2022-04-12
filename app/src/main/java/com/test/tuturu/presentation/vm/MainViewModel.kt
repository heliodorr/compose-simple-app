package com.test.tuturu.presentation.vm

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.tuturu.common.Status
import com.test.tuturu.domain.model.DataType
import com.test.tuturu.domain.model.Item
import com.test.tuturu.domain.usecase.GetPlanetsUseCase
import com.test.tuturu.domain.usecase.GetStarshipsUseCase
import com.test.tuturu.domain.usecase.UseCase
import com.test.tuturu.presentation.vm.state.ItemsState
import kotlinx.coroutines.flow.*

class MainViewModel(
    private val getStarshipsUseCase: GetStarshipsUseCase,
    private val getPlanetsUseCase: GetPlanetsUseCase
): ViewModel() {

    val cacheMap: MutableMap<String, ItemsState> = mutableMapOf()

    private val _itemState = mutableStateOf(ItemsState())
    val itemState: State<ItemsState> = _itemState





    fun changeData(dataType: String){
        when(dataType){
            DataType.STARSHIPS.name -> {
                downloadData (getStarshipsUseCase)
            }
            DataType.PLANETS.name -> {
                downloadData(getPlanetsUseCase)
            }

        }

    }

    init {
        downloadData (getPlanetsUseCase)
    }

    fun downloadData(
        useCase: UseCase
    ){
        val key = useCase.dataType

        if (cacheMap.containsKey(key)){
            _itemState.value = cacheMap[key]!!
        }
        else{

            useCase().onEach { response ->
                when (response) {
                    is Status.Loading<List<Item>> -> _itemState.value = ItemsState()
                    is Status.Success<List<Item>> -> {

                        val state: ItemsState = ItemsState(
                            data = response.data ?: emptyList(),
                            isLoading = false
                        )

                        cacheMap[key] = state

                        _itemState.value = cacheMap[key]!!

                    }
                }

            }.launchIn(viewModelScope)


        }



    }









}

