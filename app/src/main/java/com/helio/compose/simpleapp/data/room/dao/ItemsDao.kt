package com.helio.compose.simpleapp.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.helio.compose.simpleapp.data.room.entity.PlanetItemEntity
import com.helio.compose.simpleapp.data.room.entity.StarshipItemEntity

@Dao
abstract class ItemsDao {

    @Query("SELECT * FROM planets")
    abstract suspend fun getPlanets(): List<PlanetItemEntity>?

    @Query("SELECT * FROM starships")
    abstract suspend fun getStarships(): List<StarshipItemEntity>?



    @Query("DELETE FROM planets")
    protected abstract suspend fun clearPlanets();

    @Query("DELETE FROM starships")
    protected abstract suspend fun clearStarships();



    @Insert
    protected abstract suspend fun insertPlanets(planets: List<PlanetItemEntity>);

    @Insert
    protected abstract suspend fun insertStarships(starships: List<StarshipItemEntity>);



    @Transaction
    open suspend fun refreshPlanets(planets: List<PlanetItemEntity>){
        clearPlanets()
        insertPlanets(planets)

    }

    @Transaction
    open suspend fun refreshStarships(starships: List<StarshipItemEntity>){
        clearStarships()
        insertStarships(starships)
    }


}