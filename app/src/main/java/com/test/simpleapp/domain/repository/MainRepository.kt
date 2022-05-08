package com.test.simpleapp.domain.repository

import com.test.simpleapp.domain.common.StatusData
import com.test.simpleapp.domain.model.DataType
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun getCachedDataByDataType(dataType: DataType): Flow<StatusData>

    fun getRefreshedDataByDataType(dataType: DataType): Flow<StatusData>


}