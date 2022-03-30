package com.ui.espresso.screens

import android.widget.EditText
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import com.ui.espresso.R
import com.ui.espresso.activities.MainActivity
import com.ui.espresso.constants.Strings
import com.ui.espresso.matchers.CustomMatchers.withItemContent
import org.hamcrest.CoreMatchers.*
import org.hamcrest.Matchers.not

object SearchViewScreen {

    var activity: MainActivity? = null

    //Constants-------------------------------------------------------------------------------------
    private const val ACTION_SEARCH = R.id.action_search
    private const val EMPTY_VIEW = R.id.empty_view

    //Matchers--------------------------------------------------------------------------------------
    private val searchResultsMatcher
        get() = allOf(`is`(instanceOf(String::class.java)),withItemContent(Strings.HELSINKI))

    private val suggestionMatcher
        get() = withDecorView(not(`is`(activity!!.window.decorView)))

    //Action methods--------------------------------------------------------------------------------
    fun tapSearchButton(){
        onView(withId(ACTION_SEARCH)).perform(click())
    }

    fun searchInvalidSearch(){
        onView(isAssignableFrom(EditText::class.java)).perform(
                typeText(Strings.INVALID_SEARCH), pressImeActionButton())
    }

    fun searchValidSearch(){
        onView(isAssignableFrom(EditText::class.java)).perform(
                typeText(Strings.HELSINKI), pressImeActionButton())
    }

    fun enterPartialSearch(){
        onView(isAssignableFrom(EditText::class.java))
                .perform(typeText(Strings.PARTIAL_SEARCH_TERM))
    }

    fun clearSearchBar(){
        onView(isAssignableFrom(EditText::class.java)).perform(clearText())
    }

    fun tapSearchSuggestion(){
        onView(withText(Strings.HELSINKI)).inRoot(suggestionMatcher).perform(click())
    }

    //Assertion properties
    val verifyEmptyViewDisplayed:ViewInteraction
        get() = onView(withId(EMPTY_VIEW)).check(matches(isDisplayed()))

    val verifyEmptyViewNotDisplayed:ViewInteraction
        get() = onView(withId(EMPTY_VIEW)).check(matches(not(isDisplayed())))

    val verifySearchItemDisplayed:ViewInteraction
        get() = onData(searchResultsMatcher).check(matches(isDisplayed()))

    val verifySearchSuggestionDisplayed:ViewInteraction
        get() = onView(withText(Strings.HELSINKI)).inRoot(suggestionMatcher).check(matches(
                isDisplayed()))

}