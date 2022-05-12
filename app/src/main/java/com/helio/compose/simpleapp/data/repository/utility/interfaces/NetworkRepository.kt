package com.test.simpleapp.data.repository.utility.interfaces

import com.helio.compose.simpleapp.domain.model.PlanetItem
import com.helio.compose.simpleapp.domain.model.StarshipItem
import kotlinx.coroutines.TimeoutCancellationException

interface NetworkRepository {


    @Throws(TimeoutCancellationException::class)
    suspend fun getStarshipItemsList(): List<StarshipItem>
    @Throws(TimeoutCancellationException::class)
    suspend fun getPlanetItemsList(): List<PlanetItem>


}