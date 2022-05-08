package com.test.simpleapp.data.repository.utility.impl

import android.util.Log
import com.test.simpleapp.data.repository.utility.interfaces.CacheRepository
import com.test.simpleapp.domain.common.StatusData
import com.test.simpleapp.domain.model.DataType
import com.test.simpleapp.domain.model.Item



class CacheRepositoryImpl : CacheRepository {



    private val cache: MutableMap<String, StatusData> = mutableMapOf()

    override fun getData(dataType: DataType): StatusData? {
        Log.d("AAAA", "###########EVER CACHEDget???##########")
        return cache[dataType.name]
    }

    override fun contains(dataType: DataType): Boolean{
        Log.d("AAA", "**CACHEREPOSITORY/ ${cache.containsKey(dataType.name)} that contains dataDype ${dataType.name} ")
        return cache.containsKey(dataType.name)
    }

    override fun addData(dataType: DataType, data: StatusData){


        Log.d("AAAA", "###########EVER CACHEDadd???##########")
        cache.put(dataType.name, data)
    }

}