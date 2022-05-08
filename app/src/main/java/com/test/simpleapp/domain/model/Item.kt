package com.test.simpleapp.domain.model

abstract class Item{
    abstract val name: String
    abstract val details: List<Pair<String, String>>
    abstract fun getDataType(): DataType
}