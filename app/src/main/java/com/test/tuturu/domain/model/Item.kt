package com.test.tuturu.domain.model

import android.provider.ContactsContract

abstract class Item{
    abstract val name: String
    abstract val data: List<Pair<String, String>>
    abstract fun getDataType(): DataType
}