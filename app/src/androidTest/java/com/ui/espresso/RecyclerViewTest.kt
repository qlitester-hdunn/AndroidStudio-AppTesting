package com.ui.espresso

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import com.ui.espresso.bases.TestBase
import org.junit.Before
import org.junit.Test

/**
 * @author  HDunn, Modified on 4/30/21.
 */
class RecyclerViewTest : TestBase() {
    @Before
    fun navigateToRecyclerView() {
        // From Main navigate to recycler view
        Espresso.onView(ViewMatchers.withId(R.id.recycler_view_button)).perform(ViewActions.click())
    }

    @Test
    fun testClickAtPosition() {
        // Perform a click on first element in the RecyclerView
        Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        Espresso.onView(ViewMatchers.withId(R.id.book_title)).check(ViewAssertions.matches(ViewMatchers.withText(BOOK_TITLE)))
        Espresso.onView(ViewMatchers.withId(R.id.book_author)).check(ViewAssertions.matches(ViewMatchers.withText(BOOK_AUTHOR)))
    }

    @Test
    fun testClickOnViewInRow() {
        // Perform click on an element with a specific text
        Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(
                ViewMatchers.hasDescendant(ViewMatchers.withText(BOOK_TITLE)), ViewActions.click()))
        Espresso.onView(ViewMatchers.withId(R.id.book_title)).check(ViewAssertions.matches(ViewMatchers.withText(BOOK_TITLE)))
    }

    companion object {
        private const val BOOK_TITLE = "Clean Code"
        private const val BOOK_AUTHOR = "Robert C. Martin"
    }
}
