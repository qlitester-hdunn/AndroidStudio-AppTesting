package com.ui.espresso.screens

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.ui.espresso.R
import com.ui.espresso.SpinnerSelectionTest
import com.ui.espresso.constants.Strings
import com.ui.espresso.matchers.CustomMatchers.withAdaptedData
import com.ui.espresso.matchers.CustomMatchers.withItemContent
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.Matchers
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.instanceOf
import org.hamcrest.Matchers.not

object SpinnerScreen {

    //Constants-------------------------------------------------------------------------------------
    private const val COUNTRIES_SPINNER = R.id.countries_spinner
    private const val COUNTRY_LABEL = R.id.country_label

    //Matchers--------------------------------------------------------------------------------------
    private val countryMatcher
        get() = allOf(`is`(instanceOf<Any>(String::class.java)),`is`(Strings.MOLDOVA))

    //Action Methods--------------------------------------------------------------------------------
    fun tapSpinner(){
        onView(withId(COUNTRIES_SPINNER)).perform(click())
    }

    fun tapFirstItem(){
        onData(allOf(`is`(instanceOf(String::class.java)))).atPosition(0).perform(click())
    }

    fun tapCountry(){
        onData(countryMatcher).perform(click())
    }

    //Assertion properties--------------------------------------------------------------------------
    val verifyCountyNotInList
        get() = onView(withId(COUNTRIES_SPINNER)).check(matches(not(withAdaptedData(
                withItemContent(Strings.NOT_A_COUNTRY)))))

    val verifySpinnerDefaultText
        get() = onView(withId(COUNTRY_LABEL)).check(matches(not(withText(Strings.FIRST_ITEM_TEXT))))

    val verifyCountrySelected
        get() = onView(withId(COUNTRY_LABEL)).check(matches(withText(Strings.MOLDOVA)))
}