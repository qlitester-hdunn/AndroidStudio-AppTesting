package com.ui.espresso.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.ui.espresso.EnterNameTest
import com.ui.espresso.R
import com.ui.espresso.constants.Strings

object TypeTextDisplayScreen {

    //Constants-------------------------------------------------------------------------------------
    private const val GREETING_MESSAGE = R.id.greeting_message

    //Action methods--------------------------------------------------------------------------------

    //Assertion properties--------------------------------------------------------------------------
    val verifyGreetingText
        get() = onView(withId(GREETING_MESSAGE)).check(ViewAssertions.matches((withText(Strings.GREETING_MESSAGE))))

}