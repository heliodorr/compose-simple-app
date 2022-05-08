package com.test.simpleapp.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.test.simpleapp.domain.model.PlanetItem

@Entity(
    tableName = "planets",
)
data class PlanetItemEntity(

    @PrimaryKey(autoGenerate = true) val id: Long = 0L,

    val name: String,

    val climate: String,

    val diameter: String,

    val gravity: String,

    @ColumnInfo(name = "orbital_period")
    val orbitalPeriod: String,

){

    constructor(planetItem: PlanetItem): this(
        name = planetItem.name,
        climate = planetItem.climate,
        diameter = planetItem.diameter,
        gravity = planetItem.gravity,
        orbitalPeriod = planetItem.orbitalPeriod,
    )

    fun toPlanetItem(): PlanetItem {
        return PlanetItem(
            name = name,
            climate = climate,
            diameter = diameter,
            gravity = gravity,
            orbitalPeriod = orbitalPeriod,
        )
    }



}

