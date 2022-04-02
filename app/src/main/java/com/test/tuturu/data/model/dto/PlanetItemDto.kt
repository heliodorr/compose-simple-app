package com.test.tuturu.data.model.dto


import com.google.gson.annotations.SerializedName
import com.test.tuturu.domain.model.PlanetItem

data class PlanetItemDto(
    @SerializedName("climate")
    val climate: String,
    @SerializedName("diameter")
    val diameter: String,
    @SerializedName("gravity")
    val gravity: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("orbital_period")
    val orbitalPeriod: String,
    @SerializedName("population")
    val population: String,
    @SerializedName("rotation_period")
    val rotationPeriod: String,
    @SerializedName("surface_water")
    val surfaceWater: String,
    @SerializedName("terrain")
    val terrain: String
)

fun PlanetItemDto.toPlanetItem(): PlanetItem {
    return PlanetItem(
        name = name,
        climate = climate,
        diameter = diameter,
        gravity = gravity,
        orbitalPeriod = orbitalPeriod,
        population = population,
        rotationPeriod = rotationPeriod,
        surfaceWater = surfaceWater,
        terrain = terrain
    )
}