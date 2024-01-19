package com.arslan.starprofileskmm.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(
    val route: String,
    val title: String,
    val icon: ImageVector?
) {

    object Main : NavigationItem("/home", "Main", null)
    object Details : NavigationItem("/details/{id:[0-9]+}", "Details", null)
}