package com.pidzama.comicsdreamsapp.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreOptions {

    suspend fun saveOnBoardingState(showed: Boolean)
    fun readOnBoardingState(): Flow<Boolean>
}