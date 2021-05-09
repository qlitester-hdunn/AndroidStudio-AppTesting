package com.ui.espresso;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;

import com.ui.espresso.R;
import com.ui.espresso.bases.TestBase;

import org.junit.Before;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * @author  HDunn, Modified on 4/30/21.
 */
public class RecyclerViewTest extends TestBase {

    private static final String BOOK_TITLE = "Clean Code";
    private static final String BOOK_AUTHOR = "Robert C. Martin";


    @Before
    public void navigateToRecyclerView(){
        // From Main navigate to recycler view
        onView(ViewMatchers.withId(R.id.recycler_view_button)).perform(click());
    }

    @Test
    public void testClickAtPosition() {
        // Perform a click on first element in the RecyclerView
        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.book_title)).check(matches(withText(BOOK_TITLE)));
        onView(withId(R.id.book_author)).check(matches(withText(BOOK_AUTHOR)));
    }

    @Test
    public void testClickOnViewInRow() {
        // Perform click on an element with a specific text
        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItem(
                hasDescendant(withText(BOOK_TITLE)), click()));

        onView(withId(R.id.book_title)).check(matches(withText(BOOK_TITLE)));
    }
}
