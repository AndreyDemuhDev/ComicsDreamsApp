package com.pidzama.comicsdreamsapp.util.components

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import com.pidzama.comicsdreamsapp.ui.theme.SMALL_PADDING_10
import org.junit.Rule
import org.junit.Test

class RatingWidgetTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun passZeroPointZeroValue_Assert_FiveEmptyStar() {
        composeTestRule.setContent {
            RatingWidget(
                modifier = Modifier.padding(end = SMALL_PADDING_10),
                rating = 0.0
            )
        }
        composeTestRule.onAllNodesWithContentDescription("Empty Star")
            .assertCountEquals(5)
        composeTestRule.onAllNodesWithContentDescription("Half Filled Star")
            .assertCountEquals(0)
        composeTestRule.onAllNodesWithContentDescription("Filled Star")
            .assertCountEquals(0)
    }

    @Test
    fun passZeroPointFiveValue_Assert_FourEmptyStars_and_OneHalfFilledStar() {
        composeTestRule.setContent {
            RatingWidget(
                modifier = Modifier.padding(end = SMALL_PADDING_10),
                rating = 0.5
            )
        }
        composeTestRule.onAllNodesWithContentDescription("Empty Star")
            .assertCountEquals(4)
        composeTestRule.onAllNodesWithContentDescription("Half Filled Star")
            .assertCountEquals(1)
        composeTestRule.onAllNodesWithContentDescription("Filled Star")
            .assertCountEquals(0)
    }

    @Test
    fun passZeroPointSevenValue_Assert_FourEmptyStars_and_OneFilledStar() {
        composeTestRule.setContent {
            RatingWidget(
                modifier = Modifier.padding(end = SMALL_PADDING_10),
                rating = 0.7
            )
        }
        composeTestRule.onAllNodesWithContentDescription("Empty Star")
            .assertCountEquals(4)
        composeTestRule.onAllNodesWithContentDescription("Half Filled Star")
            .assertCountEquals(0)
        composeTestRule.onAllNodesWithContentDescription("Filled Star")
            .assertCountEquals(1)
    }

    @Test
    fun passThreePointFiveValue_Assert_FourFilledStars_and_OneEmptyStar() {
        composeTestRule.setContent {
            RatingWidget(
                modifier = Modifier.padding(end = SMALL_PADDING_10),
                rating = 3.5
            )
        }
        composeTestRule.onAllNodesWithContentDescription("Empty Star")
            .assertCountEquals(1)
        composeTestRule.onAllNodesWithContentDescription("Half Filled Star")
            .assertCountEquals(1)
        composeTestRule.onAllNodesWithContentDescription("Filled Star")
            .assertCountEquals(3)
    }

    @Test
    fun passFourPointZeroValue_Assert_FourFilledStars_and_OneHalfFilledStar_and_OneEmptyStar() {
        composeTestRule.setContent {
            RatingWidget(
                modifier = Modifier.padding(end = SMALL_PADDING_10),
                rating = 4.0
            )
        }
        composeTestRule.onAllNodesWithContentDescription("Empty Star")
            .assertCountEquals(1)
        composeTestRule.onAllNodesWithContentDescription("Half Filled Star")
            .assertCountEquals(0)
        composeTestRule.onAllNodesWithContentDescription("Filled Star")
            .assertCountEquals(4)
    }

    @Test
    fun passFourPointFourValue_Assert_FourFilledStars_and_OneHalfFilledStar() {
        composeTestRule.setContent {
            RatingWidget(
                modifier = Modifier.padding(end = SMALL_PADDING_10),
                rating = 4.4
            )
        }
        composeTestRule.onAllNodesWithContentDescription("Empty Star")
            .assertCountEquals(0)
        composeTestRule.onAllNodesWithContentDescription("Half Filled Star")
            .assertCountEquals(1)
        composeTestRule.onAllNodesWithContentDescription("Filled Star")
            .assertCountEquals(4)
    }

    @Test
    fun passNegativeValue_Assert_FiveEmptyStars() {
        composeTestRule.setContent {
            RatingWidget(
                modifier = Modifier.padding(end = SMALL_PADDING_10),
                rating = -1.5
            )
        }
        composeTestRule.onAllNodesWithContentDescription("Empty Star")
            .assertCountEquals(5)
        composeTestRule.onAllNodesWithContentDescription("Half Filled Star")
            .assertCountEquals(0)
        composeTestRule.onAllNodesWithContentDescription("Filled Star")
            .assertCountEquals(0)
    }

    @Test
    fun passIncorrectValue_Assert_FiveFilledStars() {
        composeTestRule.setContent {
            RatingWidget(
                modifier = Modifier.padding(end = SMALL_PADDING_10),
                rating = 5.2
            )
        }
        composeTestRule.onAllNodesWithContentDescription("Empty Star")
            .assertCountEquals(5)
        composeTestRule.onAllNodesWithContentDescription("Half Filled Star")
            .assertCountEquals(0)
        composeTestRule.onAllNodesWithContentDescription("Filled Star")
            .assertCountEquals(0)
    }
}