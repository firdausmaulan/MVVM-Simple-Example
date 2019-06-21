package com.firdaus.example.dataSource.remote

// Required for Unit Test
interface RepositoryCallback<T> {
    fun onDataLoaded(response: T)
    fun onDataError(error: String?)
}