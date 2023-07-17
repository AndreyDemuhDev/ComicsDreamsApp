package com.pidzama.comicsdreamsapp.data.repository

import androidx.paging.PagingData
import com.pidzama.comicsdreamsapp.domain.model.Hero
import com.pidzama.comicsdreamsapp.domain.repository.DataStoreOptions
import com.pidzama.comicsdreamsapp.domain.repository.LocalDataSource
import com.pidzama.comicsdreamsapp.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remote: RemoteDataSource,
    private val dataStore: DataStoreOptions,
    private val local: LocalDataSource
) {

    fun getAllHeroes(): Flow<PagingData<Hero>> {
        return remote.getAllHeroes()
    }

    suspend fun saveOnBoardingState(showed: Boolean) {
        dataStore.saveOnBoardingState(showed = showed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }

    fun searchHeroes(query: String): Flow<PagingData<Hero>> {
        return remote.searchHeroes(query = query)
    }

    suspend fun getSelectedHero(heroId: Int): Hero {
        return local.getSelectedHero(heroId = heroId)
    }
}