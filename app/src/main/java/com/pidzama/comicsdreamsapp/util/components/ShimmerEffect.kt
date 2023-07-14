package com.pidzama.comicsdreamsapp.util.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.*
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import com.pidzama.comicsdreamsapp.ui.theme.*

@Composable
fun ShimmerEffect() {
    LazyColumn(
        contentPadding = PaddingValues(all = SMALL_PADDING_10),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING_10)
    ){
        items(2){
            AnimatedShimmerItem()
        }
    }
}

@Composable
fun AnimatedShimmerItem() {
    val transition = rememberInfiniteTransition()
    val alphaAnim by transition.animateFloat(
        initialValue = 1f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 700,
                easing = FastOutLinearInEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )
    ShimmerItem(alpha = alphaAnim)
}

@Composable
fun ShimmerItem(alpha: Float) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(HEIGHT_HERO_ITEM_BOX),
        color = if (isSystemInDarkTheme()) Black else ShimmerLightGray,
        shape = RoundedCornerShape(size = LARGE_PADDING_20)
    ) {
        Column(
            modifier = Modifier
                .padding(all = MEDIUM_PADDING_16),
            verticalArrangement = Arrangement.Bottom
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(HEIGHT_NAME_SHIMMER_PLACEHOLDER)
                    .alpha(alpha = alpha),
                color = if (isSystemInDarkTheme()) ShimmerDarkGray else ShimmerMediumGray,
                shape = RoundedCornerShape(size = EXTRA_SMALL_PADDING_6)
            ) {}
            Spacer(modifier = Modifier.padding(all = SMALL_PADDING_10))
            repeat(3) {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(HEIGHT_ABOUT_SHIMMER_PLACEHOLDER)
                        .alpha(alpha = alpha),
                    color = if (isSystemInDarkTheme()) ShimmerDarkGray else ShimmerMediumGray,
                    shape = RoundedCornerShape(size = EXTRA_SMALL_PADDING_6)
                ) {}
                Spacer(modifier = Modifier.padding(all = EXTRA_SMALL_PADDING_6))
            }
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                repeat(5) {
                    Surface(
                        modifier = Modifier
                            .size(HEIGHT_RATING_SHIMMER_PLACEHOLDER)
                            .alpha(alpha = alpha),
                        color = if (isSystemInDarkTheme()) ShimmerDarkGray else ShimmerMediumGray,
                        shape = RoundedCornerShape(size = EXTRA_SMALL_PADDING_6)
                    ) {}
                    Spacer(modifier = Modifier.padding(all = SMALL_PADDING_10))
                }
            }
        }
    }
}

@Preview
@Composable
fun ShimmerPreview() {
    AnimatedShimmerItem()
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DarkShimmerPreview() {
    AnimatedShimmerItem()
}