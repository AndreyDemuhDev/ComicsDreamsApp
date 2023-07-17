package com.pidzama.comicsdreamsapp.domain.repository

import com.pidzama.comicsdreamsapp.domain.model.Hero

interface LocalDataSource {
    suspend fun getSelectedHero(heroId: Int): Hero
}