package com.ui.espresso.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.ui.espresso.R
import com.ui.espresso.constants.Strings
import com.ui.espresso.datamodels.Person

object PersonDetailScreen {

    var person = Person()

    //Constants-------------------------------------------------------------------------------------
    private const val PERSON_NAME = R.id.person_name
    private const val PERSON_AGE = R.id.person_age
    private const val PERSON_MESSAGES = R.id.person_messages

    //Action Methods--------------------------------------------------------------------------------

    //Assertion Properties--------------------------------------------------------------------------
    val verifyPersonNameText:ViewInteraction
        get() = onView(withId(PERSON_NAME)).check(matches(withText(person.name)))

    val verifyPersonAgeText:ViewInteraction
        get() = onView(withId(PERSON_AGE)).check(matches(withText(person.age)))

    val verifyPersonMessageText:ViewInteraction
        get() = onView(withId(PERSON_MESSAGES)).check(matches(withText(person.message)))

}