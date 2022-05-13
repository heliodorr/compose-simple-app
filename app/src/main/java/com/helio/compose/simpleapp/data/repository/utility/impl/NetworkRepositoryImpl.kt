package com.helio.compose.simpleapp.data.repository.utility.impl

import android.util.Log
import com.helio.compose.simpleapp.data.remote.SWApi
import com.test.simpleapp.data.repository.utility.interfaces.NetworkRepository
import com.helio.compose.simpleapp.domain.model.PlanetItem
import com.helio.compose.simpleapp.domain.model.StarshipItem

class NetworkRepositoryImpl(
    private val api: SWApi,
    private val timeoutDuration: Long
): NetworkRepository {


    override suspend fun getStarshipItemsList(): List<StarshipItem> {


        val forReturn = api
            .getStarshipsHolder()
            .starships
            .map { it.toStarshipItem() }

        return forReturn;

    }


    override suspend fun getPlanetItemsList(): List<PlanetItem> {

        val forReturn = api
            .getPlanetsHolder()
            .planets
            .map { it.toPlanetItem() }

        return forReturn

    }


}