package com.pidzama.comicsdreamsapp.presentation.screen.details

import android.graphics.Color.parseColor
import android.util.Log
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.pidzama.comicsdreamsapp.R
import com.pidzama.comicsdreamsapp.domain.model.Hero
import com.pidzama.comicsdreamsapp.ui.theme.*
import com.pidzama.comicsdreamsapp.util.Constants.BASE_URL
import com.pidzama.comicsdreamsapp.util.Constants.MAX_LINES_TEXT_BIOGRAPHY
import com.pidzama.comicsdreamsapp.util.Constants.MIN_IMAGE_HERO_DETAILS
import com.pidzama.comicsdreamsapp.util.components.InfoBox
import com.pidzama.comicsdreamsapp.util.components.OrderedList

@ExperimentalMaterialApi
@Composable
fun DetailsContent(
    navController: NavHostController,
    currentHero: Hero?,
    colors: Map<String, String>
) {

    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Expanded)
    )
    val currentSheetFraction = scaffoldState.currentSheetFraction
    val animCornerRadius by animateDpAsState(
        targetValue =
        if (currentSheetFraction == 1f)
            EXTRA_LARGE_PADDING_40
        else
            ZERO_RADIUS_SHEET
    )

    var vibrant by remember { mutableStateOf("#000000") }
    var darkVibrant by remember { mutableStateOf("#000000") }
    var onDarkVibrant by remember { mutableStateOf("#FFFFFF") }

    LaunchedEffect(key1 = currentHero) {
        vibrant = colors["vibrant"]!!
        darkVibrant = colors["darkVibrant"]!!
        onDarkVibrant = colors["onDarkVibrant"]!!
    }
    val systemUiColorController = rememberSystemUiController()
    systemUiColorController.setSystemBarsColor(
        color = Color(parseColor(darkVibrant))
    )

    BottomSheetScaffold(
        sheetShape = RoundedCornerShape(
            topStart = animCornerRadius,
            topEnd = animCornerRadius
        ),
        scaffoldState = scaffoldState,
        sheetPeekHeight = HEIGHT_SHEET_MIN,
        sheetContent = {
            currentHero?.let {
                BottomSheetContent(
                    currentHero = it,
                    infoBoxIconColor = Color(parseColor(vibrant)),
                    sheetBackgroundColor = Color(parseColor(darkVibrant)),
                    contentColor = Color(parseColor(onDarkVibrant))
                )
            }
        },
        content = {
            currentHero?.let { hero ->
                ImageContent(
                    heroImage = hero.image,
                    imageFraction = currentSheetFraction,
                    backgroundColor = Color(parseColor(darkVibrant)),
                    onCloseClicked = {
                        navController.popBackStack()
                    }
                )
            }
        }
    )
}

