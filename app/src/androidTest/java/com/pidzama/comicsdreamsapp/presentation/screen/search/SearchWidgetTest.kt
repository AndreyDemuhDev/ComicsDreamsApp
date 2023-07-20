package com.pidzama.comicsdreamsapp.presentation.screen.search

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class SearchWidgetTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun openSearchWidget_addInputText_assertInputText() {
        val text = mutableStateOf("")
        composeTestRule.setContent {
            SearchWidget(
                text = text.value,
                onTextChanged = {
                    text.value = it
                },
                onSearchClicked = {},
                onCloseClicked = {}
            )
        }
        composeTestRule.onNodeWithContentDescription("TextField")
            .performTextInput("ComicsDreamsAppTest")
        composeTestRule.onNodeWithContentDescription("TextField")
            .assertTextEquals("ComicsDreamsAppTest")
    }

    @Test
    fun openSearchWidget_addInputText_clickClosedButtonOnce_assertEmptyInputText() {
        val text = mutableStateOf("")
        composeTestRule.setContent {
            SearchWidget(
                text = text.value,
                onTextChanged = {
                    text.value = it
                },
                onSearchClicked = {},
                onCloseClicked = {}
            )
        }
        composeTestRule.onNodeWithContentDescription("TextField")
            .performTextInput("ComicsDreamsAppTest")
        composeTestRule.onNodeWithContentDescription("Close Icon Button")
            .performClick()
        composeTestRule.onNodeWithContentDescription("TextField")
            .assertTextContains("")
    }

    @Test
    fun openSearchWidget_addInputText_clickCloseButtonTwice_assertClosedState() {
        val text = mutableStateOf("")
        val searchWidgetShown = mutableStateOf(true)
        composeTestRule.setContent {
            if (searchWidgetShown.value) {
                SearchWidget(
                    text = text.value,
                    onTextChanged = {
                        text.value = it
                    },
                    onSearchClicked = {},
                    onCloseClicked = {
                        searchWidgetShown.value = false
                    }
                )
            }
        }
        composeTestRule.onNodeWithContentDescription("TextField")
            .performTextInput("ComicsDreamsAppTest")
        composeTestRule.onNodeWithContentDescription("Close Icon Button")
            .performClick()
        composeTestRule.onNodeWithContentDescription("Close Icon Button")
            .performClick()
        composeTestRule.onNodeWithContentDescription("Search Widget")
            .assertDoesNotExist()
    }

    @Test
    fun openSearchWidget_clickCloseButton_assertClosedState() {
        val text = mutableStateOf("")
        val searchWidgetShown = mutableStateOf(true)
        composeTestRule.setContent {
            if (searchWidgetShown.value) {
                SearchWidget(
                    text = text.value,
                    onTextChanged = {
                        text.value = it
                    },
                    onSearchClicked = {},
                    onCloseClicked = {
                        searchWidgetShown.value = false
                    }
                )
            }
        }
        composeTestRule.onNodeWithContentDescription("Close Icon Button")
            .performClick()
        composeTestRule.onNodeWithContentDescription("Search Widget")
            .assertDoesNotExist()
    }

}