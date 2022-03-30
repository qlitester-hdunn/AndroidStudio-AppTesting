package com.ui.espresso

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.ui.espresso.bases.TestBase
import com.ui.espresso.screens.DialogPopUpScreen
import com.ui.espresso.screens.DialogScreen
import com.ui.espresso.screens.MainScreen
import org.junit.Before
import org.junit.Test

/**
 * @author  HDunn, Modified on 4/30/21.
 */
class DialogTests : TestBase() {
    @Before
    fun navigateToDialogs() {
        // From Main navigate to Dialog Activity
        MainScreen.tapDialogButton()
    }

    @Test
    fun testCheckDialogDisplayed() {
        // Click on the button that shows the dialog
        DialogScreen.tapShowDialogButton()

        // Check the dialog title text is displayed
        DialogPopUpScreen.verifyTitleDisplayed
    }

    @Test
    fun testClickOkButton() {
        DialogScreen.tapShowDialogButton()

        // android.R.id.button1 = positive button
        DialogPopUpScreen.tapOkButton()
        DialogScreen.verifyOkText
    }

    @Test
    fun testClickCancelButton() {
        DialogScreen.tapShowDialogButton()

        // android.R.id.button2 = negative button
        DialogPopUpScreen.tapCancelButton()
        DialogScreen.verifyCancelText
    }
}
