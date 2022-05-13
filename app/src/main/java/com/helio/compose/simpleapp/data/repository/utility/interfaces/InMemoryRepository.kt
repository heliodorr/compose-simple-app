package com.test.simpleapp.data.repository.utility.interfaces

import com.helio.compose.simpleapp.domain.model.DataType
import com.helio.compose.simpleapp.domain.model.Item
import com.helio.compose.simpleapp.domain.model.PlanetItem
import com.helio.compose.simpleapp.domain.model.StarshipItem

interface InMemoryRepository {

    suspend fun getLast(dataType: DataType): List<Item>

    fun addLastPlanets(data: List<PlanetItem>)

    fun addLastStarships(data: List<StarshipItem>)

}