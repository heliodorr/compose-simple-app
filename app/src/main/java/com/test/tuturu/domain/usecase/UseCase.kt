package com.test.tuturu.domain.usecase
import com.test.tuturu.common.Status
import com.test.tuturu.domain.model.Item
import kotlinx.coroutines.flow.Flow

abstract class UseCase {
    abstract val dataType: String
    abstract operator fun invoke(): Flow<Status<List<Item>>>
}