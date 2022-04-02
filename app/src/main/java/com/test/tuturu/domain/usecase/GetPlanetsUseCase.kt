package com.test.tuturu.domain.usecase

import com.test.tuturu.common.Status
import com.test.tuturu.domain.model.PlanetItem
import com.test.tuturu.domain.repository.NetworkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetPlanetsUseCase(
    val networkRepository: NetworkRepository
) {

    operator fun invoke(): Flow<Status<List<PlanetItem>>> = flow {

        try {
            emit(Status.Loading<List<PlanetItem>>())
            val data = networkRepository.getPlanetItemsList()
            emit(Status.Success(data = data))
        } catch (e: HttpException){
            emit(Status.Error<List<PlanetItem>>("HttpError"))
        } catch (e: IOException) {
            emit(Status.Error<List<PlanetItem>>("IOError"))
        }

    }



}