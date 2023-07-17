package com.pidzama.comicsdreamsapp.domain.use_cases.get_selected_hero

import com.pidzama.comicsdreamsapp.data.repository.Repository
import com.pidzama.comicsdreamsapp.domain.model.Hero

class GetSelectedHeroUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(heroId: Int): Hero {
        return repository.getSelectedHero(heroId = heroId)
    }
}