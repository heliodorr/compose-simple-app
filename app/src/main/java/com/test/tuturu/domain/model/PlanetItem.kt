package com.test.tuturu.domain.model

import com.google.gson.annotations.SerializedName

data class PlanetItem(
    override val name: String,
    val climate: String,
    val diameter: String,
    val gravity: String,
    val orbitalPeriod: String,
    val population: String,
    val rotationPeriod: String,
    val surfaceWater: String,
    val terrain: String
): Item() {

    override fun toString(): String {
        return "name='$name'" +
                "climate=$climate " +
                "diameter='$diameter', " +
                "gravity='$gravity', " +
                "orbitalPeriod='$orbitalPeriod', " +
                "population='$population', " +
                "rotationPeriod='$rotationPeriod', " +
                "surfaceWater='$surfaceWater', " +
                "terrain='$terrain')"
    }
}
