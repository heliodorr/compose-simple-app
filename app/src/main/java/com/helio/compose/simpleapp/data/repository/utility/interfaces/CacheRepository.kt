package com.test.simpleapp.data.repository.utility.interfaces

import com.helio.compose.simpleapp.domain.common.StatusData
import com.helio.compose.simpleapp.domain.model.DataType

interface CacheRepository {

    fun getData(dataType: DataType): StatusData?
    fun contains(dataType: DataType): Boolean
    fun addData(dataType: DataType, data: StatusData)
}