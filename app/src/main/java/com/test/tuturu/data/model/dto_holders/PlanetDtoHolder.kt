package com.test.tuturu.data.model.dto_holders

import com.google.gson.annotations.SerializedName
import com.test.tuturu.data.model.dto.PlanetItemDto

data class  PlanetDtoHolder (
    @SerializedName("results")
    val planets: List<PlanetItemDto>
)