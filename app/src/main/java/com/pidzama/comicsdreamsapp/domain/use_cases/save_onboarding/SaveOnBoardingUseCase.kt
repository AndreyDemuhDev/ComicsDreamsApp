package com.pidzama.comicsdreamsapp.domain.use_cases.save_onboarding

import com.pidzama.comicsdreamsapp.data.repository.Repository

class SaveOnBoardingUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(showed: Boolean){
        repository.saveOnBoardingState(showed = showed)
    }
}