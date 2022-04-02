package com.test.tuturu.data.repository

import com.test.tuturu.data.api.SWApi
import com.test.tuturu.data.model.dto.toPlanetItem
import com.test.tuturu.data.model.dto.toStarshipItem
import com.test.tuturu.domain.model.PlanetItem
import com.test.tuturu.domain.model.StarshipItem
import com.test.tuturu.domain.repository.NetworkRepository

class NetworkRepositoryImpl(
    val api: SWApi
): NetworkRepository {

    override suspend fun getStarshipItemsList(): List<StarshipItem> {
        return api.getStarships().starships
            .map { it.toStarshipItem() }
    }

    override suspend fun getPlanetItemsList(): List<PlanetItem> {
        return api.getPlanets().planets
            .map { it.toPlanetItem() }
    }


}