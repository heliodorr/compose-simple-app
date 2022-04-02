package com.test.tuturu.data.api

import com.test.tuturu.data.model.dto_holders.PlanetDtoHolder
import com.test.tuturu.data.model.dto_holders.StarshipDtoHolder
import retrofit2.http.GET

interface SWApi {

    @GET("starships/")
    suspend fun getStarships(): StarshipDtoHolder

    @GET("planets/")
    suspend fun getPlanets(): PlanetDtoHolder



}