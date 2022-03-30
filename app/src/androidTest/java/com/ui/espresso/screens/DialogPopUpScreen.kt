package com.ui.espresso.screens

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.ui.espresso.R
import com.ui.espresso.constants.Strings

object DialogPopUpScreen {

    //Constants-------------------------------------------------------------------------------------
    private const val BUTTON1 = android.R.id.button1
    private const val BUTTON2 = android.R.id.button2

    //Action Methods--------------------------------------------------------------------------------
    fun tapOkButton(){
        onView(withId(BUTTON1)).perform(click())
    }

    fun tapCancelButton(){
        onView(withId(BUTTON2)).perform(click())
    }

    //Assertion Properties--------------------------------------------------------------------------
    val verifyTitleDisplayed
        get() = onView(withText(Strings.PLEASE_CONFIRM)).check(matches(isDisplayed()))

}