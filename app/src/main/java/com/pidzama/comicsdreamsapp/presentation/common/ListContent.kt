package com.pidzama.comicsdreamsapp.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.paging.compose.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.pidzama.comicsdreamsapp.R
import com.pidzama.comicsdreamsapp.domain.model.Hero
import com.pidzama.comicsdreamsapp.navigation.Screens
import com.pidzama.comicsdreamsapp.ui.theme.*
import com.pidzama.comicsdreamsapp.util.Constants.BASE_URL
import com.pidzama.comicsdreamsapp.util.components.RatingWidget
import com.pidzama.comicsdreamsapp.util.components.ShimmerEffect

@Composable
fun ListContent(
    heroes: LazyPagingItems<Hero>,
    navController: NavHostController
) {
    val result = handlePagingResult(heroes = heroes)

    if (result) {
        LazyColumn(
            contentPadding = PaddingValues(all = SMALL_PADDING_10),
            verticalArrangement = Arrangement.spacedBy(SMALL_PADDING_10)
        ) {
            items(
                items = heroes,
                key = { hero ->
                    hero.id
                }
            ) { hero ->
                hero?.let {
                    HeroItem(hero = it, navController = navController)
                }
            }
        }
    }
}

@Composable
fun handlePagingResult(
    heroes: LazyPagingItems<Hero>
): Boolean {
    heroes.apply {
        val error = when {
            loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
            loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
            loadState.append is LoadState.Error -> loadState.append as LoadState.Error
            else -> null
        }

        return when {
            loadState.refresh is LoadState.Loading -> {
                ShimmerEffect()
                false
            }
            error != null -> {
                EmptyScreen(error = error, heroes = heroes)
                false
            }
            heroes.itemCount < 1 -> {
                EmptyScreen()
                false
            }
            else -> true
        }
    }
}


@Composable
fun HeroItem(
    hero: Hero,
    navController: NavHostController
) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data("$BASE_URL${hero.image}")
            .placeholder(R.drawable.ic_placeholder)
            .error(R.drawable.ic_placeholder)
            .build()
    )

    Box(
        modifier = Modifier
            .height(HEIGHT_HERO_ITEM_BOX)
            .clickable {
                navController.navigate(Screens.Details.passHeroId(heroId = hero.id))
            },
        contentAlignment = Alignment.BottomStart
    ) {
        Surface(shape = RoundedCornerShape(size = LARGE_PADDING_20)) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painter,
                contentDescription = stringResource(R.string.hero_image),
                contentScale = ContentScale.Crop
            )
        }
        Surface(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth(),
            color = Color.Black.copy(alpha = ContentAlpha.medium),
            shape = RoundedCornerShape(
                bottomStart = LARGE_PADDING_20,
                bottomEnd = LARGE_PADDING_20
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = MEDIUM_PADDING_16)
            ) {
                Text(
                    text = hero.alias,
                    color = White,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = hero.biography,
                    color = White.copy(alpha = ContentAlpha.medium),
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    modifier = Modifier.padding(top = SMALL_PADDING_10),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RatingWidget(
                        modifier = Modifier.padding(end = SMALL_PADDING_10),
                        rating = hero.rating
                    )
                    Text(
                        text = hero.rating.toString(),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = White.copy(alpha = ContentAlpha.medium),
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun previewHomeScreen() {
    HeroItem(
        hero = Hero(
            id = 1,
            alias = "Moon Knight",
            realName = "Bob",
            image = "",
            biography = "Давныйм давно боги Египта наделили Bob'а суперсилой, во благо человечества. Теперь он должен блисти порядок вгороде. Одет как муммия",
            position = "Gjcbnbjy",
            height = 1.89,
            weight = 87,
            rating = 4.2,
            allies = listOf("Spider-man", "Batman", "Iron Man"),
            enemies = listOf("Goblin", "Dr.Evil"),
            publisher = "Marvel"
        ),
        navController = rememberNavController()
    )
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun previewDarkHomeScreen() {
    HeroItem(
        hero = Hero(
            id = 1,
            alias = "Moon Knight",
            realName = "Bob",
            image = "",
            biography = "Давныйм давно боги Египта наделили Bob'а суперсилой, во благо человечества. Теперь он должен блисти порядок вгороде. Одет как муммия",
            position = "Gjcbnbjy",
            height = 1.89,
            weight = 87,
            rating = 4.2,
            allies = listOf("Spider-man", "Batman", "Iron Man"),
            enemies = listOf("Goblin", "Dr.Evil"),
            publisher = "Marvel"
        ),
        navController = rememberNavController()
    )
}