@Composable
fun BottomSheetContent(
    currentHero: Hero,
    infoBoxIconColor: Color = MaterialTheme.colors.primary,
    sheetBackgroundColor: Color = MaterialTheme.colors.surface,
    contentColor: Color = MaterialTheme.colors.titleColor,
) {
    Column(
        modifier = Modifier
            .background(sheetBackgroundColor)
            .padding(all = LARGE_PADDING_20)
    ) {
        Text(
            modifier = Modifier.padding(bottom = EXTRA_SMALL_PADDING_6),
            text = currentHero.alias,
            color = contentColor,
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.Bold
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = MEDIUM_PADDING_16),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            InfoBox(
                icon = painterResource(id = R.drawable.ic_position),
                iconColor = infoBoxIconColor,
                bigText = "${currentHero.height}",
                smallText = stringResource(R.string.height),
                textColor = contentColor
            )
            InfoBox(
                icon = painterResource(id = R.drawable.ic_position),
                iconColor = infoBoxIconColor,
                bigText = "${currentHero.weight}",
                smallText = stringResource(R.string.weight),
                textColor = contentColor
            )
            InfoBox(
                icon = painterResource(id = R.drawable.ic_position),
                iconColor = infoBoxIconColor,
                bigText = currentHero.position,
                smallText = stringResource(R.string.position),
                textColor = contentColor
            )
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = EXTRA_SMALL_PADDING_6),
            text = stringResource(R.string.biography),
            color = contentColor,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .alpha(ContentAlpha.medium)
                .padding(bottom = EXTRA_SMALL_PADDING_6),
            text = "Rear name: ${currentHero.realName}",
            color = contentColor,
            fontSize = MaterialTheme.typography.body1.fontSize
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .alpha(ContentAlpha.medium)
                .padding(bottom = MEDIUM_PADDING_16),
            text = currentHero.biography,
            color = contentColor,
            fontSize = MaterialTheme.typography.body1.fontSize,
            maxLines = MAX_LINES_TEXT_BIOGRAPHY,
            overflow = TextOverflow.Ellipsis
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OrderedList(
                title = stringResource(R.string.allies),
                items = currentHero.allies,
                textColor = contentColor
            )
            OrderedList(
                title = stringResource(R.string.enemies),
                items = currentHero.enemies,
                textColor = contentColor
            )
            Column {
                Text(
                    text = stringResource(R.string.publisher),
                    color = contentColor,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium),
                    text = currentHero.publisher,
                    color = contentColor,
                    fontSize = MaterialTheme.typography.body1.fontSize,
                )
            }
        }
    }
}

@Composable
fun ImageContent(
    heroImage: String,
    imageFraction: Float = 1f,
    backgroundColor: Color = MaterialTheme.colors.surface,
    onCloseClicked: () -> Unit
) {

    val imageUrl = "${BASE_URL}${heroImage}"
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = imageFraction + MIN_IMAGE_HERO_DETAILS)
                .align(Alignment.TopStart),
            model = ImageRequest.Builder(LocalContext.current)
                .data(data = imageUrl)
                .error(drawableResId = R.drawable.ic_placeholder)
                .build(),
            contentDescription = stringResource(id = R.string.hero_image),
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(
                modifier = Modifier.padding(all = SMALL_PADDING_10),
                onClick = { onCloseClicked() }
            ) {
                Icon(
                    modifier = Modifier.size(SIZE_IMAGE_INFO_BOX),
                    imageVector = Icons.Default.Close,
                    contentDescription = stringResource(R.string.close_icon),
                    tint = Color.White
                )
            }
        }
    }
}

@ExperimentalMaterialApi
val BottomSheetScaffoldState.currentSheetFraction: Float
    get() {
        val fraction = bottomSheetState.progress.fraction
        val targetValue = bottomSheetState.targetValue
        val currentValue = bottomSheetState.currentValue

        Log.d("Fraction", fraction.toString())
        Log.d("FractionTarget", targetValue.toString())
        Log.d("FractionCurrent", currentValue.toString())

        return when {
            currentValue == BottomSheetValue.Collapsed && targetValue == BottomSheetValue.Collapsed -> 1f
            currentValue == BottomSheetValue.Expanded && targetValue == BottomSheetValue.Expanded -> 0f
            currentValue == BottomSheetValue.Collapsed && targetValue == BottomSheetValue.Expanded -> 1f - fraction
            currentValue == BottomSheetValue.Expanded && targetValue == BottomSheetValue.Collapsed -> 0f + fraction
            else -> fraction
        }
    }

@Preview
@Composable
fun previewBottomSheetDialog() {
    BottomSheetContent(
        currentHero = Hero(
            id = 20,
            alias = "Wolverine",
            realName = "James Howlett",
            image = "/images/wolverine.jpg",
            biography = "WOLVEsdfsdfsdfsdfsfsdfsdfsdfsdfsdfsdfsdfsfsfRINE",
            position = "Good",
            height = 1.76,
            weight = 133,
            rating = 4.6,
            allies = listOf("Professor X", "Storm", "Cyclops", "Captain America"),
            enemies = listOf("Hamato Yoshi", "Splinter", "April O’Neil"),
            publisher = "Marvel"
        )
    )
}