package com.pidzama.comicsdreamsapp.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.accompanist.pager.ExperimentalPagerApi
import com.pidzama.comicsdreamsapp.presentation.screen.details.DetailsScreen
import com.pidzama.comicsdreamsapp.presentation.screen.home.HomeScreen
import com.pidzama.comicsdreamsapp.presentation.screen.onboarding.OnBoardingScreen
import com.pidzama.comicsdreamsapp.presentation.screen.search.SearchScreen
import com.pidzama.comicsdreamsapp.presentation.screen.splash.SplashScreen
import com.pidzama.comicsdreamsapp.util.Constants.DETAIL_ARGUMENT_KEY

@ExperimentalMaterialApi
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
            arguments = listOf(navArgument(DETAIL_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {
            DetailsScreen(navController = navController)
        }
        composable(route = Screens.Search.route) {
            SearchScreen(navController = navController)
        }
    }
}