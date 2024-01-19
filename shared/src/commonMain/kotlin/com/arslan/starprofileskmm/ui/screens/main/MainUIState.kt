package com.arslan.starprofileskmm.ui.screens.main

import com.arslan.starprofileskmm.domain.models.StarRepo


data class MainUiState(
    val isLoading: Boolean = true,
    val error: String? = null,
    val starRepos: List<StarRepo>? = emptyList(),
)