package com.test.simpleapp.data.remote.model.dto_holders

import com.google.gson.annotations.SerializedName
import com.test.simpleapp.data.remote.model.dto.PlanetItemDto

data class  PlanetDtoHolder (
    @SerializedName("results") val planets: List<PlanetItemDto>
)