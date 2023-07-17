package com.pidzama.comicsdreamsapp.presentation.screen.details

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.pidzama.comicsdreamsapp.util.Constants.BASE_URL
import com.pidzama.comicsdreamsapp.util.PaletteGenerator.convertImageUrlToBitmap
import com.pidzama.comicsdreamsapp.util.PaletteGenerator.extractColorsFromBitmap
import com.pidzama.comicsdreamsapp.util.components.UiEvent
import kotlinx.coroutines.flow.collectLatest

@ExperimentalMaterialApi
@Composable
fun DetailsScreen(
    navController: NavHostController,
    detailsViewModel: DetailsViewModel = hiltViewModel()
) {
    val currentHero by detailsViewModel.selectedHero.collectAsState()
    val colorPalette by detailsViewModel.colorPalette

    if (colorPalette.isNotEmpty()) {
        DetailsContent(
            navController = navController,
            currentHero = currentHero,
            colors = colorPalette
        )
    } else {
        detailsViewModel.generateColorPalette()
    }

    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        detailsViewModel.uiEvent.collectLatest { event ->
            when (event) {
                is UiEvent.GeneratorColorPalette -> {
                    val bitmap = convertImageUrlToBitmap(
                        imageUrl = "$BASE_URL${currentHero?.image}",
                        context = context
                    )
                    if (bitmap != null) {
                        detailsViewModel.setColorPalette(
                            colors = extractColorsFromBitmap(
                                bitmap = bitmap
                            )
                        )
                    }
                }
            }

        }
    }


}