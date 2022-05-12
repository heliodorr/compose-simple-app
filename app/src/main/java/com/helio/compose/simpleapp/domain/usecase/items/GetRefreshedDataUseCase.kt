package com.helio.compose.simpleapp.domain.usecase.items

import com.helio.compose.simpleapp.domain.common.StatusData
import com.helio.compose.simpleapp.domain.model.DataType
import com.helio.compose.simpleapp.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow

class GetRefreshedDataUseCase(
    private val mainRepository: MainRepository
) : GetDataFlowUseCase {

    override operator fun invoke(dataType: DataType): Flow<StatusData> {

        return mainRepository.getRefreshedDataByDataType(dataType)

    }

}