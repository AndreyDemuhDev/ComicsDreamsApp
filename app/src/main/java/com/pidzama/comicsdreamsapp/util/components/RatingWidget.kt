package com.pidzama.comicsdreamsapp.util.components

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.pidzama.comicsdreamsapp.R
import com.pidzama.comicsdreamsapp.ui.theme.EXTRA_SMALL_PADDING_6
import com.pidzama.comicsdreamsapp.ui.theme.LightGray
import com.pidzama.comicsdreamsapp.ui.theme.StarRating

@Composable
fun RatingWidget(
    modifier: Modifier,
    rating: Double,
    scaleFactor: Float = 3f,
    spaceBetween: Dp = EXTRA_SMALL_PADDING_6
) {
    val result = calculateRating(rating = rating)
    val pathString = stringResource(R.string.star_path)
    val startPath = remember {
        PathParser().parsePathString(pathData = pathString).toPath()
    }
    val starPathBounds = remember {
        startPath.getBounds()
    }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spaceBetween)
    ) {
        result["filledStart"]?.let {
            repeat(it) {
                FilledStar(
                    starPath = startPath,
                    starPathBounds = starPathBounds,
                    scaleFactor = scaleFactor
                )
            }
        }
        result["halfFilledStart"]?.let {
            repeat(it) {
                HalfFilledStar(
                    starPath = startPath,
                    starPathBounds = starPathBounds,
                    scaleFactor = scaleFactor
                )
            }
        }
        result["emptyStart"]?.let {
            repeat(it) {
                EmptyStar(
                    starPath = startPath,
                    starPathBounds = starPathBounds,
                    scaleFactor = scaleFactor
                )
            }
        }
    }
}

@Composable
fun FilledStar(
    starPath: Path,
    starPathBounds: Rect,
    scaleFactor: Float
) {
    Canvas(modifier = Modifier.size(24.dp)) {
        val canvasSize = size
        scale(scale = scaleFactor) {
            val pathWidth = starPathBounds.width
            val pathHeight = starPathBounds.height
            val left = (canvasSize.width / 2f) - (pathWidth / 1.7f)
            val top = (canvasSize.height / 2f) - (pathHeight / 1.7f)

            translate(left = left, top = top) {
                drawPath(
                    path = starPath,
                    color = StarRating
                )
            }
        }
    }
}

@Composable
fun HalfFilledStar(
    starPath: Path,
    starPathBounds: Rect,
    scaleFactor: Float
) {
    Canvas(modifier = Modifier.size(24.dp)) {
        val canvasSize = size
        scale(scale = scaleFactor) {
            val pathWidth = starPathBounds.width
            val pathHeight = starPathBounds.height
            val left = (canvasSize.width / 2f) - (pathWidth / 1.7f)
            val top = (canvasSize.height / 2f) - (pathHeight / 1.7f)

            translate(left = left, top = top) {
                drawPath(
                    path = starPath,
                    color = LightGray.copy(alpha = 0.5f)
                )
                clipPath(path = starPath) {
                    drawRect(
                        color = StarRating,
                        size = Size(
                            width = starPathBounds.maxDimension / 1.7f,
                            height = starPathBounds.maxDimension * scaleFactor
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun EmptyStar(
    starPath: Path,
    starPathBounds: Rect,
    scaleFactor: Float
) {
    Canvas(modifier = Modifier.size(24.dp)) {
        val canvasSize = size
        scale(scale = scaleFactor) {
            val pathWidth = starPathBounds.width
            val pathHeight = starPathBounds.height
            val left = (canvasSize.width / 2f) - (pathWidth / 1.7f)
            val top = (canvasSize.height / 2f) - (pathHeight / 1.7f)

            translate(left = left, top = top) {
                drawPath(
                    path = starPath,
                    color = LightGray.copy(alpha = 0.5f)
                )
            }
        }
    }
}

@Composable
fun calculateRating(rating: Double): Map<String, Int> {
    val maxRating by remember { mutableStateOf(5) }
    var filledStars by remember { mutableStateOf(0) }
    var halfFilledStars by remember { mutableStateOf(0) }
    var emptyStars by remember { mutableStateOf(0) }

    LaunchedEffect(key1 = rating) {
        val (firstNumber, lastNumber) = rating.toString()
            .split(".")
            .map { it.toInt() }

        if (firstNumber in 0..5 && lastNumber in 0..9) {
            filledStars = firstNumber
            if (lastNumber in 1..5) {
                halfFilledStars++
            }
            if (lastNumber in 6..9) {
                filledStars++
            }
            if (firstNumber == 5 && lastNumber > 0) {
                emptyStars = 5
                filledStars = 0
                halfFilledStars = 0
            }
        } else {
            Log.d("RatingWidget", "Invalid rating number")
        }
    }
    emptyStars = maxRating - (filledStars + halfFilledStars)
    return mapOf(
        "filledStart" to filledStars,
        "halfFilledStart" to halfFilledStars,
        "emptyStart" to emptyStars
    )
}

@Preview(showBackground = true)
@Composable
fun FilledStarPreview() {
    val pathString = stringResource(R.string.star_path)
    val startPath = remember {
        PathParser().parsePathString(pathData = pathString).toPath()
    }
    val starPathBounds = remember {
        startPath.getBounds()
    }
    FilledStar(
        starPath = startPath,
        starPathBounds = starPathBounds,
        scaleFactor = 3f
    )
}

@Preview(showBackground = true)
@Composable
fun HalfFilledStarPreview() {
    val pathString = stringResource(R.string.star_path)
    val startPath = remember {
        PathParser().parsePathString(pathData = pathString).toPath()
    }
    val starPathBounds = remember {
        startPath.getBounds()
    }
    HalfFilledStar(
        starPath = startPath,
        starPathBounds = starPathBounds,
        scaleFactor = 3f
    )
}

@Preview(showBackground = true)
@Composable
fun EmptyStarPreview() {
    val pathString = stringResource(R.string.star_path)
    val startPath = remember {
        PathParser().parsePathString(pathData = pathString).toPath()
    }
    val starPathBounds = remember {
        startPath.getBounds()
    }
    EmptyStar(
        starPath = startPath,
        starPathBounds = starPathBounds,
        scaleFactor = 3f
    )
}