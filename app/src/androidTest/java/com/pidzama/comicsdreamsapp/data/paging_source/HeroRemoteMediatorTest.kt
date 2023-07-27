package com.pidzama.comicsdreamsapp.data.paging_source

import androidx.paging.*
import androidx.paging.RemoteMediator.*
import androidx.test.core.app.ApplicationProvider
import com.pidzama.comicsdreamsapp.data.local.ComicsDreamsDatabase
import com.pidzama.comicsdreamsapp.data.remote.FakeComicsDreamsApi2
import com.pidzama.comicsdreamsapp.domain.model.Hero
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class HeroRemoteMediatorTest {

    private lateinit var comicsDreamsApi: FakeComicsDreamsApi2
    private lateinit var comicsDreamsDatabase: ComicsDreamsDatabase

    @Before
    fun setup() {
        comicsDreamsApi = FakeComicsDreamsApi2()
        comicsDreamsDatabase = ComicsDreamsDatabase.create(
            context = ApplicationProvider.getApplicationContext(),
            useInMemory = true
        )
    }

    @After
    fun cleanup() {
        comicsDreamsDatabase.clearAllTables()
    }

    @ExperimentalPagingApi
    @Test
    fun refreshLoadReturnsSuccessResultWhenMoreDataIsPresent() =
        runBlocking {
            val remoteMediator = HeroRemoteMediator(
                comicsDreamsApi = comicsDreamsApi,
                comicsDreamsDatabase = comicsDreamsDatabase
            )
            val pagingState = PagingState<Int, Hero>(
                pages = listOf(),
                anchorPosition = null,
                config = PagingConfig(pageSize = 4),
                leadingPlaceholderCount = 0
            )
            val result = remoteMediator.load(LoadType.REFRESH, pagingState)
            assertTrue(result is MediatorResult.Success)
            assertFalse((result as MediatorResult.Success).endOfPaginationReached)
        }

    @ExperimentalPagingApi
    @Test
    fun refreshLoadSuccessAndEndOfPaginationTrueWhenNoMoreData() =
        runBlocking {
            comicsDreamsApi.clearData()
            val remoteMediator = HeroRemoteMediator(
                comicsDreamsApi = comicsDreamsApi,
                comicsDreamsDatabase = comicsDreamsDatabase
            )
            val pagingState = PagingState<Int, Hero>(
                pages = listOf(),
                anchorPosition = null,
                config = PagingConfig(pageSize = 4),
                leadingPlaceholderCount = 0
            )
            val result = remoteMediator.load(LoadType.REFRESH, pagingState)
            assertTrue(result is MediatorResult.Success)
            assertTrue((result as MediatorResult.Success).endOfPaginationReached)
        }

    @ExperimentalPagingApi
    @Test
    fun refreshLoadReturnsErrorResultWhenErrorOccurs() =
        runBlocking {
            comicsDreamsApi.addException()
            val remoteMediator = HeroRemoteMediator(
                comicsDreamsApi = comicsDreamsApi,
                comicsDreamsDatabase = comicsDreamsDatabase
            )
            val pagingState = PagingState<Int, Hero>(
                pages = listOf(),
                anchorPosition = null,
                config = PagingConfig(pageSize = 4),
                leadingPlaceholderCount = 0
            )
            val result = remoteMediator.load(LoadType.REFRESH, pagingState)
            assertTrue(result is MediatorResult.Error)
        }
}