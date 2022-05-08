package com.test.simpleapp.data.repository.utility.impl

import android.util.Log
import com.test.simpleapp.data.remote.SWApi
import com.test.simpleapp.data.repository.utility.interfaces.NetworkRepository
import com.test.simpleapp.domain.model.PlanetItem
import com.test.simpleapp.domain.model.StarshipItem

class NetworkRepositoryImpl(
    private val api: SWApi,
    private val timeoutDuration: Long
): NetworkRepository {


    override suspend fun getStarshipItemsList(): List<StarshipItem> {

        Log.d("AAA", "NetworkRepositoryImpl/getStarshipItemsList")
        val forReturn = api
            .getStarshipsHolder()
            .starships
            .map {
                Log.d("AAA", "1************************************************")
                it.toStarshipItem()
            }

        Log.d("AAA", "2************************************************")

        return forReturn;

    }


    override suspend fun getPlanetItemsList(): List<PlanetItem> {

        Log.d("AAA", "NetworkRepositoryImpl/getPlanetItemsList")

        val forReturn = api
            .getPlanetsHolder()
            .planets
            .map {
                Log.d("AAA", "*** inside mapper")
                it.toPlanetItem()
            }

        Log.d("AAA", "NetworkRepositoryImpl/getPlanetItemsList *** after with timeout")
        return forReturn

    }


}