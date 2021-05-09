package com.vgrec.espressoexamples;

import com.vgrec.espressoexamples.bases.TestBase;

import org.junit.Before;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


/**
 * @author  HDunn, Modifed on 4/30/21.
 */

public class DialogTests extends TestBase {

    @Before
    public void navigateToDialogs(){
        // From Main navigate to date time pickers
        onView(withId(R.id.dialogs_button)).perform(click());
    }

    @Test
    public void testCheckDialogDisplayed() {
        // Click on the button that shows the dialog
        onView(withId(R.id.confirm_dialog_button)).perform(click());

        // Check the dialog title text is displayed
        onView(withText(R.string.dialog_title)).check(matches(isDisplayed()));
    }
    @Test
    public void testClickOkButton() {
        onView(withId(R.id.confirm_dialog_button)).perform(click());

        // android.R.id.button1 = positive button
        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.status_text)).check(matches(withText(R.string.ok)));
    }

    public void testClickCancelButton() {
        onView(withId(R.id.confirm_dialog_button)).perform(click());

        // android.R.id.button2 = negative button
        onView(withId(android.R.id.button2)).perform(click());

        onView(withId(R.id.status_text)).check(matches(withText(R.string.cancel)));
    }
}
