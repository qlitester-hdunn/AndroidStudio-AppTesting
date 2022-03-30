package com.ui.espresso.screens

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.ui.espresso.R
import com.ui.espresso.constants.Strings

object DialogScreen {

    //Constants-------------------------------------------------------------------------------------
    private const val CONFIRM_DIALOG_BUTTON = R.id.confirm_dialog_button
    private const val STATUS_TEXT = R.id.status_text

    //Action methods--------------------------------------------------------------------------------
    fun tapShowDialogButton(){
        onView(withId(CONFIRM_DIALOG_BUTTON)).perform(click())
    }

    //Assertion Properties--------------------------------------------------------------------------
    val verifyOkText
        get() = onView(withId(STATUS_TEXT)).check(matches(withText(Strings.OK)))

    val verifyCancelText
        get() = onView(withId(STATUS_TEXT)).check(matches(withText(Strings.CANCEL)))
}