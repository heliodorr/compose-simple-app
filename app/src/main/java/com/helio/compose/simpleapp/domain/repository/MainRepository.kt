package com.helio.compose.simpleapp.domain.repository

import com.helio.compose.simpleapp.domain.common.StatusData
import com.helio.compose.simpleapp.domain.model.DataType
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun getCachedDataByDataType(dataType: DataType): Flow<StatusData>

    fun getRefreshedDataByDataType(dataType: DataType): Flow<StatusData>


}