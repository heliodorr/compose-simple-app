package com.helio.compose.simpleapp.data.remote.model.dto

import com.google.gson.annotations.SerializedName
import com.helio.compose.simpleapp.data.room.entity.PlanetItemEntity
import com.helio.compose.simpleapp.domain.model.PlanetItem

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

