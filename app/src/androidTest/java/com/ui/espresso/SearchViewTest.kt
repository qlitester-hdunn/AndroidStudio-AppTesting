package com.ui.espresso

import android.widget.EditText
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.RootMatchers
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
class SearchViewTest : TestBase() {

    companion object {
        const val HELSINKI = "Helsinki"
    }

    @Before
    fun navigateToSearchView() {
        // From Main navigate to search view
        Espresso.onView(ViewMatchers.withId(R.id.search_view_button)).perform(ViewActions.click())
    }

    @Test
    fun testItemNotFound() {
        // Click on the search icon
        Espresso.onView(ViewMatchers.withId(R.id.action_search)).perform(ViewActions.click())

        // Type the text in the search field and submit the query
        Espresso.onView(ViewMatchers.isAssignableFrom(EditText::class.java))
                .perform(ViewActions.typeText(
                        "No such item"),
                        ViewActions.pressImeActionButton())

        // Check the empty view is displayed
        Espresso.onView(ViewMatchers.withId(R.id.empty_view))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testItemFound() {
        Espresso.onView(ViewMatchers.withId(R.id.action_search)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.isAssignableFrom(EditText::class.java))
                .perform(ViewActions.typeText(HELSINKI), ViewActions.pressImeActionButton())

        // Check empty view is not displayed
        Espresso.onView(ViewMatchers.withId(R.id.empty_view))
                .check(ViewAssertions.matches(Matchers.not(ViewMatchers.isDisplayed())))

        // Check the item we are looking for is in the search result list.
        Espresso.onData(Matchers.allOf(CoreMatchers.`is`(Matchers.instanceOf(
                String::class.java)),
                CustomMatchers.withItemContent(HELSINKI)))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testSearchSuggestionDisplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.action_search)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.isAssignableFrom(EditText::class.java))
                .perform(ViewActions.typeText(HELSINKI), ViewActions.pressImeActionButton())

        // Go back to previous screen
        Espresso.pressBack()

        // Clear the text in search field
        Espresso.onView(ViewMatchers.isAssignableFrom(EditText::class.java))
                .perform(ViewActions.clearText())

        // Enter the first letter of the previously searched word
        Espresso.onView(ViewMatchers.isAssignableFrom(EditText::class.java))
                .perform(ViewActions.typeText("He"))

        // Check the search suggestions appear
        Espresso.onView(ViewMatchers.withText(HELSINKI))
                .inRoot(RootMatchers.withDecorView(Matchers.not(Matchers.`is`(activity!!.window.decorView))))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testClickOnSearchSuggestion() {

        Espresso.onView(ViewMatchers.withId(R.id.action_search)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.isAssignableFrom(EditText::class.java))
                .perform(ViewActions.typeText(HELSINKI), ViewActions.pressImeActionButton())

        // Go back to previous screen
        Espresso.pressBack()

        // Clear the text in search field
        Espresso.onView(ViewMatchers.isAssignableFrom(EditText::class.java))
                .perform(ViewActions.clearText())

        // Enter the first letter of the previously searched word
        Espresso.onView(ViewMatchers.isAssignableFrom(EditText::class.java))
                .perform(ViewActions.typeText("He"))


        // Click on the "Java" item from the suggestions list
        Espresso.onView(ViewMatchers.withText(HELSINKI))
                .inRoot(RootMatchers.withDecorView(Matchers.not(Matchers.`is`(activity!!.window.decorView))))
                .perform(ViewActions.click())

        // Check the item appears in search results list.
        Espresso.onData(Matchers.allOf(CoreMatchers.`is`(Matchers.instanceOf(
                String::class.java)),
                CustomMatchers.withItemContent(HELSINKI)))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
