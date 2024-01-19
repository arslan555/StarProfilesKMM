package com.arslan.starprofileskmm.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.arslan.starprofileskmm.ui.components.AppBar
import com.arslan.starprofileskmm.ui.components.Repos
import com.arslan.starprofileskmm.ui.components.ShimmerLayout
import com.arslan.starprofileskmm.ui.theme.SPAppTheme
import moe.tlaster.precompose.PreComposeApp
import org.koin.compose.koinInject

@Composable
fun MainScreen(
    viewModel: MainViewModel = koinInject()
) {
    PreComposeApp {
        val mainUiState = viewModel.mainUiState.collectAsState().value

        LaunchedEffect(key1 = viewModel) {
            viewModel.fetchStarRepos()
        }
        SPAppTheme(darkTheme = true) {
            Scaffold{ paddingValues ->
                Column(modifier = Modifier.fillMaxSize()) {
                    Spacer(Modifier.windowInsetsTopHeight(WindowInsets.safeDrawing))
                    AppBar("Github Star Repositories")
                    if (mainUiState.isLoading) {
                        ShimmerLayout()
                    } else if (mainUiState.starRepos.isNullOrEmpty().not()) {
                        mainUiState.starRepos?.let {
                            Repos(
                                modifier = Modifier.padding(paddingValues),
                                repos = mainUiState.starRepos
                            )
                        }

                    } else {
                        Text(mainUiState.error.toString())
                    }
                    Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.safeDrawing))
                }
            }
        }
    }
}