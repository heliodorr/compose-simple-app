package com.test.simpleapp.data.repository

import com.test.simpleapp.data.model.dto.toPlanetItem
import com.test.simpleapp.data.model.dto.toStarshipItem
import com.test.simpleapp.domain.model.PlanetItem
import com.test.simpleapp.domain.model.StarshipItem
import com.test.simpleapp.domain.repository.NetworkRepository

class NetworkRepositoryImpl(
    private val api: com.test.simpleapp.data.api.SWApi
): NetworkRepository {

    override suspend fun getStarshipItemsList(): List<StarshipItem> {
        return api.getStarshipsHolder()
            .starships
            .map { it.toStarshipItem() }
    }

    override suspend fun getPlanetItemsList(): List<PlanetItem> {
        return api.getPlanetsHolder()
            .planets
            .map { it.toPlanetItem() }
    }


}