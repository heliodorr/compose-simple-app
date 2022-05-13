package com.helio.compose.simpleapp.data.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.helio.compose.simpleapp.data.room.dao.ItemsDao
import com.helio.compose.simpleapp.data.room.entity.PlanetItemEntity
import com.helio.compose.simpleapp.data.room.entity.StarshipItemEntity

@Database(
    version = 1 ,
    entities = [PlanetItemEntity::class, StarshipItemEntity::class]
)
abstract class LocalStorageDB: RoomDatabase() {

    abstract fun getItemsDao(): ItemsDao

}