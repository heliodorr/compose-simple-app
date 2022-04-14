package com.test.simpleapp.domain.usecase

import com.test.simpleapp.domain.model.DataType
import com.test.simpleapp.domain.model.Item
import com.test.simpleapp.domain.repository.NetworkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetStarshipsUseCase(
    val networkRepository: NetworkRepository
): UseCase() {

    override val dataType: String = DataType.STARSHIPS.name

    override operator fun invoke(): Flow<com.test.simpleapp.common.Status<List<Item>>> = flow {

        try {
            emit(com.test.simpleapp.common.Status.Loading<List<Item>>())
            val data = networkRepository.getStarshipItemsList()
            emit(com.test.simpleapp.common.Status.Success<List<Item>>(data = data))
        } catch (e: HttpException){
            emit(com.test.simpleapp.common.Status.Error<List<Item>>("HttpError"))
        } catch (e: IOException) {
            emit(com.test.simpleapp.common.Status.Error<List<Item>>("IOError"))
        }

    }

}