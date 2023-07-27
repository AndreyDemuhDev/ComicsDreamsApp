package com.pidzama.comicsdreamsapp.data.remote

import com.pidzama.comicsdreamsapp.domain.model.ApiResponse
import com.pidzama.comicsdreamsapp.domain.model.Hero

class FakeComicsDreamsApi : ComicsDreamsApi {

    private val heroes = listOf(
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
            alias = "Wolverine",
            realName = "",
            image = "",
            biography = "",
            position = "",
            height = 1.76,
            power = 89,
            rating = 4.6,
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

    override suspend fun getAllHeroes(page: Int): ApiResponse {
        return ApiResponse(
            success = false
        )
    }

    override suspend fun searchHeroes(name: String): ApiResponse {
        val searchHeroes = findHero(name = name)
        return ApiResponse(
            success = true,
            message = "OK",
            heroes = searchHeroes
        )
    }

    private fun findHero(name: String): List<Hero> {
        val founded = mutableListOf<Hero>()
        return if (name.isNotEmpty()) {
            heroes.forEach { hero ->
                if (hero.alias.lowercase().contains(name.lowercase())) {
                    founded.add(hero)
                }
            }
            founded
        } else {
            emptyList()
        }
    }
}