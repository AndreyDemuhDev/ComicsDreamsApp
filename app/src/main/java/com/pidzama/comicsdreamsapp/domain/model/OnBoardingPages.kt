package com.pidzama.comicsdreamsapp.domain.model

import androidx.annotation.DrawableRes
import com.pidzama.comicsdreamsapp.R

sealed class OnBoardingPages(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
){
    object FirstScreen: OnBoardingPages(
        image = R.drawable.welcome,
        title = "Welcome App",
        description = "Hello Comics Dreams App. Let's go to fun and enjoy."
    )
    object SecondScreen : OnBoardingPages(
        image = R.drawable.find,
        title = "Find",
        description = "Find your favorite superhero or supervillain."
    )
    object ThirdScreen : OnBoardingPages(
        image = R.drawable.explore,
        title = "Explore",
        description = "Explore more information about superhero/supervillain"
    )
}
