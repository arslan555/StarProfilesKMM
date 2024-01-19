package com.arslan.starprofileskmm

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

@Composable
expect fun font(name: String, res: String, weight: FontWeight, style: FontStyle): Font