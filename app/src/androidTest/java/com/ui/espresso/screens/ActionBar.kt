package com.ui.espresso.screens

import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.ui.espresso.R
import com.ui.espresso.constants.Strings

object ActionBar {

    // region | Constants --------------------------------------------------------------------------
    private const val ACTION_SETTINGS = R.id.action_settings
    private const val STATUS = R.id.status
    private const val TOGGLE_ACTION_MODE = R.id.toggle_action_mode
    private const val ACTION_ONE = R.id.action_one

    // endregion

    // region | Action Methods ---------------------------------------------------------------------
    fun tapOnActionsMenuButton() {
        openActionBarOverflowOrOptionsMenu(ApplicationProvider.getApplicationContext())
    }

    fun tapOnActionBarSettingsButton() {
        onView(withId(ACTION_SETTINGS)).perform(click())
    }

    fun tapOnMenuItemAbout() {
        onView(withText(Strings.ABOUT)).perform(click())
    }

    fun tapOnActionModeOneItem() {
        onView(withId(ACTION_ONE)).perform(click())
    }

    fun tapOnToggleActionModeButton() {
        onView(withId(TOGGLE_ACTION_MODE)).perform(click())
    }

    // endregion

    // region | Assertion Properties ---------------------------------------------------------------
    val verifySettingsText: ViewInteraction
        get()= onView(withId(STATUS)).check(matches(withText(Strings.SETTINGS)))

    val verifyAboutText: ViewInteraction
        get()= onView(withId(STATUS)).check(matches(withText(Strings.ABOUT)))

    val verifyActionMode1Text: ViewInteraction
        get()= onView(withId(STATUS)).check(matches(withText(Strings.ACTION_MODE_1)))

    // endregion
}
