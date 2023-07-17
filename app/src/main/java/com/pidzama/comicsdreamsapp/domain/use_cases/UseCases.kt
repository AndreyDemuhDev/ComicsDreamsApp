package com.pidzama.comicsdreamsapp.domain.use_cases

import com.pidzama.comicsdreamsapp.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.pidzama.comicsdreamsapp.domain.use_cases.get_selected_hero.GetSelectedHeroUseCase
import com.pidzama.comicsdreamsapp.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.pidzama.comicsdreamsapp.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import com.pidzama.comicsdreamsapp.domain.use_cases.search_heroes.SearchHeroesUseCase

data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
    val getAllHeroUseCase: GetAllHeroesUseCase,
    val searchHeroUseCase: SearchHeroesUseCase,
    val getSelectedHeroUseCase: GetSelectedHeroUseCase
)