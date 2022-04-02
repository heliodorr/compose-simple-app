package com.test.tuturu.data.model.dto_holders

import com.google.gson.annotations.SerializedName
import com.test.tuturu.data.model.dto.StarshipItemDto

data class  StarshipDtoHolder (
    @SerializedName("results")
    val starships: List<StarshipItemDto>
)