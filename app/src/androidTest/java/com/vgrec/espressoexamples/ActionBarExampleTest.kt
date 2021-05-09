package com.vgrec.espressoexamples

import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.vgrec.espressoexamples.bases.TestBase
import org.junit.Test

/**
 * @author  HDunn, Modified on 4/30/21.
 */
class ActionBarExampleTest : TestBase() {
    @Test
    fun testClickOnMenuItem() {

        // From Main navigate to ActionBar
        Espresso.onView(ViewMatchers.withId(R.id.action_bar_button)).perform(ViewActions.click())

        // Click on an item from ActionBar
        Espresso.onView(ViewMatchers.withId(R.id.action_settings)).perform(ViewActions.click())

        // Verify the correct item was clicked by checking the content of the status TextView
        Espresso.onView(ViewMatchers.withId(R.id.status)).check(ViewAssertions.matches(ViewMatchers.withText("Settings")))
    }

    @Test
    fun testOverflowMenuOrOptionsMenu() {

        // From Main navigate to ActionBar
        Espresso.onView(ViewMatchers.withId(R.id.action_bar_button)).perform(ViewActions.click())

        // Open the action bar overflow or options menu (depending if the device has or not a hardware menu button.)
        Espresso.openActionBarOverflowOrOptionsMenu(ApplicationProvider.getApplicationContext())

        // Find the menu item with text "About" and click on it
        Espresso.onView(ViewMatchers.withText("About")).perform(ViewActions.click())

        // Verify the correct item was clicked by checking the content of the status TextView
        Espresso.onView(ViewMatchers.withId(R.id.status)).check(ViewAssertions.matches(ViewMatchers.withText("About")))
    }

    @Test
    fun testActionMode() {
        // From Main navigate to ActionBar
        Espresso.onView(ViewMatchers.withId(R.id.action_bar_button)).perform(ViewActions.click())

        // Show the contextual ActionBar
        Espresso.onView(ViewMatchers.withId(R.id.toggle_action_mode)).perform(ViewActions.click())

        // Click on a context item
        Espresso.onView(ViewMatchers.withId(R.id.action_one)).perform(ViewActions.click())

        // Verify the correct item was clicked by checking the content of the status TextView
        Espresso.onView(ViewMatchers.withId(R.id.status)).check(ViewAssertions.matches(ViewMatchers.withText("ActionMode1")))
    }
}
