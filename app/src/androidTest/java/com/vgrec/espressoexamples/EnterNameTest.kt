package com.vgrec.espressoexamples

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.vgrec.espressoexamples.bases.TestBase
import org.hamcrest.CoreMatchers
import org.junit.Before
import org.junit.Test

/**
 * @author  HDunn, Modified on 4/30/21.
 */
class EnterNameTest : TestBase() {
    @Before
    fun navigateToTypeText() {
        // From Main navigate to type text
        Espresso.onView(ViewMatchers.withId(R.id.type_text_button)).perform(ViewActions.click())
    }

    @Test
    fun testHintDisplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.name_edittext)).check(ViewAssertions.matches(ViewMatchers.withHint(R.string.enter_name)))
    }

    @Test
    fun testErrorMessageDisplayed() {
        // Making sure the error message is not displayed by default
        Espresso.onView(ViewMatchers.withId(R.id.error_text)).check(ViewAssertions.matches(CoreMatchers.not(ViewMatchers.isDisplayed())))

        // Click on "Next" button
        Espresso.onView(ViewMatchers.withId(R.id.next_button)).perform(ViewActions.click())

        // Now check the error message is displayed
        Espresso.onView(ViewMatchers.withId(R.id.error_text)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testGreetingMessageWithNameDisplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.name_edittext)).perform(ViewActions.typeText(USER_NAME))
        Espresso.onView(ViewMatchers.withId(R.id.next_button)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.greeting_message)).check(ViewAssertions.matches(ViewMatchers.withText(GREETING_MESSAGE)))
    }

    companion object {
        const val USER_NAME = "John"
        const val GREETING_MESSAGE = "Hello " + USER_NAME + "!"
    }
}
