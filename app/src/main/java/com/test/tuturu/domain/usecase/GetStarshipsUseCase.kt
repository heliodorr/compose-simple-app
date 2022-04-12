package com.test.tuturu.domain.usecase

import android.content.ClipData
import com.test.tuturu.common.Status
import com.test.tuturu.domain.model.DataType
import com.test.tuturu.domain.model.Item
import com.test.tuturu.domain.model.StarshipItem
import com.test.tuturu.domain.repository.NetworkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetStarshipsUseCase(
    val networkRepository: NetworkRepository
): UseCase() {

    override val dataType: String = DataType.STARSHIPS.name

    override operator fun invoke(): Flow<Status<List<Item>>> = flow {

        try {
            emit(Status.Loading<List<Item>>())
            val data = networkRepository.getStarshipItemsList()
            emit(Status.Success<List<Item>>(data = data))
        } catch (e: HttpException){
            emit(Status.Error<List<Item>>("HttpError"))
        } catch (e: IOException) {
            emit(Status.Error<List<Item>>("IOError"))
        }

    }

}