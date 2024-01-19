package com.arslan.starprofileskmm.ui.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import io.github.aakira.napier.Napier
import org.koin.compose.koinInject

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel = koinInject(),
    paddingValues: PaddingValues
) {
    val scrollState = rememberScrollState()
    LaunchedEffect(key1 = viewModel) {
        viewModel.fetchStarRepos()
    }
    val homeUiState = viewModel.mainUiState.collectAsState().value
   Text(homeUiState.starRepos.toString())

}