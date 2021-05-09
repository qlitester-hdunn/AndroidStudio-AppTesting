package com.ui.espresso;

import androidx.test.espresso.matcher.ViewMatchers;

import com.ui.espresso.R;
import com.ui.espresso.bases.CustomListActivityBase;
import com.ui.espresso.matchers.CustomMatchers;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anything;


/**
 * @author  HDunn, Modifed on 4/30/21.
 */
public class CustomListTest extends CustomListActivityBase {

    private static final String BOOK_TITLE = "Java Concurrency in Practice";
    private static final String BOOK_AUTHOR = "Brian Goetz";


    @Test
    public void testOpenBookById() {

        // Click on the Book with ID 5
        onData(CustomMatchers.withBookId(5)).perform(click());

        // Check the correct book title is displayed
        onView(ViewMatchers.withId(R.id.book_title)).check(matches(withText(BOOK_TITLE)));

        // Check the correct author is displayed
        onView(withId(R.id.book_author)).check(matches(withText(BOOK_AUTHOR)));
    }

    @Test
    public void testOpenBookByTitleAndAuthor() {
        // Match a book with a specific title and author name
        onData(CoreMatchers.allOf(CustomMatchers.withBookTitle(BOOK_TITLE), CustomMatchers.withBookAuthor(BOOK_AUTHOR))).perform(click());

        // Check the correct book title is displayed
        onView(withId(R.id.book_title)).check(matches(withText(BOOK_TITLE)));

        // Check the correct author is displayed
        onView(withId(R.id.book_author)).check(matches(withText(BOOK_AUTHOR)));
    }

    @Test
    public void testClickOnBookByPosition(){
        onData(anything()).atPosition(5).perform(click());
        onView(withId(R.id.book_title)).check(matches(withText(BOOK_TITLE)));
        onView(withId(R.id.book_author)).check(matches(withText(BOOK_AUTHOR)));
    }
}
