package com.pidzama.comicsdreamsapp.domain.use_cases.get_all_heroes

import androidx.paging.PagingData
import com.pidzama.comicsdreamsapp.data.repository.Repository
import com.pidzama.comicsdreamsapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class GetAllHeroesUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<PagingData<Hero>>{
        return repository.getAllHeroes()
    }

}