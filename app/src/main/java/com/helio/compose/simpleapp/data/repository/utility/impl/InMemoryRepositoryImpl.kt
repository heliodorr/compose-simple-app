package com.helio.compose.simpleapp.data.repository.utility.impl


import android.util.Log
import com.test.simpleapp.data.repository.utility.interfaces.InMemoryRepository
import com.helio.compose.simpleapp.data.room.dao.ItemsDao
import com.helio.compose.simpleapp.data.room.entity.PlanetItemEntity
import com.helio.compose.simpleapp.data.room.entity.StarshipItemEntity
import com.helio.compose.simpleapp.domain.model.DataType
import com.helio.compose.simpleapp.domain.model.Item
import com.helio.compose.simpleapp.domain.model.PlanetItem
import com.helio.compose.simpleapp.domain.model.StarshipItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class InMemoryRepositoryImpl(
    private val dao: ItemsDao
) : InMemoryRepository {

    override suspend fun getLast(dataType: DataType): List<Item> {

        var answer: List<Item>? = null

        when(true) {
            dataType == DataType.PLANETS -> {
                answer = dao.getPlanets()?.map { it.toPlanetItem() }
            }

            dataType == DataType.STARSHIPS -> {
                answer = dao.getStarships()?.map { it.toStarshipItem() }
            }
        }

        return answer ?: emptyList()

    }

    override fun addLastStarships(data: List<StarshipItem>) {

        GlobalScope.launch(Dispatchers.IO) {
            Log.d("AAA", "InMemoryRepositoryImpl/ST")
            dao.refreshStarships( data.map { StarshipItemEntity(it) } )
        }

    }

    override fun addLastPlanets(data: List<PlanetItem>) {

        GlobalScope.launch(Dispatchers.IO) {
            Log.d("AAA", "InMemoryRepositoryImpl/ST")
            dao.refreshPlanets( data.map { PlanetItemEntity(it) } )
        }
    }


}