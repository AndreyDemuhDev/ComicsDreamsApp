package com.pidzama.comicsdreamsapp.navigation

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.pidzama.comicsdreamsapp.util.Constants.DETAILS_KEY

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {
        composable(route = Screens.Splash.route) {

        }
        composable(route = Screens.Onboarding.route) {

        }
        composable(route = Screens.Home.route) {

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