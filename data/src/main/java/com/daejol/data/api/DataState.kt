package com.daejol.data.api

import kotlin.Exception

sealed class DataState<T> (
    val data: T?,
    val exception: Exception? = null
) {
    class Success<T>(data: T?): DataState<T>(data = data)
    class Fail<T>(data: T?, exception: Exception): DataState<T>(data = data, exception = exception)
}