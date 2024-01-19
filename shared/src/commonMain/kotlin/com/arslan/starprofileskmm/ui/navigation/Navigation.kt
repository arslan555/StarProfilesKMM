package com.arslan.starprofileskmm.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.arslan.starprofileskmm.ui.screens.main.MainScreen
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.path

@Composable
fun Navigation(
    navigator: Navigator,
    paddingValues: PaddingValues = PaddingValues()
) {
    NavHost(navigator = navigator, initialRoute = NavigationItem.Main.route) {
        scene(NavigationItem.Main.route) {
            MainScreen()
        }

        scene(NavigationItem.Details.route) { backStackEntry ->
//            backStackEntry.path<Int>("id")?.let { movieId ->
//               // DetailsScreen(navigator = navigator, windowSize = windowSize, movieId = movieId)
//            }
        }
    }
}