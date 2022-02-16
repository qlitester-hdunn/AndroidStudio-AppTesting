package com.ui.espresso

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ui.espresso.bases.TestBase
import com.ui.espresso.screens.ActionBar
import com.ui.espresso.screens.LandingPage
import org.junit.Test
import org.junit.runner.RunWith
import timber.log.Timber

/**
 * @author  HDunn, Modified on 4/30/21.
 */
@RunWith(AndroidJUnit4::class)
class ActionBarExampleTest : TestBase() {

    @Test
    fun testClickOnMenuItem() {
        Timber.d("Tapping on the action settings button displays settings")

        // From LandingPage navigate to ActionBar
        LandingPage.getActionBarScreen()

        // Find the settings button in the action bar and click on it
        ActionBar.tapOnActionBarSettingsButton()

        // Verify the correct item was clicked by checking the content of the status TextView
        ActionBar.verifySettingsText
    }

    @Test
    fun testOverflowMenuOrOptionsMenu() {
        Timber.d("Tapping on the about button in action bar options menu displays about")

        // From LandingPage navigate to ActionBar
        LandingPage.getActionBarScreen()

        // Open the action bar overflow or options menu (depending if the device has or not a hardware menu button.)
        ActionBar.tapOnActionsMenuButton()

        // Find the menu item with text "About" and click on it
        ActionBar.tapOnMenuItemAbout()

        // Verify the correct item was clicked by checking the content of the status TextView
        ActionBar.verifyAboutText
    }

    @Test
    fun testActionMode() {
        Timber.d("Tapping on the toggle action mode buttons displays ActionMode1")

        // From LandingPage navigate to ActionBar
        LandingPage.getActionBarScreen()

        // Show the contextual ActionBar
        ActionBar.tapOnToggleActionModeButton()

        // Click on a context item
        ActionBar.tapOnActionModeOneItem()

        // Verify the correct item was clicked by checking the content of the status TextView
        ActionBar.verifyActionMode1Text
    }
}
