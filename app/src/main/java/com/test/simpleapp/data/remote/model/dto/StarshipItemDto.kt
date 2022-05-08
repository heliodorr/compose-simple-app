package com.test.simpleapp.data.remote.model.dto

import com.google.gson.annotations.SerializedName
import com.test.simpleapp.data.room.entity.StarshipItemEntity
import com.test.simpleapp.domain.model.StarshipItem


data class StarshipItemDto(

    @SerializedName("name") val name: String,

    @SerializedName("model") val model: String,

    @SerializedName("manufacturer") val manufacturer: String,

    @SerializedName("length") val length: String,

    @SerializedName("cost_in_credits") val costInCredits: String,

){
    fun toStarshipItem(): StarshipItem {
        return StarshipItem(
            name = name,
            costInCredits = costInCredits,
            length = length,
            manufacturer = manufacturer,
            model = model,
        )
    }

    fun toStarshipItemEntity(): StarshipItemEntity {
        return StarshipItemEntity(
            name = name,
            costInCredits = costInCredits,
            length = length,
            manufacturer = manufacturer,
            model = model,
        )
    }

}

