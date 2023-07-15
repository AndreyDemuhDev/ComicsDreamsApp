package com.pidzama.comicsdreamsapp.domain.use_cases.search_heroes

import androidx.paging.PagingData
import com.pidzama.comicsdreamsapp.data.repository.Repository
import com.pidzama.comicsdreamsapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class SearchHeroesUseCase(
    private val repository: Repository
) {

    operator fun invoke(query: String): Flow<PagingData<Hero>> {
        return repository.searchHeroes(query = query)
    }
}