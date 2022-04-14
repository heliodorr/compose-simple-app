package com.test.simpleapp.domain.repository

import com.test.simpleapp.domain.model.PlanetItem
import com.test.simpleapp.domain.model.StarshipItem

interface NetworkRepository {


    suspend fun getStarshipItemsList(): List<StarshipItem>

    suspend fun getPlanetItemsList(): List<PlanetItem>


}