package com.pidzama.comicsdreamsapp.presentation.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pidzama.comicsdreamsapp.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _onBoardingShowed = MutableStateFlow(false)
    val onBoardingShowed: StateFlow<Boolean>
        get() = _onBoardingShowed

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _onBoardingShowed.value = useCases.readOnBoardingUseCase().stateIn(viewModelScope).value
        }
    }
}