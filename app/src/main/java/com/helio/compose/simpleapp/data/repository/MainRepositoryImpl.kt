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
        Log.d("AAA", "MainRepositoryImpl/bindRepos")
        when (dataType) {
            DataType.PLANETS -> {

                try {

                    Log.d("AAA", "MainRepositoryImpl/bindReposTRY")


                    val dataList = networkRepository.getPlanetItemsList()

                    val statusList = Status.Success(
                        dataList as List<Item>
                    )

                    cacheRepository.addData(dataType, statusList)

                    Log.d("AAA", "MainRepositoryImpl/bindReposAFTERCACHE")

                    inMemoryRepository.addLastPlanets(dataList)

                    return statusList


                } catch (e: Throwable){
                    Log.d("AAA", "MainRepositoryImpl/${e.toString()}")
                    Log.d("AAA", "MainRepositoryImpl/${e.message}")
                    Log.d("AAA", "MainRepositoryImpl/bindReposCATCH")

                    val dataList = Status.Outdated(
                        inMemoryRepository.getLast(dataType)
                    )

                    cacheRepository.addData(dataType, dataList)

                    return dataList
                }

            }

            DataType.STARSHIPS -> {

                try {
                    Log.d("AAA", "MainRepositoryImpl/bindReposTRY")


                    val dataList = networkRepository.getStarshipItemsList()

                    val statusList = Status.Success(
                        dataList as List<Item>
                    )

                    cacheRepository.addData(dataType, statusList)

                    Log.d("AAA", "MainRepositoryImpl/bindReposAFTERCACHE")

                    inMemoryRepository.addLastStarships(dataList)

                    return statusList

                } catch (e: Throwable){
                    Log.d("AAA", "MainRepositoryImpl/${e.toString()}")
                    Log.d("AAA", "MainRepositoryImpl/${e.message}")
                    Log.d("AAA", "MainRepositoryImpl/bindReposCATCH")


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
        Log.d("AAA", "MainRepositoryImpl/******* CACHE ************")
        if (
            cacheRepository.contains(dataType)
        ){

            val itemsList = cacheRepository.getData(dataType)!!

            Log.d("AAA", "MainRepositoryImpl/ EMITING SUCCESS")

            emit(
                itemsList
            )
        }
        else {
            Log.d("AAA", "MainRepositoryImpl/ EMITING LOADING")
            emit(
                Status.Loading()
            )

            Log.d("AAA", "MainRepositoryImpl/ EMITING DATA")
            emit(
                bindRepos(dataType)
            )

        }

    }


    override fun getRefreshedDataByDataType(dataType: DataType): Flow<StatusData> = flow {
        Log.d("AAA", "MainRepositoryImpl/******* NETWORKING ************")


        Log.d("AAA", "MainRepositoryImpl/ EMITING LOADING")
        emit(
            Status.Loading()
        )

        Log.d("AAA", "MainRepositoryImpl/ EMITING DATA")
        emit(
            bindRepos(dataType)
        )


    }


}

