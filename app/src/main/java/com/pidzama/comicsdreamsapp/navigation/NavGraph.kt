package com.pidzama.comicsdreamsapp.navigation

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.accompanist.pager.ExperimentalPagerApi
import com.pidzama.comicsdreamsapp.presentation.screen.home.HomeScreen
import com.pidzama.comicsdreamsapp.presentation.screen.onboarding.OnBoardingScreen
import com.pidzama.comicsdreamsapp.presentation.screen.splash.SplashScreen
import com.pidzama.comicsdreamsapp.util.Constants.DETAILS_KEY

@ExperimentalPagerApi
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {
        composable(route = Screens.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screens.OnBoarding.route) {
            OnBoardingScreen(navController = navController)
        }
        composable(route = Screens.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screens.Details.route,
            arguments = listOf(navArgument(DETAILS_KEY) {
                type = NavType.IntType
            })
        ) {

        }
        composable(route = Screens.Search.route) {

        }
    }
}