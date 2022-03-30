package com.ui.espresso

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.ui.espresso.bases.TestBase
import com.ui.espresso.screens.MainScreen
import com.ui.espresso.screens.TypeTextDisplayScreen
import com.ui.espresso.screens.TypeTextScreen
import org.junit.Before
import org.junit.Test

/**
 * @author  HDunn, Modified on 4/30/21.
 */
class EnterNameTest : TestBase() {
    @Before
    fun navigateToTypeText() {
        // From Main navigate to type text
        MainScreen.tapTypeTextButton()
    }

    @Test
    fun testHintDisplayed() {
        TypeTextScreen.verifyHintDisplayed
    }

    @Test
    fun testErrorMessageDisplayed() {
        // Making sure the error message is not displayed by default
        TypeTextScreen.verifyErrorTextNotDisplayed

        // Click on "Next" button
        TypeTextScreen.tapNextButton()

        // Now check the error message is displayed
        TypeTextScreen.verifyErrorTextDisplayed
    }

    @Test
    fun testGreetingMessageWithNameDisplayed() {
        TypeTextScreen.insertUserName()
        TypeTextScreen.tapNextButton()
        TypeTextDisplayScreen.verifyGreetingText
    }

}
