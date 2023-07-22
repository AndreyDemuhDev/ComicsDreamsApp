package com.pidzama.comicsdreamsapp.presentation.screen.splash

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.pidzama.comicsdreamsapp.R
import com.pidzama.comicsdreamsapp.navigation.Screens
import com.pidzama.comicsdreamsapp.ui.theme.Black
import com.pidzama.comicsdreamsapp.ui.theme.White

@Composable
fun SplashScreen(
    navController: NavHostController,
    splashViewModel: SplashViewModel = hiltViewModel()
) {
    val onBoardingShowed by splashViewModel.onBoardingShowed.collectAsState()

    val degreesAnimation = remember { Animatable(0f) }
    LaunchedEffect(key1 = true) {
        degreesAnimation.animateTo(
            targetValue = 360f,
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 200
            )
        )
        navController.popBackStack()
        if (onBoardingShowed) {
            navController.navigate(Screens.Home.route)
        } else {
            navController.navigate(Screens.OnBoarding.route)
        }
    }
    Splash(degrees = degreesAnimation.value)
}

@Composable
fun Splash(degrees: Float) {
    val modifier = if (isSystemInDarkTheme()) {
        Modifier.background(Black)
    } else {
        Modifier.background(White)
    }
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.rotate(degrees = degrees),
            painter = painterResource(R.drawable.ic_logo),
            contentDescription = stringResource(R.string.splash_logo)
        )
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    Splash(degrees = 0f)
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SplashScreenDarkThemePreview() {
    Splash(degrees = 0f)
}