package com.pidzama.comicsdreamsapp.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.paging.LoadState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.compose.LazyPagingItems
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.pidzama.comicsdreamsapp.R
import com.pidzama.comicsdreamsapp.domain.model.Hero
import com.pidzama.comicsdreamsapp.ui.theme.*
import java.net.ConnectException
import java.net.SocketTimeoutException

@Composable
fun EmptyScreen(
    error: LoadState.Error? = null,
    heroes: LazyPagingItems<Hero>? = null
) {
    var message by remember {
        mutableStateOf("Find hero here!")
    }
    var icon by remember {
        mutableStateOf(R.drawable.ic_search_screen)
    }

    if (error != null) {
        message = errorMessage(error = error)
        icon = R.drawable.ic_error
    }

    var startAnimation by remember {
        mutableStateOf(false)
    }
    val alphaAnim by animateFloatAsState(
        targetValue = if (startAnimation) ContentAlpha.disabled else 0f,
        animationSpec = tween(
            durationMillis = 1000
        )
    )
    LaunchedEffect(key1 = true) {
        startAnimation = true
    }
    EmptyContent(
        alphaAnim = alphaAnim,
        icon = icon,
        message = message,
        error = error,
        heroes = heroes
    )
}

@Composable
fun EmptyContent(
    alphaAnim: Float,
    icon: Int,
    message: String,
    error: LoadState.Error? = null,
    heroes: LazyPagingItems<Hero>? = null
) {
    var isRefreshing by remember { mutableStateOf(false) }

    SwipeRefresh(
        swipeEnabled = error != null,
        state = rememberSwipeRefreshState(isRefreshing = isRefreshing),
        onRefresh = {
            isRefreshing = true
            heroes?.refresh()
            isRefreshing = false
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier
                    .size(SIZE_IMAGE_ERROR)
                    .alpha(alpha = alphaAnim),
                painter = painterResource(icon),
                contentDescription = stringResource(R.string.error_image),
                tint = if (isSystemInDarkTheme()) LightGray else DarkGrey
            )
            Text(
                modifier = Modifier
                    .padding(top = EXTRA_SMALL_PADDING_6)
                    .alpha(alpha = alphaAnim),
                text = message,
                color = if (isSystemInDarkTheme()) LightGray else DarkGrey,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.subtitle1.fontSize
            )
        }
    }
}

fun errorMessage(error: LoadState.Error): String {
    return when (error.error) {
        is SocketTimeoutException -> {
            "Server Unavailable."
        }
        is ConnectException -> {
            "Internet Unavailable."
        }
        else -> {
            "Unknown Error."
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScreenError() {
    EmptyContent(
        alphaAnim = ContentAlpha.disabled,
        icon = R.drawable.ic_error,
        message = "Error"
    )
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewDarkScreenError() {
    EmptyContent(
        alphaAnim = ContentAlpha.disabled,
        icon = R.drawable.ic_error,
        message = "Error"
    )
}