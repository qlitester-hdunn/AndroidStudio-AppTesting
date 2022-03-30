package com.ui.espresso

import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.ui.espresso.bases.TestBase
import com.ui.espresso.screens.ActionBarScreen
import com.ui.espresso.screens.MainScreen
import org.junit.Test

/**
 * @author  HDunn, Modified on 4/30/21.
 */
class ActionBarExampleTest : TestBase() {
    @Test
    fun testClickOnMenuItem() {

        // From Main navigate to ActionBar
        MainScreen.tapActionBarButton()

        // Click on an item from ActionBar
        ActionBarScreen.tapSettingsMenu()

        // Verify the correct item was clicked by checking the content of the status TextView
        ActionBarScreen.verifySettingsText
    }

    @Test
    fun testOverflowMenuOrOptionsMenu() {

        // From Main navigate to ActionBar
        MainScreen.tapActionBarButton()

        // Open the action bar overflow or options menu (depending if the device has or not a hardware menu button.)
        ActionBarScreen.openOverflowOrOptionsMenu()

        // Find the menu item with text "About" and click on it
        ActionBarScreen.tapAboutOption()

        // Verify the correct item was clicked by checking the content of the status TextView
        ActionBarScreen.verifyAboutText
    }

    @Test
    fun testActionMode() {
        // From Main navigate to ActionBar
        MainScreen.tapActionBarButton()

        // Show the contextual ActionBar
        ActionBarScreen.showContextualActionBar()

        // Click on a context item
        ActionBarScreen.tapContextItem()

        // Verify the correct item was clicked by checking the content of the status TextView
        ActionBarScreen.verifyActionMode1
    }
}
