package com.example.labapp

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class CartScreenTest {
    @get:Rule val rule = createComposeRule()

    @Test fun plusUpdatesSubtotal() {
        rule.setContent { CartScreen() }
        rule.onAllNodesWithText("+")[0].performClick()
        rule.onNodeWithTag("sub").assertTextEquals("Subtotal: Rs.500")
    }

    @Test fun minusStopsAtZero() {
        rule.setContent { CartScreen() }
        rule.onAllNodesWithText("-")[0].performClick()
        rule.onNodeWithTag("qty0").assertTextEquals("0")
    }

    @Test fun wrongCodeShowsInvalid() {
        rule.setContent { CartScreen() }
        rule.onNodeWithTag("code").performTextInput("ABC")
        rule.onNodeWithText("Invalid code").assertIsDisplayed()
    }
}
