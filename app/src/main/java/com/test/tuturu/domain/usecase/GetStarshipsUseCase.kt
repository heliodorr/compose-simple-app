package com.test.tuturu.domain.usecase

import com.test.tuturu.common.Status
import com.test.tuturu.domain.model.StarshipItem
import com.test.tuturu.domain.repository.NetworkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetStarshipsUseCase(
    val networkRepository: NetworkRepository
) {

    operator fun invoke(): Flow<Status<List<StarshipItem>>> = flow {

        try {
            emit(Status.Loading<List<StarshipItem>>())
            val data = networkRepository.getStarshipItemsList()
            emit(Status.Success(data = data))
        } catch (e: HttpException){
            emit(Status.Error<List<StarshipItem>>("HttpError"))
        } catch (e: IOException) {
            emit(Status.Error<List<StarshipItem>>("IOError"))
        }

    }

}