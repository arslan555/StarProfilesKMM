package com.arslan.starprofileskmm.ui.main

import com.arslan.starprofileskmm.domain.repository.StarReposRepository
import com.arslan.starprofileskmm.utils.isLoading
import com.arslan.starprofileskmm.utils.onFailure
import com.arslan.starprofileskmm.utils.onSuccess
import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class MainViewModel constructor(private val starReposRepository: StarReposRepository) : KoinComponent {
    private val _mainUiState = MutableStateFlow(MainUiState(isLoading = true))
    @NativeCoroutines
    val mainUiState = _mainUiState.asStateFlow()
    private val viewModelScope = CoroutineScope(Dispatchers.IO)
    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        _mainUiState.update { it.copy(isLoading = false, error = exception.message) }
    }
    fun fetchStarRepos() = viewModelScope.launch(coroutineExceptionHandler) {
        starReposRepository.fetchStarRepos("kotlin").collectLatest { starReposResult ->
            starReposResult.isLoading { isLoading ->
                _mainUiState.update { it.copy(isLoading = isLoading) }
            }.onSuccess { starRepos ->
                _mainUiState.update { it.copy(starRepos = starRepos) }
            }.onFailure { error ->
                _mainUiState.update { it.copy(error = error.message) }
            }
        }
    }
}