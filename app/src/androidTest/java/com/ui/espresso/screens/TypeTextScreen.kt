package com.ui.espresso.screens

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.ui.espresso.EnterNameTest
import com.ui.espresso.R
import com.ui.espresso.constants.Strings
import org.hamcrest.CoreMatchers.not

object TypeTextScreen {

    //Constants-------------------------------------------------------------------------------------
    private const val NAME_EDITTEXT = R.id.name_edittext
    private const val NEXT_BUTTON = R.id.next_button

    //Action methods--------------------------------------------------------------------------------
    fun insertUserName(){
        onView(withId(NAME_EDITTEXT)).perform(typeText(Strings.USER_NAME))
    }

    fun tapNextButton(){
        onView(withId(NEXT_BUTTON)).perform(click())
    }

    //Assertion Properties--------------------------------------------------------------------------
    val verifyHintDisplayed: ViewInteraction
        get() = onView(withId(NAME_EDITTEXT)).check(matches(withHint(Strings.ENTER_NAME)))

    val verifyErrorTextDisplayed: ViewInteraction
        get() = onView(withId(R.id.error_text)).check(matches(isDisplayed()))

    val verifyErrorTextNotDisplayed: ViewInteraction
        get() = onView(withId(R.id.error_text)).check(matches(not(isDisplayed())))
}