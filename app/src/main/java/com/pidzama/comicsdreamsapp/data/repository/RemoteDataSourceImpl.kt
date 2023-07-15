package com.pidzama.comicsdreamsapp.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.pidzama.comicsdreamsapp.data.local.ComicsDreamsDatabase
import com.pidzama.comicsdreamsapp.data.paging_source.HeroRemoteMediator
import com.pidzama.comicsdreamsapp.data.paging_source.SearchHeroes
import com.pidzama.comicsdreamsapp.data.remote.ComicsDreamsApi
import com.pidzama.comicsdreamsapp.domain.model.Hero
import com.pidzama.comicsdreamsapp.domain.repository.RemoteDataSource
import com.pidzama.comicsdreamsapp.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow

@ExperimentalPagingApi
class RemoteDataSourceImpl(
    private val comicsDreamsApi: ComicsDreamsApi,
    private val comicsDreamsDatabase: ComicsDreamsDatabase
) : RemoteDataSource {

    private val heroDao = comicsDreamsDatabase.heroDao()

    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        val pagingSourceFactory = { heroDao.gelAllHeroes() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = HeroRemoteMediator(
                comicsDreamsApi = comicsDreamsApi,
                comicsDreamsDatabase = comicsDreamsDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchHeroes(query: String): Flow<PagingData<Hero>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                SearchHeroes(
                    comicsDreamsApi = comicsDreamsApi,
                    query = query
                )
            }
        ).flow
    }
}