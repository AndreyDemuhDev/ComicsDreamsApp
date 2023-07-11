package com.pidzama.comicsdreamsapp.data.repository

import com.pidzama.comicsdreamsapp.domain.repository.DataStoreOptions
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataStore: DataStoreOptions
) {

    suspend fun saveOnBoardingState(showed: Boolean) {
        dataStore.saveOnBoardingState(showed = showed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }

}