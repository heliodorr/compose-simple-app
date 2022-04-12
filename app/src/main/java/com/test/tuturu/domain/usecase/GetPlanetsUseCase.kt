package com.test.tuturu.domain.usecase

import android.util.Log
import com.test.tuturu.common.Status
import com.test.tuturu.domain.model.DataType
import com.test.tuturu.domain.model.Item
import com.test.tuturu.domain.model.PlanetItem
import com.test.tuturu.domain.model.StarshipItem
import com.test.tuturu.domain.repository.NetworkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetPlanetsUseCase(
    val networkRepository: NetworkRepository
): UseCase() {

    override val dataType: String = DataType.PLANETS.name

    override operator fun invoke(): Flow<Status<List<Item>>> = flow {

        try {
            emit(Status.Loading<List<Item>>())
            val data = networkRepository.getPlanetItemsList()
            emit(Status.Success<List<Item>>(data = data))
        } catch (e: HttpException){
            emit(Status.Error<List<Item>>("HttpError"))
        } catch (e: IOException) {
            emit(Status.Error<List<Item>>("IOError"))
        }

    }



}