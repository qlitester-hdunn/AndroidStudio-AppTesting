package com.ui.espresso.screens

import android.widget.ListView
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.ui.espresso.R
import com.ui.espresso.datamodels.Person
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.instanceOf


object PersonListScreen {

    var person = Person()

    //Constants-------------------------------------------------------------------------------------
    private const val PERSON_AGE = R.id.person_age
    private const val PERSON_MESSAGES = R.id.person_messages

    //Matchers--------------------------------------------------------------------------------------
    private val cardMatcher
        get() = allOf(instanceOf(RelativeLayout::class.java), hasDescendant(withText(person.name)),
            isDescendantOfA(instanceOf(ListView::class.java)))

    private val iconMatcher
        get() = allOf(instanceOf(AppCompatImageView::class.java), hasSibling(withText(person.name)))

    private val ageMatcher
        get() = allOf(withId(PERSON_AGE), hasSibling(withText(person.name)))

    private val messageMatcher
        get() = allOf(withId(PERSON_MESSAGES), hasSibling(withText(person.name)))

    //Action methods--------------------------------------------------------------------------------
    fun tapPerson(){
        onView(cardMatcher).perform(click())
    }

    //Assertion properties--------------------------------------------------------------------------
    val verifyIconDisplayed: ViewInteraction
        get() = onView(iconMatcher).check(matches(isDisplayed()))

    val verifyAgeText: ViewInteraction
        get() = onView(ageMatcher).check(matches(withText("by ${person.age}")))

    val verifyMessageText: ViewInteraction
        get() = onView(messageMatcher).check(matches(withText("say ${person.message}")))
}