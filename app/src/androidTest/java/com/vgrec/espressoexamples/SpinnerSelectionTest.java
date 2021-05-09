package com.vgrec.espressoexamples;

import com.vgrec.espressoexamples.bases.TestBase;

import org.junit.Before;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.vgrec.espressoexamples.matchers.CustomMatchers.withAdaptedData;
import static com.vgrec.espressoexamples.matchers.CustomMatchers.withItemContent;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.not;


/**
 * @author  HDunn, Modifed on 4/30/21.
 */

public class SpinnerSelectionTest extends TestBase {

    public static final String INVALID_COUNTRY_NAME = "NoSuchCountry";
    public static final String VALID_COUNTRY_NAME = "Moldova";
    public static final String FIRST_ITEM_TEXT = "Select your country";

    @Before
    public void navigateToSpinnerSelection(){
        // From Main navigate to spinner selection
        onView(withId(R.id.spinner_selection_button)).perform(click());
    }

    @Test
    public void testCountryNotInList() {
        onView(withId(R.id.countries_spinner)).check(matches(not(withAdaptedData(withItemContent(INVALID_COUNTRY_NAME)))));
    }

    @Test
    public void testLabelDoesNotChangeIfFirstItemSelected() {
        // Click on the Spinner
        onView(withId(R.id.countries_spinner)).perform(click());

        // Click on the first item from the list, which is a marker string: "Select your country"
        onData(allOf(is(instanceOf(String.class)))).atPosition(0).perform(click());

        // Check that the country label is not updated.
        onView(withId(R.id.country_label)).check(matches(not(withText(FIRST_ITEM_TEXT))));
    }

    @Test
    public void testLabelUpdatesIfValidCountrySelected() {
        // Click on the Spinner
        onView(withId(R.id.countries_spinner)).perform(click());

        // Select a country from the list
        onData(allOf(is(instanceOf(String.class)), is(VALID_COUNTRY_NAME))).perform(click());

        // Check that the country label is updated with selected country
        onView(withId(R.id.country_label)).check(matches(withText(VALID_COUNTRY_NAME)));
    }
}
