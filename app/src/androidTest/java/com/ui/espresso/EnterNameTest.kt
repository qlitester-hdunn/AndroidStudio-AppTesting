package com.ui.espresso

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ui.espresso.bases.TestBase
import com.ui.espresso.screens.LandingPage
import com.ui.espresso.screens.TypeText
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author  HDunn, Modified on 4/30/21.
 */
@RunWith(AndroidJUnit4::class)
class EnterNameTest : TestBase() {

    @Test
    fun testHintDisplayed() {
        // From Main navigate to type text
        LandingPage.getTypeTextScreen()

        // Verify placeholder text is displayed
        TypeText.verifyHintIsDisplayed
    }

    @Test
    fun testErrorMessageDisplayed() {
        // From Main navigate to type text
        LandingPage.getTypeTextScreen()

        // Making sure the error message is not displayed by default
        TypeText.verifyErrorMessageIsNotDisplayed

        // Click on "Next" button
        TypeText.clickNextButton()

        // Now check the error message is displayed
        TypeText.verifyErrorMessageIsDisplayed
    }

    @Test
    fun testGreetingMessageWithNameDisplayed() {
        // From Main navigate to type text
        LandingPage.getTypeTextScreen()

        // Enter name in text edit field
        TypeText.typeInEnterNameTextEdit()

        // Click on "Next" button
        TypeText.clickNextButton()

        // Check the greeting message matches what's expected
        TypeText.verifyGreetingMessageMatches
    }
}
