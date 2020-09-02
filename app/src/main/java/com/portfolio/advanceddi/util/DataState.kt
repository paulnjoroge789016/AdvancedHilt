package com.portfolio.advanceddi.util

/**
 * Created by paul on 9/2/2020 at 9:06 PM.
 */
sealed class DataState<out R> {

    data class Success<out T>(val data: T): DataState<T>()

    data class Error(val Exception: Exception): DataState<Nothing>()

    object Loading: DataState<Nothing>()
}