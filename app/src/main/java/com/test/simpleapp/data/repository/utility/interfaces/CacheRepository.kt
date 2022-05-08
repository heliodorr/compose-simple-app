package com.test.simpleapp.data.repository.utility.interfaces

import com.test.simpleapp.domain.common.StatusData
import com.test.simpleapp.domain.model.DataType
import com.test.simpleapp.domain.model.Item

interface CacheRepository {

    fun getData(dataType: DataType): StatusData?
    fun contains(dataType: DataType): Boolean
    fun addData(dataType: DataType, data: StatusData)
}