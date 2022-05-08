package com.test.simpleapp.data.remote.model.dto

import com.google.gson.annotations.SerializedName
import com.test.simpleapp.data.room.entity.PlanetItemEntity
import com.test.simpleapp.data.room.entity.StarshipItemEntity
import com.test.simpleapp.domain.model.PlanetItem

data class PlanetItemDto(

    @SerializedName("name") val name: String,

    @SerializedName("climate") val climate: String,

    @SerializedName("diameter") val diameter: String,

    @SerializedName("gravity") val gravity: String,

    @SerializedName("orbital_period") val orbitalPeriod: String,
){

    fun toPlanetItem(): PlanetItem {
        return PlanetItem(
            name = name,
            climate = climate,
            diameter = diameter,
            gravity = gravity,
            orbitalPeriod = orbitalPeriod,
        )
    }

    fun toPlanetItemEntity(): PlanetItemEntity {
        return PlanetItemEntity(
            name = name,
            climate = climate,
            diameter = diameter,
            gravity = gravity,
            orbitalPeriod = orbitalPeriod,
        )
    }


}

