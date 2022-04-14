package com.test.simpleapp.domain.usecase

import com.test.simpleapp.domain.model.Item
import kotlinx.coroutines.flow.Flow

abstract class UseCase {
    abstract val dataType: String
    abstract operator fun invoke(): Flow<com.test.simpleapp.common.Status<List<Item>>>
}