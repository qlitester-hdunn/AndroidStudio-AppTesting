package com.ui.espresso.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.ui.espresso.constants.Strings

object LandingPage {

    // region | Action Methods --------------------------------------------------------------------------
    fun getActionBarScreen() {
        onView(withText(Strings.ACTION_BAR)).perform(click())
    }

    fun getTypeTextScreen() {
        onView(withText(Strings.TYPE_TEXT)).perform(click())
    }

    fun getSpinnerSelectionScreen() {
        onView(withText(Strings.SPINNER_SELECTION)).perform(click())
    }

    fun getCustomListAdapterScreen() {
        onView(withText(Strings.CUSTOM_LIST_ADAPTER)).perform(click())
    }

    fun getSearchViewScreen() {
        onView(withText(Strings.SEARCH_VIEW)).perform(click())
    }

    fun getViewPagerScreen() {
        onView(withText(Strings.VIEW_PAGER)).perform(click())
    }

    fun getDialogsScreen() {
        onView(withText(Strings.DIALOGS)).perform(click())
    }

    fun getRecyclerViewScreen() {
        onView(withText(Strings.RECYCLER_VIEW)).perform(click())
    }

    fun getDateTimePickersScreen() {
        onView(withText(Strings.DATE_TIME_PICKERS)).perform(click())
    }
    // endregion
}