package com.ui.espresso;

import androidx.test.espresso.matcher.ViewMatchers;

import com.ui.espresso.R;
import com.ui.espresso.bases.TestBase;

import org.junit.Before;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;

/**
 * @author  HDunn, Modifed on 4/30/21.
 */

public class EnterNameTest extends TestBase {

    public static final String USER_NAME = "John";
    public static final String GREETING_MESSAGE = "Hello " + USER_NAME + "!";

    @Before
    public void navigateToTypeText(){
        // From Main navigate to type text
        onView(ViewMatchers.withId(R.id.type_text_button)).perform(click());
    }

    @Test
    public void testHintDisplayed() {
        onView(withId(R.id.name_edittext)).check(matches(withHint(R.string.enter_name)));
    }

    @Test
    public void testErrorMessageDisplayed() {
        // Making sure the error message is not displayed by default
        onView(withId(R.id.error_text)).check(matches(not(isDisplayed())));

        // Click on "Next" button
        onView(withId(R.id.next_button)).perform(click());

        // Now check the error message is displayed
        onView(withId(R.id.error_text)).check(matches(isDisplayed()));
    }

    @Test
    public void testGreetingMessageWithNameDisplayed() {
        onView(withId(R.id.name_edittext)).perform(typeText(USER_NAME));
        onView(withId(R.id.next_button)).perform(click());
        onView(withId(R.id.greeting_message)).check(matches(withText(GREETING_MESSAGE)));
    }
}
