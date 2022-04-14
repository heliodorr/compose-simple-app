package com.test.simpleapp.data.model.dto_holders

import com.google.gson.annotations.SerializedName
import com.test.simpleapp.data.model.dto.StarshipItemDto

data class  StarshipDtoHolder (
    @SerializedName("results")
    val starships: List<StarshipItemDto>
)