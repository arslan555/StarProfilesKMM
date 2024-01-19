package com.arslan.starprofileskmm.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ComposeUIViewController
import com.arslan.starprofileskmm.ui.main.MainScreen


fun MainViewController() = ComposeUIViewController { MainScreen(paddingValues = PaddingValues(20.dp)) }