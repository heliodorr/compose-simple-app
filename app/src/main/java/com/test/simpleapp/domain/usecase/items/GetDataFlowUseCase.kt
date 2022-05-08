package com.test.simpleapp.domain.usecase.items

import com.test.simpleapp.domain.common.Status
import com.test.simpleapp.domain.common.StatusData
import com.test.simpleapp.domain.model.DataType
import com.test.simpleapp.domain.model.Item
import kotlinx.coroutines.flow.Flow

interface GetDataFlowUseCase {
    operator fun invoke(dataType: DataType): Flow<StatusData>;
}