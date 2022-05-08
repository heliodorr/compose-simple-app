package com.test.simpleapp.domain.usecase.items

import com.test.simpleapp.domain.common.Status
import com.test.simpleapp.domain.common.StatusData
import com.test.simpleapp.domain.model.DataType
import com.test.simpleapp.domain.model.Item
import com.test.simpleapp.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetRefreshedDataUseCase(
    private val mainRepository: MainRepository
) : GetDataFlowUseCase{

    override operator fun invoke(dataType: DataType): Flow<StatusData> {
        return mainRepository.getRefreshedDataByDataType(dataType)
    }

}