package com.test.simpleapp.common

sealed class Status<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : com.test.simpleapp.common.Status<T>(data)
    class Error<T>(message: String, data: T? = null) : com.test.simpleapp.common.Status<T>(data, message)
    class Loading<T>(data: T? = null) : com.test.simpleapp.common.Status<T>(data)
}


