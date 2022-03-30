package com.ui.espresso

import android.widget.DatePicker
import android.widget.TimePicker
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.PickerActions
import androidx.test.espresso.matcher.ViewMatchers
import com.mifmif.common.regex.Main
import com.ui.espresso.bases.TestBase
import com.ui.espresso.screens.DatePickerScreen
import com.ui.espresso.screens.DateTimePickerScreen
import com.ui.espresso.screens.MainScreen
import com.ui.espresso.screens.TimePickerScreen
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
        MainScreen.tapDateTimePickersButton()
        DateTimePickerScreen.tapDatePickerButton()

        // Select Year, Month, and Day
        DatePickerScreen.selectYearMonthDay(year, month, day)
        DatePickerScreen.tapOkButton()

        //Verify that the date is shown
        DateTimePickerScreen.verifyDate(year, month, day)
    }

    @Test
    fun testSetTime() {
        val hour = 10
        val minutes = 59

        // From Main navigate to date time pickers
        MainScreen.tapDateTimePickersButton()
        DateTimePickerScreen.tapTimePickerButton()

        // Select Hour and Minute
        TimePickerScreen.selectHourandMinute(hour,minutes)
        TimePickerScreen.tapOkButton()

        // Verify that the time is shown
        DateTimePickerScreen.verifyTime(hour, minutes)
    }
}
