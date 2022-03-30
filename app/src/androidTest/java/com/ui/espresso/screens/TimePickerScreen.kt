package com.ui.espresso.screens

import android.widget.TimePicker
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.PickerActions.setTime
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withClassName
import org.hamcrest.Matchers.equalTo

object TimePickerScreen {

    //Constants-------------------------------------------------------------------------------------
    private const val BUTTON1 = android.R.id.button1

    //Action methods--------------------------------------------------------------------------------
    fun selectHourandMinute(hour:Int, minutes:Int){
        onView(withClassName(equalTo(TimePicker::class.java.name))).perform(setTime(hour, minutes))
    }

    fun tapOkButton(){
        onView(withId(BUTTON1)).perform(ViewActions.click())
    }
}