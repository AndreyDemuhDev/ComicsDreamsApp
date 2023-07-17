package com.pidzama.comicsdreamsapp.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val LightGray = Color(0xFFB0ACB9)
val DarkGrey = Color(0xFF464545)
val Black = Color(0xFF000000)
val White = Color(0xFFFFFFFF)
val StarRating = Color(0xFFFFC94D)
val ShimmerLightGray = Color(0xFCD6D6D6)
val ShimmerMediumGray = Color(0xFF9E9E9E)
val ShimmerDarkGray = Color(0xFF1D1D1D)

val Colors.onBoardingScreenBackgroundColor
    @Composable
    get() = if (isLight) Color.White else Color.Black

val Colors.titleColor
    @Composable
    get() = if (isLight) DarkGrey else LightGray

val Colors.descriptionColor
    @Composable
    get() = if (isLight) DarkGrey.copy(alpha = 0.4f)
    else LightGray.copy(alpha = 0.4f)

val Colors.activePagerIndicator
    @Composable
    get() = if (isLight) Black else White

val Colors.inactivePagerIndicator
    @Composable
    get() = if (isLight) LightGray else DarkGrey

val Colors.backgroundButtonColor
    @Composable
    get() = if (isLight) LightGray else DarkGrey

val Colors.topAppBarContentColor
    @Composable
    get() = if (isLight) DarkGrey else White

val Colors.topAppBarBackgroundColor
    @Composable
    get() = if (isLight) White else Black