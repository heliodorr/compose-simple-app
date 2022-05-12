package com.helio.compose.simpleapp.domain.usecase.items

import com.helio.compose.simpleapp.domain.common.StatusData
import com.helio.compose.simpleapp.domain.model.DataType
import kotlinx.coroutines.flow.Flow

interface GetDataFlowUseCase {
    operator fun invoke(dataType: DataType): Flow<StatusData>;
}