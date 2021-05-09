package com.ui.espresso

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.ui.espresso.bases.TestBase
import com.ui.espresso.matchers.CustomMatchers
import org.hamcrest.CoreMatchers
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Test

/**
 * @author  HDunn, Modified on 4/30/21.
 */
class SpinnerSelectionTest : TestBase() {
    @Before
    fun navigateToSpinnerSelection() {
        // From Main navigate to spinner selection
        Espresso.onView(ViewMatchers.withId(R.id.spinner_selection_button))
                .perform(ViewActions.click())
    }

    @Test
    fun testCountryNotInList() {
        Espresso.onView(ViewMatchers.withId(R.id.countries_spinner))
                .check(ViewAssertions.matches(
                        Matchers.not(
                                CustomMatchers.withAdaptedData(
                                CustomMatchers.withItemContent(INVALID_COUNTRY_NAME)))
                ))
    }

    @Test
    fun testLabelDoesNotChangeIfFirstItemSelected() {
        // Click on the Spinner
        Espresso.onView(ViewMatchers.withId(R.id.countries_spinner)).perform(ViewActions.click())

        // Click on the first item from the list, which is a marker string: "Select your country"
        Espresso.onData(Matchers.allOf(CoreMatchers.`is`(Matchers.instanceOf(String::class.java))))
                .atPosition(0).perform(ViewActions.click())

        // Check that the country label is not updated.
        Espresso.onView(ViewMatchers.withId(R.id.country_label))
                .check(ViewAssertions.matches(
                        Matchers.not(ViewMatchers.withText(FIRST_ITEM_TEXT))))
    }

    @Test
    fun testLabelUpdatesIfValidCountrySelected() {
        // Click on the Spinner
        Espresso.onView(ViewMatchers.withId(R.id.countries_spinner)).perform(ViewActions.click())

        // Select a country from the list
        Espresso.onData(Matchers.allOf(
                CoreMatchers.`is`(Matchers.instanceOf<Any>(String::class.java)),
                CoreMatchers.`is`<String>(VALID_COUNTRY_NAME))).perform(ViewActions.click())

        // Check that the country label is updated with selected country
        Espresso.onView(ViewMatchers.withId(R.id.country_label))
                .check(ViewAssertions.matches(ViewMatchers.withText(VALID_COUNTRY_NAME)))
    }

    companion object {
        const val INVALID_COUNTRY_NAME = "NoSuchCountry"
        const val VALID_COUNTRY_NAME = "Moldova"
        const val FIRST_ITEM_TEXT = "Select your country"
    }
}
