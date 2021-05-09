package com.vgrec.espressoexamples

import android.widget.AdapterView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.vgrec.espressoexamples.bases.TestBase
import com.vgrec.espressoexamples.matchers.CustomMatchers
import org.hamcrest.CoreMatchers
import org.junit.Before
import org.junit.Test

/**
 * @author  HDunn, Modified on 4/30/21.
 */
class ViewPagerTest : TestBase() {
    @Before
    fun navigateToViewpager() {
        // From Main navigate to viewpager
        Espresso.onView(ViewMatchers.withId(R.id.viewpager_button)).perform(ViewActions.click())
    }

    @Test
    fun testAllTabDisplayedOnSwipe() {
        // Locate the ViewPager and perform a swipe left action
        Espresso.onView(ViewMatchers.withId(R.id.pager)).perform(ViewActions.swipeLeft())

        // Check the "ALL BOOKS" text is displayed
        Espresso.onView(CoreMatchers.allOf(ViewMatchers.withId(R.id.header_text), ViewMatchers.isDisplayed())).check(ViewAssertions.matches(ViewMatchers.withText("ALL BOOKS")))
    }

    @Test
    fun testClickOnBookFromNewTab() {
        // Fails with AmbiguousViewMatcherException as same ListView is used in both pages of ViewPager.
        // onData(allOf(withBookTitle(BOOK_TITLE), withBookAuthor(BOOK_AUTHOR))).perform(click());

        // Forcing a fail if no click - now at ALL BOOKS
        Espresso.onView(ViewMatchers.withId(R.id.pager)).perform(ViewActions.swipeLeft())

        // Click on "New" now ListView is displayed
        Espresso.onView(ViewMatchers.withText("New")).perform(ViewActions.click())

        // Refine query specifying an AdapterView that is currently visible (isDisplayed).
        Espresso.onData(CoreMatchers.allOf(CustomMatchers.withBookTitle(BOOK_TITLE), CustomMatchers.withBookAuthor(BOOK_AUTHOR)))
                .inAdapterView(CoreMatchers.allOf(ViewMatchers.isAssignableFrom(AdapterView::class.java), ViewMatchers.isDisplayed()))
                .perform(ViewActions.click())

        // Check the correct book title is displayed
        Espresso.onView(ViewMatchers.withId(R.id.book_title)).check(ViewAssertions.matches(ViewMatchers.withText(BOOK_TITLE)))

        // Check the correct author is displayed
        Espresso.onView(ViewMatchers.withId(R.id.book_author)).check(ViewAssertions.matches(ViewMatchers.withText(BOOK_AUTHOR)))
    }

    companion object {
        private const val BOOK_TITLE = "Clean Code"
        private const val BOOK_AUTHOR = "Robert C. Martin"
    }
}
