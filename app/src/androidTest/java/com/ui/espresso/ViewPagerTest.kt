package com.ui.espresso

import android.widget.AdapterView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.ui.espresso.bases.TestBase
import com.ui.espresso.constants.Books
import com.ui.espresso.matchers.CustomMatchers
import com.ui.espresso.screens.BookDetailScreen
import com.ui.espresso.screens.MainScreen
import com.ui.espresso.screens.ViewPagerScreen
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
        MainScreen.tapViewPagerButton()
    }

    @Test
    fun testAllTabDisplayedOnSwipe() {
        // Locate the ViewPager and perform a swipe left action
        ViewPagerScreen.swipePagerLeft()

        // Check the "ALL BOOKS" text is displayed
        ViewPagerScreen.verifyAllBooksText
    }

    @Test
    fun testClickOnBookFromNewTab() {
        // Fails with AmbiguousViewMatcherException as same ListView is used in both pages of ViewPager.
        // onData(allOf(withBookTitle(BOOK_TITLE), withBookAuthor(BOOK_AUTHOR))).perform(click());

        ViewPagerScreen.book = Books.CLEANCODE
        // Forcing a fail if no click - now at ALL BOOKS
        ViewPagerScreen.swipePagerLeft()

        // Click on "New" now ListView is displayed
        ViewPagerScreen.tapNewButton()

        // Refine query specifying an AdapterView that is currently visible (isDisplayed).
        ViewPagerScreen.tapBook()

        // Check the correct book title is displayed
        BookDetailScreen.book = Books.CLEANCODE
        BookDetailScreen.verifyBookTitle

        // Check the correct author is displayed
        BookDetailScreen.verifyBookAuthor
    }
}
