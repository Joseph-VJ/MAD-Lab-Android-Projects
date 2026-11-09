package com.example.notetestingapp

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class NoteScreenTest {
    @get:Rule val composeRule = createComposeRule()

    @Test
    fun addNoteButtonIsDisplayed() {
        composeRule.setContent { NoteScreen() }
        composeRule.onNodeWithText("Add Note").assertIsDisplayed()
    }

    @Test
    fun addingNoteShowsSavedNote() {
        composeRule.setContent { NoteScreen() }
        composeRule.onNodeWithTag("noteInput").performTextInput("Lab record")
        composeRule.onNodeWithText("Add Note").performClick()
        composeRule.onNodeWithTag("savedNote").assertIsDisplayed()
    }
}
