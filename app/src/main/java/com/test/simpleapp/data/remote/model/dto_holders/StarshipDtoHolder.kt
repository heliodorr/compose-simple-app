package com.test.simpleapp.data.remote.model.dto_holders

import com.google.gson.annotations.SerializedName
import com.test.simpleapp.data.remote.model.dto.StarshipItemDto

data class  StarshipDtoHolder (
    @SerializedName("results") val starships: List<StarshipItemDto>
)