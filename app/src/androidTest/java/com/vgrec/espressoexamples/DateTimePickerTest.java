package com.vgrec.espressoexamples;

import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.test.espresso.contrib.PickerActions;

import com.vgrec.espressoexamples.bases.TestBase;

import org.hamcrest.Matchers;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * @author  HDunn, Modifed on 4/30/21.
 */

public class DateTimePickerTest extends TestBase {

    @Test
    public void testSetDate() {
        int year = 2020;
        int month = 11;
        int day = 15;

        // From Main navigate to date time pickers
        onView(withId(R.id.pickers_button)).perform(click());

        onView(withId(R.id.date_picker_button)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(year, month + 1, day));
        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.status)).check(matches(withText(year + "/" + month + "/" + day)));
    }

    @Test
    public void testSetTime() {
        int hour = 10;
        int minutes = 59;

        // From Main navigate to date time pickers
        onView(withId(R.id.pickers_button)).perform(click());

        onView(withId(R.id.time_picker_button)).perform(click());
        onView(withClassName(Matchers.equalTo(TimePicker.class.getName()))).perform(PickerActions.setTime(hour, minutes));
        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.status)).check(matches(withText(hour + ":" + minutes)));
    }
}
