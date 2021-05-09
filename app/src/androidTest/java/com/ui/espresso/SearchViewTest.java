package com.ui.espresso;


import android.widget.EditText;

import androidx.test.espresso.matcher.ViewMatchers;

import com.ui.espresso.R;
import com.ui.espresso.bases.TestBase;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.ui.espresso.matchers.CustomMatchers.withItemContent;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.not;

/**
 * @author  HDunn, Modifed on 4/30/21.
 */

public class SearchViewTest extends TestBase {

    public static final String HELSINKI = "Helsinki";

    @Before
    public void navigateToSearchView(){
        // From Main navigate to search view
        onView(ViewMatchers.withId(R.id.search_view_button)).perform(click());
    }

    @Test
    public void testItemNotFound() {
        // Click on the search icon
        onView(withId(R.id.action_search)).perform(click());

        // Type the text in the search field and submit the query
        onView(isAssignableFrom(EditText.class)).perform(typeText("No such item"), pressImeActionButton());

        // Check the empty view is displayed
        onView(withId(R.id.empty_view)).check(matches(isDisplayed()));
    }

    @Test
    public void testItemFound() {
        onView(withId(R.id.action_search)).perform(click());
        onView(isAssignableFrom(EditText.class)).perform(typeText(HELSINKI), pressImeActionButton());

        // Check empty view is not displayed
        onView(withId(R.id.empty_view)).check(matches(not(isDisplayed())));

        // Check the item we are looking for is in the search result list.
        onData(allOf(is(instanceOf(String.class)), withItemContent(HELSINKI))).check(matches(isDisplayed()));
    }

    @Test
    public void testSearchSuggestionDisplayed() {
        onView(withId(R.id.action_search)).perform(click());
        onView(isAssignableFrom(EditText.class)).perform(typeText(HELSINKI), pressImeActionButton());

        // Go back to previous screen
        pressBack();

        // Clear the text in search field
        onView(isAssignableFrom(EditText.class)).perform(clearText());

        // Enter the first letter of the previously searched word
        onView(isAssignableFrom(EditText.class)).perform(typeText("He"));

        // Check the search suggestions appear
        onView(withText(HELSINKI))
                .inRoot(withDecorView(not(Matchers.is(this.activity.getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testClickOnSearchSuggestion() {
        onView(withId(R.id.action_search)).perform(click());
        onView(isAssignableFrom(EditText.class)).perform(typeText(HELSINKI), pressImeActionButton());

        // Go back to previous screen
        pressBack();

        // Clear the text in search field
        onView(isAssignableFrom(EditText.class)).perform(clearText());

        // Enter the first letter of the previously searched word
        onView(isAssignableFrom(EditText.class)).perform(typeText("He"));


        // Click on the "Java" item from the suggestions list
        onView(withText(HELSINKI))
                .inRoot(withDecorView(not(Matchers.is(this.activity.getWindow().getDecorView()))))
                .perform(click());

        // Check the item appears in search results list.
        onData(allOf(is(instanceOf(String.class)), withItemContent(HELSINKI))).check(matches(isDisplayed()));
    }

}
