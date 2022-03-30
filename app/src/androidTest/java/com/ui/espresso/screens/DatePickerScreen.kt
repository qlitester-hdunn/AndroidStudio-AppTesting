package com.ui.espresso.screens

import android.widget.DatePicker
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.PickerActions.setDate
import androidx.test.espresso.matcher.ViewMatchers.withClassName
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Matchers.equalTo

object DatePickerScreen {

    //Constants-------------------------------------------------------------------------------------
    private const val BUTTON1 = android.R.id.button1

    //Action methods
    fun selectYearMonthDay(year:Int,month:Int,day:Int){
        onView(withClassName(equalTo(DatePicker::class.java.name)))
                .perform(setDate(year, month + 1, day))
    }

    fun tapOkButton(){
        onView(withId(BUTTON1)).perform(click())
    }

}