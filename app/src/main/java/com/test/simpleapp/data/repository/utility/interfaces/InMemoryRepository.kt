package com.test.simpleapp.data.repository.utility.interfaces

import com.test.simpleapp.domain.model.DataType
import com.test.simpleapp.domain.model.Item
import com.test.simpleapp.domain.model.PlanetItem
import com.test.simpleapp.domain.model.StarshipItem

interface InMemoryRepository {

    suspend fun getLast(dataType: DataType): List<Item>

    fun addLastPlanets(data: List<PlanetItem>)

    fun addLastStarships(data: List<StarshipItem>)

}