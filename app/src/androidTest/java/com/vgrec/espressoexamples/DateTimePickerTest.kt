package com.vgrec.espressoexamples

import android.widget.DatePicker
import android.widget.TimePicker
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.PickerActions
import androidx.test.espresso.matcher.ViewMatchers
import com.vgrec.espressoexamples.bases.TestBase
import org.hamcrest.Matchers
import org.junit.Test

/**
 * @author  HDunn, Modified on 4/30/21.
 */
class DateTimePickerTest : TestBase() {
    @Test
    fun testSetDate() {
        val year = 2020
        val month = 11
        val day = 15

        // From Main navigate to date time pickers
        Espresso.onView(ViewMatchers.withId(R.id.pickers_button)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.date_picker_button)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withClassName(Matchers.equalTo(DatePicker::class.java.name))).perform(PickerActions.setDate(year, month + 1, day))
        Espresso.onView(ViewMatchers.withId(android.R.id.button1)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.status)).check(ViewAssertions.matches(ViewMatchers.withText("$year/$month/$day")))
    }

    @Test
    fun testSetTime() {
        val hour = 10
        val minutes = 59

        // From Main navigate to date time pickers
        Espresso.onView(ViewMatchers.withId(R.id.pickers_button)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.time_picker_button)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withClassName(Matchers.equalTo(TimePicker::class.java.name))).perform(PickerActions.setTime(hour, minutes))
        Espresso.onView(ViewMatchers.withId(android.R.id.button1)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.status)).check(ViewAssertions.matches(ViewMatchers.withText("$hour:$minutes")))
    }
}
