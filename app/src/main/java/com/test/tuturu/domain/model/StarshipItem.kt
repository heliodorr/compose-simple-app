package com.test.tuturu.domain.model

import com.google.gson.annotations.SerializedName

data class StarshipItem(
    override val name: String,
    val model: String,
    val manufacturer: String,
    val length: String,
    val costInCredits: String,
    val crew: String,
    val passengers: String,
    val starshipClass: String,
    val cargoCapacity: String
) : Item() {

    override fun toString(): String {
        return "Name: $name\n" +
                "Model: $model\n" +
                "Manufacturer $manufacturer\n" +
                "Length: $length\n" +
                "CostInCredits $costInCredits\n" +
                "Crew: $crew\n" +
                "Passengers: $passengers\n" +
                "StarshipClass: $starshipClass\n" +
                "CargoCapacity: $cargoCapacity"
    }
}
