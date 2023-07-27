package com.pidzama.comicsdreamsapp.presentation.screen.home

import androidx.lifecycle.ViewModel
import com.pidzama.comicsdreamsapp.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    useCases: UseCases
) : ViewModel() {

    val getAllHeroes = useCases.getAllHeroUseCase()
}