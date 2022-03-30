package com.ui.espresso.screens

import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.ui.espresso.R
import com.ui.espresso.constants.Strings

object ActionBarScreen {

    //Constants-------------------------------------------------------------------------------------
    private const val ACTION_SETTINGS = R.id.action_settings
    private const val STATUS = R.id.status
    private const val TOGGLE_ACTION_MODE = R.id.toggle_action_mode
    private const val ACTION_ONE = R.id.action_one

    //Action methods--------------------------------------------------------------------------------
    fun openOverflowOrOptionsMenu(){
        openActionBarOverflowOrOptionsMenu(ApplicationProvider.getApplicationContext())
    }

    fun showContextualActionBar(){
        onView(withId(TOGGLE_ACTION_MODE)).perform(click())
    }

    fun tapAboutOption(){
        onView(withText(Strings.ABOUT)).perform(click())
    }

    fun tapContextItem(){
        onView(withId(ACTION_ONE)).perform(click())
    }

    fun tapSettingsMenu(){
        onView(withId(ACTION_SETTINGS)).perform(click())
    }

    //Assertion properties--------------------------------------------------------------------------
    val verifySettingsText
        get() = onView(withId(STATUS)).check(matches(withText(Strings.SETTINGS)))

    val verifyAboutText
        get() = onView(withId(STATUS)).check(matches(withText(Strings.ABOUT)))

    val verifyActionMode1
        get() = onView(withId(STATUS)).check(matches(withText(Strings.ACTIONMODE1)))
}