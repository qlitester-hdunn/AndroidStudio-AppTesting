package com.ui.espresso.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.ui.espresso.R
import com.ui.espresso.constants.Strings
import org.hamcrest.CoreMatchers.not

object TypeText {

    // region | Constants --------------------------------------------------------------------------
    private const val NAME_EDITTEXT: Int = R.id.name_edittext
    private const val ENTER_NAME: Int = R.string.enter_name
    private const val ERROR_TEXT: Int = R.id.error_text
    private const val NEXT_BUTTON: Int = R.id.next_button
    private const val GREETING_MESSAGE: Int = R.id.greeting_message

    // endregion

    // region | Action Methods ---------------------------------------------------------------------
    fun clickNextButton() {
        onView(withId(NEXT_BUTTON)).perform(click())
    }

    fun typeInEnterNameTextEdit() {
        onView(withId(NAME_EDITTEXT)).perform(typeText(Strings.USER_NAME))
    }

    // endregion

    // region | Assertion Properties ---------------------------------------------------------------
    val verifyErrorMessageIsDisplayed: ViewInteraction
       get()= onView(withId(ERROR_TEXT)).check(matches(isDisplayed()))

    val verifyErrorMessageIsNotDisplayed: ViewInteraction
       get()= onView(withId(ERROR_TEXT)).check(matches(not(isDisplayed())))

    val verifyHintIsDisplayed: ViewInteraction
       get()= onView(withId(NAME_EDITTEXT)).check(matches(withHint(ENTER_NAME)))

    val verifyGreetingMessageMatches: ViewInteraction
       get()= onView(withId(GREETING_MESSAGE)).check(matches(withText(Strings.GREETING_MESSAGE)))

    // endregion
}
