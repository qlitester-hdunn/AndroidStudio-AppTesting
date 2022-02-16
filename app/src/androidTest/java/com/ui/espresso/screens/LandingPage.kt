package com.ui.espresso.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.ui.espresso.constants.Strings

object LandingPage {

    // region | Action Methods --------------------------------------------------------------------------
    fun tapActionBarScreen() {
        onView(withText(Strings.ACTION_BAR)).perform(click())
    }

    fun tapTypeTextScreen() {
        onView(withText(Strings.TYPE_TEXT)).perform(click())
    }

    // endregion
}
