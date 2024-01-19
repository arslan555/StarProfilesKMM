package com.arslan.starprofileskmm.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.arslan.starprofileskmm.font

// Set of Material typography styles to start with
@Composable
fun getTypography(): Typography {
    val nunitoRegular = FontFamily(
        font(
            "Nunito", "nunito_regular", FontWeight.Normal, FontStyle.Normal
        )
    )

    val nunitoSemiBold = FontFamily(
        font(
            "Nunito", "nunito_semibold", FontWeight.Normal, FontStyle.Normal
        )
    )
    val nunitoBold = FontFamily(
        font(
            "Nunito", "nunito_bold", FontWeight.Normal, FontStyle.Normal
        )
    )
    return Typography(

        titleMedium = TextStyle(
            fontWeight = FontWeight.W700,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.1.sp,
            fontFamily = nunitoBold
        ),
        titleSmall = TextStyle(
            fontWeight = FontWeight.W500,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.1.sp,
            fontFamily = nunitoSemiBold
        ),

        bodyMedium = TextStyle(
            fontWeight = FontWeight.W400,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.25.sp,
            fontFamily = nunitoRegular
        ),
        bodySmall = TextStyle(
            fontWeight = FontWeight.W400,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.4.sp,
            fontFamily = nunitoRegular
        ),

        labelMedium = TextStyle(
            fontFamily = nunitoRegular,
            fontWeight = FontWeight.W500,
            fontSize = 14.sp
        ),
        labelSmall = TextStyle(
            fontFamily = nunitoRegular,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        )
    )
}