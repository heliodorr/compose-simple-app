package com.helio.compose.simpleapp.domain.usecase.items


import android.util.Log
import com.helio.compose.simpleapp.domain.common.StatusData
import com.helio.compose.simpleapp.domain.model.DataType
import com.helio.compose.simpleapp.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow


class GetNavigationDataUseCase(
    private val mainRepository: MainRepository
) : GetDataFlowUseCase {

    override operator fun invoke(dataType: DataType): Flow<StatusData> {
        Log.d("AAA", "USECASE CACHED DATA/getPlanetItemsList")
        return mainRepository.getCachedDataByDataType(dataType)
    }
}