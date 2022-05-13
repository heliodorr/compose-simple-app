package com.helio.compose.simpleapp.data.repository.utility.impl

import android.util.Log
import com.test.simpleapp.data.repository.utility.interfaces.CacheRepository
import com.helio.compose.simpleapp.domain.common.StatusData
import com.helio.compose.simpleapp.domain.model.DataType


class CacheRepositoryImpl : CacheRepository {



    private val cache: MutableMap<String, StatusData> = mutableMapOf()

    override fun getData(dataType: DataType): StatusData? {

        return cache[dataType.name]
    }

    override fun contains(dataType: DataType): Boolean{

        return cache.containsKey(dataType.name)
    }

    override fun addData(dataType: DataType, data: StatusData){

        cache.put(dataType.name, data)
    }

}