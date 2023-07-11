package com.pidzama.comicsdreamsapp.navigation

import com.pidzama.comicsdreamsapp.util.Constants.DETAILS_KEY

sealed class Screens(val route: String) {
    object Splash : Screens(route = "splash_screen")
    object OnBoarding : Screens(route = "onBoarding_screen")
    object Home : Screens(route = "home_screen")
    object Details : Screens(route = "details_screen/{$DETAILS_KEY}") {
        fun passHeroId(heroId: Int): String {
            return "details_screen/$heroId"
        }
    }
    object Search: Screens(route = "search_screen")
}

