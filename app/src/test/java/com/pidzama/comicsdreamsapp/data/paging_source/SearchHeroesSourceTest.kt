package com.pidzama.comicsdreamsapp.data.paging_source

import androidx.paging.PagingSource.*
import com.pidzama.comicsdreamsapp.data.remote.ComicsDreamsApi
import com.pidzama.comicsdreamsapp.data.remote.FakeComicsDreamsApi
import com.pidzama.comicsdreamsapp.domain.model.Hero
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SearchHeroesSourceTest {

    private lateinit var comicsDreamsApi: ComicsDreamsApi
    private lateinit var heroes: List<Hero>

    @Before
    fun setup() {
        comicsDreamsApi = FakeComicsDreamsApi()
        heroes = listOf(
            Hero(
                id = 1,
                alias = "Batman",
                realName = "",
                image = "",
                biography = "",
                position = "",
                height = 1.88,
                power = 95,
                rating = 4.8,
                allies = listOf(),
                enemies = listOf(),
                publisher = ""
            ),
            Hero(
                id = 2,
                alias = "Spider-Man",
                realName = "",
                image = "",
                biography = "",
                position = "",
                height = 1.72,
                power = 75,
                rating = 4.9,
                allies = listOf(),
                enemies = listOf(),
                publisher = ""
            ),
            Hero(
                id = 3,
                alias = "Carnage",
                realName = "",
                image = "",
                biography = "",
                position = "",
                height = 1.88,
                power = 86,
                rating = 3.8,
                allies = listOf(),
                enemies = listOf(),
                publisher = ""
            ),
            Hero(
                id = 4,
                alias = "Jocker",
                realName = "",
                image = "",
                biography = "",
                position = "",
                height = 1.95,
                power = 87,
                rating = 4.6,
                allies = listOf(),
                enemies = listOf(),
                publisher = ""
            )
        )
    }

    @Test
    fun `Search api hero name, expect single hero result, assert LoadResult_Page`() =
        runTest {
            val heroSource = SearchHeroes(comicsDreamsApi = comicsDreamsApi, query = "Batman")
            assertEquals<LoadResult<Int, Hero>>(
                expected = LoadResult.Page(
                    data = listOf(heroes.first()),
                    prevKey = null,
                    nextKey = null
                ),
                actual = heroSource.load(
                    LoadParams.Refresh(
                        key = null,
                        loadSize = 4,
                        placeholdersEnabled = false
                    )
                )
            )
        }

    @Test
    fun `Search api hero name, expect several hero result, assert LoadResult_Page`() =
        runTest {
            val heroSource = SearchHeroes(comicsDreamsApi = comicsDreamsApi, query = "Man")
            assertEquals<LoadResult<Int, Hero>>(
                expected = LoadResult.Page(
                    data = listOf(heroes.first(), heroes[1]),
                    prevKey = null,
                    nextKey = null
                ),
                actual = heroSource.load(
                    LoadParams.Refresh(
                        key = null,
                        loadSize = 4,
                        placeholdersEnabled = false
                    )
                )
            )
        }

    @Test
    fun `Search api empty hero name, assert empty heroes list and LoadResult_Page`() =
        runTest {
            val heroSource = SearchHeroes(comicsDreamsApi = comicsDreamsApi, query = "")
            val loadResult = heroSource.load(
                LoadParams.Refresh(
                    key = null,
                    loadSize = 4,
                    placeholdersEnabled = false
                )
            )
            val result = comicsDreamsApi.searchHeroes("").heroes
            assertTrue { result.isEmpty() }
            assertTrue { loadResult is LoadResult.Page }
        }

    @Test
    fun `Search api non_existing hero name, assert empty heroes list and LoadResult_Page`() =
        runTest {
            val heroSource = SearchHeroes(comicsDreamsApi = comicsDreamsApi, query = "Unknown")
            val loadResult = heroSource.load(
                LoadParams.Refresh(
                    key = null,
                    loadSize = 4,
                    placeholdersEnabled = false
                )
            )
            val result = comicsDreamsApi.searchHeroes("Unknown").heroes
            assertTrue { result.isEmpty() }
            assertTrue { loadResult is LoadResult.Page }
        }
}