package com.ui.espresso

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.ui.espresso.bases.TestBase
import com.ui.espresso.matchers.CustomMatchers
import com.ui.espresso.screens.MainScreen
import com.ui.espresso.screens.SpinnerScreen
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
        MainScreen.tapSpinnerButton()
    }

    @Test
    fun testCountryNotInList() {
        SpinnerScreen.verifyCountyNotInList
    }

    @Test
    fun testLabelDoesNotChangeIfFirstItemSelected() {
        // Click on the Spinner
        SpinnerScreen.tapSpinner()

        // Click on the first item from the list, which is a marker string: "Select your country"
        SpinnerScreen.tapFirstItem()

        // Check that the country label is not updated.
        SpinnerScreen.verifySpinnerDefaultText
    }

    @Test
    fun testLabelUpdatesIfValidCountrySelected() {
        // Click on the Spinner
        SpinnerScreen.tapSpinner()

        // Select a country from the list
        SpinnerScreen.tapCountry()

        // Check that the country label is updated with selected country
        SpinnerScreen.verifyCountrySelected
    }

}
