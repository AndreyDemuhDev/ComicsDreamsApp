package com.pidzama.comicsdreamsapp.data.repository

import com.pidzama.comicsdreamsapp.data.local.ComicsDreamsDatabase
import com.pidzama.comicsdreamsapp.domain.model.Hero
import com.pidzama.comicsdreamsapp.domain.repository.LocalDataSource

class LocalDataSourceImpl(
    comicsDreamsDatabase: ComicsDreamsDatabase
) : LocalDataSource {

    private val heroDao = comicsDreamsDatabase.heroDao()

    override suspend fun getSelectedHero(heroId: Int): Hero {
        return heroDao.getCurrentHero(id = heroId)
    }
}