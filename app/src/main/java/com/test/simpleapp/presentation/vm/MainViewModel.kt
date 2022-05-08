package com.test.simpleapp.presentation.vm

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.simpleapp.domain.common.Status
import com.test.simpleapp.domain.common.StatusData
import com.test.simpleapp.domain.model.DataType
import com.test.simpleapp.domain.model.Item
import com.test.simpleapp.domain.usecase.items.GetDataFlowUseCase
import com.test.simpleapp.domain.usecase.items.GetNavigationDataUseCase
import com.test.simpleapp.domain.usecase.items.GetRefreshedDataUseCase
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.flow.*

class MainViewModel(
    private val getRefreshedDataUseCase: GetRefreshedDataUseCase,
    private val getNavigationDataUseCase: GetNavigationDataUseCase
): ViewModel() {

    private var currentDataType: DataType

    private val _itemState: MutableState<StatusData> = mutableStateOf(Status.Loading())
    val itemState: State<StatusData> = _itemState

    init {
        currentDataType = DataType.PLANETS
        refreshData(currentDataType)
    }


    fun navigationDataChange(dataType: DataType){
        downloadData(dataType, getNavigationDataUseCase)
    }

    fun refreshData(dataType: DataType) {
        downloadData(dataType, getRefreshedDataUseCase)
    }

    fun refresh() {
        downloadData(useCase = getRefreshedDataUseCase)
    }


    private fun downloadData(

        dataType: DataType = currentDataType,

        useCase: GetDataFlowUseCase

    ){
        Log.d("AAA", "MainViewModel/TRYNA TO DOWNLOAD")

        currentDataType = dataType

        useCase(dataType)
            .onEach{ _itemState.value = it}
            .launchIn(viewModelScope)
    }



























































































































































}











