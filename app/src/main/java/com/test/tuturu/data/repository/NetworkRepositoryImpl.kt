package com.test.tuturu.data.repository

import com.test.tuturu.data.api.SWApi
import com.test.tuturu.data.model.dto.toPlanetItem
import com.test.tuturu.data.model.dto.toStarshipItem
import com.test.tuturu.domain.model.PlanetItem
import com.test.tuturu.domain.model.StarshipItem
import com.test.tuturu.domain.repository.NetworkRepository

class NetworkRepositoryImpl(
    private val api: SWApi
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