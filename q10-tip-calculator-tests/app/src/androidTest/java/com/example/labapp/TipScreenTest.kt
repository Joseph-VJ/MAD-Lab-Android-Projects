package com.example.labapp

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class TipScreenTest {
    @get:Rule val rule = createComposeRule()

    @Test
    fun showsTipAndTotal() {
        rule.setContent { TipScreen() }
        rule.onNodeWithTag("bill").performTextInput("200")
        rule.onNodeWithText("20%").performClick()
        rule.onNodeWithTag("tip").assertTextEquals("Tip: 40.00")
        rule.onNodeWithTag("total").assertTextEquals("Total: 240.00")
    }
}
