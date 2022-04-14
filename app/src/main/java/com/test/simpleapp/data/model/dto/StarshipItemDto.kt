package com.test.simpleapp.data.model.dto

import com.google.gson.annotations.SerializedName
import com.test.simpleapp.domain.model.StarshipItem


data class StarshipItemDto(
    @SerializedName("cargo_capacity")
    val cargoCapacity: String,
    @SerializedName("consumables")
    val consumables: String,
    @SerializedName("cost_in_credits")
    val costInCredits: String,
    @SerializedName("crew")
    val crew: String,
    @SerializedName("hyperdrive_rating")
    val hyperdriveRating: String,
    @SerializedName("length")
    val length: String,
    @SerializedName("MGLT")
    val mGLT: String,
    @SerializedName("manufacturer")
    val manufacturer: String,
    @SerializedName("max_atmosphering_speed")
    val maxAtmospheringSpeed: String,
    @SerializedName("model")
    val model: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("passengers")
    val passengers: String,
    @SerializedName("starship_class")
    val starshipClass: String
)

fun StarshipItemDto.toStarshipItem(): StarshipItem {
    return StarshipItem(
        name = name,
        cargoCapacity = cargoCapacity,
        costInCredits = costInCredits,
        crew = crew,
        length = length,
        manufacturer = manufacturer,
        model = model,
        passengers = passengers,
        starshipClass = starshipClass
    )
}

