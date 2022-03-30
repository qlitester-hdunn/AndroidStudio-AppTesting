package com.ui.espresso

import android.widget.EditText
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import com.ui.espresso.bases.TestBase
import com.ui.espresso.matchers.CustomMatchers
import com.ui.espresso.screens.MainScreen
import com.ui.espresso.screens.SearchViewScreen
import org.hamcrest.CoreMatchers
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Test

/**
 * @author  HDunn, Modified on 4/30/21.
 */
class SearchViewTest : TestBase() {

    @Before
    fun navigateToSearchView() {
        // From Main navigate to search view
        MainScreen.tapSearchViewButton()
    }

    @Test
    fun testItemNotFound() {
        // Click on the search icon
        SearchViewScreen.tapSearchButton()

        // Type the text in the search field and submit the query
        SearchViewScreen.searchInvalidSearch()

        // Check the empty view is displayed
        SearchViewScreen.verifyEmptyViewDisplayed
    }

    @Test
    fun testItemFound() {

        SearchViewScreen.tapSearchButton()

        SearchViewScreen.searchValidSearch()

        // Check empty view is not displayed
        SearchViewScreen.verifyEmptyViewNotDisplayed

        // Check the item we are looking for is in the search result list.
        SearchViewScreen.verifySearchItemDisplayed
    }

    @Test
    fun testSearchSuggestionDisplayed() {
        SearchViewScreen.tapSearchButton()

        SearchViewScreen.searchValidSearch()

        // Go back to previous screen
        Espresso.pressBack()

        // Clear the text in search field
        SearchViewScreen.clearSearchBar()

        // Enter the first letter of the previously searched word
        SearchViewScreen.enterPartialSearch()

        // Check the search suggestions appear
        SearchViewScreen.activity = activity
        SearchViewScreen.verifySearchSuggestionDisplayed
    }

    @Test
    fun testClickOnSearchSuggestion() {

        SearchViewScreen.tapSearchButton()
        SearchViewScreen.searchValidSearch()

        // Go back to previous screen
        Espresso.pressBack()

        // Clear the text in search field
        SearchViewScreen.clearSearchBar()

        // Enter the first letter of the previously searched word
        SearchViewScreen.enterPartialSearch()


        // Click on the "Java" item from the suggestions list
        SearchViewScreen.activity = activity
        SearchViewScreen.tapSearchSuggestion()

        // Check the item appears in search results list.
        SearchViewScreen.verifySearchItemDisplayed
    }
}
