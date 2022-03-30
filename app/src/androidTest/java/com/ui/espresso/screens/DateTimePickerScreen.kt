package com.ui.espresso.screens

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.ui.espresso.R

object DateTimePickerScreen {

    //Constants-------------------------------------------------------------------------------------
    private const val DATE_PICKER_BUTTON = R.id.date_picker_button
    private const val STATUS = R.id.status
    private const val TIME_PICKER_BUTTON = R.id.time_picker_button

    //Action methods--------------------------------------------------------------------------------
    fun tapDatePickerButton(){
        onView(withId(DATE_PICKER_BUTTON)).perform(click())
    }

    fun tapTimePickerButton(){
        onView(withId(TIME_PICKER_BUTTON)).perform(click())
    }

    //Assertion Functions
    fun verifyDate(year:Int,month:Int,day:Int){
        onView(withId(STATUS)).check(matches(withText("$year/$month/$day")))
    }

    fun verifyTime(hour:Int,minutes:Int){
        onView(withId(STATUS)).check(matches(withText("$hour:$minutes")))
    }

}