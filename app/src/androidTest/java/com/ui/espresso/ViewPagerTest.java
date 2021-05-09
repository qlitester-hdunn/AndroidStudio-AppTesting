package com.ui.espresso;


import android.widget.AdapterView;

import androidx.test.espresso.matcher.ViewMatchers;

import com.ui.espresso.R;
import com.ui.espresso.bases.TestBase;

import org.junit.Before;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.ui.espresso.matchers.CustomMatchers.withBookAuthor;
import static com.ui.espresso.matchers.CustomMatchers.withBookTitle;
import static org.hamcrest.CoreMatchers.allOf;


/**
 * @author  HDunn, Modified on 4/30/21.
 */
public class ViewPagerTest extends TestBase {

    private static final String BOOK_TITLE = "Clean Code";
    private static final String BOOK_AUTHOR = "Robert C. Martin";

    @Before
    public void navigateToViewpager(){
        // From Main navigate to viewpager
        onView(ViewMatchers.withId(R.id.viewpager_button)).perform(click());
    }

    @Test
    public void testAllTabDisplayedOnSwipe() {
        // Locate the ViewPager and perform a swipe left action
        onView(withId(R.id.pager)).perform(swipeLeft());

        // Check the "ALL BOOKS" text is displayed
        onView(allOf(withId(R.id.header_text), isDisplayed())).check(matches(withText("ALL BOOKS")));
    }

    @Test
    public void testClickOnBookFromNewTab() {
        // Fails with AmbiguousViewMatcherException as same ListView is used in both pages of ViewPager.
        // onData(allOf(withBookTitle(BOOK_TITLE), withBookAuthor(BOOK_AUTHOR))).perform(click());

        // Forcing a fail if no click - now at ALL BOOKS
        onView(withId(R.id.pager)).perform(swipeLeft());

        // Click on "New" now ListView is displayed
        onView(withText("New")).perform(click());

        // Refine query specifying an AdapterView that is currently visible (isDisplayed).
        onData(allOf(withBookTitle(BOOK_TITLE), withBookAuthor(BOOK_AUTHOR)))
                .inAdapterView(allOf(isAssignableFrom(AdapterView.class), isDisplayed()))
                .perform(click());

        // Check the correct book title is displayed
        onView(withId(R.id.book_title)).check(matches(withText(BOOK_TITLE)));

        // Check the correct author is displayed
        onView(withId(R.id.book_author)).check(matches(withText(BOOK_AUTHOR)));
    }
}
