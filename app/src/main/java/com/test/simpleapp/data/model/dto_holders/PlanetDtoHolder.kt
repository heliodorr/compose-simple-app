package com.test.simpleapp.data.model.dto_holders

import com.google.gson.annotations.SerializedName
import com.test.simpleapp.data.model.dto.PlanetItemDto

data class  PlanetDtoHolder (
    @SerializedName("results")
    val planets: List<PlanetItemDto>
)