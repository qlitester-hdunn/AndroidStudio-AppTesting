package com.ui.espresso

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.ui.espresso.bases.CustomListActivityBase
import com.ui.espresso.matchers.CustomMatchers
import org.hamcrest.CoreMatchers
import org.junit.Test

/**
 * @author  HDunn, Modified on 4/30/21.
 */
class CustomListTest : CustomListActivityBase() {
    @Test
    fun testOpenBookById() {

        // Click on the Book with ID 5
        Espresso.onData(CustomMatchers.withBookId(5)).perform(ViewActions.click())

        // Check the correct book title is displayed
        Espresso.onView(ViewMatchers.withId(R.id.book_title)).check(ViewAssertions.matches(ViewMatchers.withText(BOOK_TITLE)))

        // Check the correct author is displayed
        Espresso.onView(ViewMatchers.withId(R.id.book_author)).check(ViewAssertions.matches(ViewMatchers.withText(BOOK_AUTHOR)))
    }

    @Test
    fun testOpenBookByTitleAndAuthor() {
        // Match a book with a specific title and author name
        Espresso.onData(CoreMatchers.allOf(CustomMatchers.withBookTitle(BOOK_TITLE), CustomMatchers.withBookAuthor(BOOK_AUTHOR))).perform(ViewActions.click())

        // Check the correct book title is displayed
        Espresso.onView(ViewMatchers.withId(R.id.book_title)).check(ViewAssertions.matches(ViewMatchers.withText(BOOK_TITLE)))

        // Check the correct author is displayed
        Espresso.onView(ViewMatchers.withId(R.id.book_author)).check(ViewAssertions.matches(ViewMatchers.withText(BOOK_AUTHOR)))
    }

    @Test
    fun testClickOnBookByPosition() {
        Espresso.onData(CoreMatchers.anything()).atPosition(5).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.book_title)).check(ViewAssertions.matches(ViewMatchers.withText(BOOK_TITLE)))
        Espresso.onView(ViewMatchers.withId(R.id.book_author)).check(ViewAssertions.matches(ViewMatchers.withText(BOOK_AUTHOR)))
    }

    companion object {
        private const val BOOK_TITLE = "Java Concurrency in Practice"
        private const val BOOK_AUTHOR = "Brian Goetz"
    }
}
