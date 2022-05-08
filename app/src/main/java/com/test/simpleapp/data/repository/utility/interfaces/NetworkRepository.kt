package com.test.simpleapp.data.repository.utility.interfaces

import com.test.simpleapp.domain.model.PlanetItem
import com.test.simpleapp.domain.model.StarshipItem
import kotlinx.coroutines.TimeoutCancellationException
import java.util.concurrent.TimeoutException

interface NetworkRepository {


    @Throws(TimeoutCancellationException::class)
    suspend fun getStarshipItemsList(): List<StarshipItem>
    @Throws(TimeoutCancellationException::class)
    suspend fun getPlanetItemsList(): List<PlanetItem>


}