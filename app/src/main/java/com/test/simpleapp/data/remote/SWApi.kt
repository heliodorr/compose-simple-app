package com.test.simpleapp.data.remote

import com.test.simpleapp.data.remote.model.dto_holders.PlanetDtoHolder
import com.test.simpleapp.data.remote.model.dto_holders.StarshipDtoHolder
import retrofit2.http.GET

interface SWApi {

    @GET("starships/")
    suspend fun getStarshipsHolder(): StarshipDtoHolder

    @GET("planets/")
    suspend fun getPlanetsHolder(): PlanetDtoHolder

}