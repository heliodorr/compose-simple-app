package com.helio.compose.simpleapp.data.repository

import android.util.Log
import com.test.simpleapp.data.repository.utility.interfaces.CacheRepository
import com.test.simpleapp.data.repository.utility.interfaces.InMemoryRepository
import com.test.simpleapp.data.repository.utility.interfaces.NetworkRepository
import com.helio.compose.simpleapp.domain.common.Status
import com.helio.compose.simpleapp.domain.common.StatusData
import com.helio.compose.simpleapp.domain.model.DataType
import com.helio.compose.simpleapp.domain.model.Item
import com.helio.compose.simpleapp.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepositoryImpl(
    val cacheRepository: CacheRepository,
    val networkRepository: NetworkRepository,
    val inMemoryRepository: InMemoryRepository
): MainRepository {


    private suspend fun bindRepos(dataType: DataType): StatusData {

        when (dataType) {

            DataType.PLANETS -> {

                try {

                    val dataList = networkRepository.getPlanetItemsList()

                    val statusList = Status.Success(
                        dataList as List<Item>
                    )

                    cacheRepository.addData(dataType, statusList)
                    inMemoryRepository.addLastPlanets(dataList)

                    return statusList


                } catch (e: Throwable){

                    val dataList = Status.Outdated(
                        inMemoryRepository.getLast(dataType)
                    )

                    cacheRepository.addData(dataType, dataList)

                    return dataList
                }

            }

            DataType.STARSHIPS -> {

                try {

                    val dataList = networkRepository.getStarshipItemsList()

                    val statusList = Status.Success(
                        dataList as List<Item>
                    )

                    cacheRepository.addData(dataType, statusList)

                    inMemoryRepository.addLastStarships(dataList)

                    return statusList

                } catch (e: Throwable){

                    val dataList = Status.Outdated(
                        inMemoryRepository.getLast(dataType)
                    )

                    cacheRepository.addData(dataType, dataList)

                    return dataList


                }

            }

        }

    }


    override fun getCachedDataByDataType(dataType: DataType): Flow<StatusData> = flow {

        if (
            cacheRepository.contains(dataType)
        ){

            val itemsList = cacheRepository.getData(dataType)!!
            emit(itemsList)

        }
        else {

            emit(Status.Loading())
            emit(bindRepos(dataType))

        }

    }


    override fun getRefreshedDataByDataType(dataType: DataType): Flow<StatusData> = flow {

        emit(Status.Loading())

        emit(bindRepos(dataType))

    }


}

