package com.ui.espresso

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.ui.espresso.bases.TestBase
import org.junit.Before
import org.junit.Test

/**
 * @author  HDunn, Modified on 4/30/21.
 */
class DialogTests : TestBase() {
    @Before
    fun navigateToDialogs() {
        // From Main navigate to date time pickers
        Espresso.onView(ViewMatchers.withId(R.id.dialogs_button)).perform(ViewActions.click())
    }

    @Test
    fun testCheckDialogDisplayed() {
        // Click on the button that shows the dialog
        Espresso.onView(ViewMatchers.withId(R.id.confirm_dialog_button)).perform(ViewActions.click())

        // Check the dialog title text is displayed
        Espresso.onView(ViewMatchers.withText(R.string.dialog_title)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testClickOkButton() {
        Espresso.onView(ViewMatchers.withId(R.id.confirm_dialog_button)).perform(ViewActions.click())

        // android.R.id.button1 = positive button
        Espresso.onView(ViewMatchers.withId(android.R.id.button1)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.status_text)).check(ViewAssertions.matches(ViewMatchers.withText(R.string.ok)))
    }

    fun testClickCancelButton() {
        Espresso.onView(ViewMatchers.withId(R.id.confirm_dialog_button)).perform(ViewActions.click())

        // android.R.id.button2 = negative button
        Espresso.onView(ViewMatchers.withId(android.R.id.button2)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.status_text)).check(ViewAssertions.matches(ViewMatchers.withText(R.string.cancel)))
    }
}
