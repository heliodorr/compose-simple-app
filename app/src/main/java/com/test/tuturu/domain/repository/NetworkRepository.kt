package com.test.tuturu.domain.repository

import com.test.tuturu.domain.model.PlanetItem
import com.test.tuturu.domain.model.StarshipItem

interface NetworkRepository {

    suspend fun getStarshipItemsList(): List<StarshipItem>

    suspend fun getPlanetItemsList(): List<PlanetItem>


}