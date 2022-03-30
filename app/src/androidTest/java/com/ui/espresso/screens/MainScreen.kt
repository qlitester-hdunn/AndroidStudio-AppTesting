package com.ui.espresso.screens

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.ui.espresso.R

object MainScreen {

    //Constants-------------------------------------------------------------------------------------
    private const val ACTION_BAR_BUTTON = R.id.action_bar_button
    private const val DIALOGS_BUTTON = R.id.dialogs_button
    private const val PERSON_LIST_ADAPTER_BUTTON = R.id.person_list_adapter_button
    private const val PICKERS_BUTTON = R.id.pickers_button
    private const val RECYCLER_VIEW_BUTTON = R.id.recycler_view_button
    private const val SEARCH_VIEW_BUTTON = R.id.search_view_button
    private const val TYPE_TEXT_BUTTON = R.id.type_text_button
    private const val SPINNER_SELECTION_BUTTON = R.id.spinner_selection_button
    private const val VIEWPAGER_BUTTON = R.id.viewpager_button

    //Action methods--------------------------------------------------------------------------------
    fun tapActionBarButton(){
        onView(withId(ACTION_BAR_BUTTON)).perform(click())
    }

    fun tapDateTimePickersButton(){
        onView(withId(PICKERS_BUTTON)).perform(click())
    }

    fun tapDialogButton(){
        onView(withId(DIALOGS_BUTTON)).perform(click())
    }

    fun tapPersonListButton(){
        onView(withId(PERSON_LIST_ADAPTER_BUTTON)).perform(click())
    }

    fun tapRecyclerViewButton(){
        onView(withId(RECYCLER_VIEW_BUTTON)).perform(click())
    }

    fun tapSearchViewButton(){
        onView(withId(SEARCH_VIEW_BUTTON)).perform(click())
    }

    fun tapTypeTextButton(){
        onView(withId(TYPE_TEXT_BUTTON)).perform(click())
    }

    fun tapSpinnerButton(){
        onView(withId(SPINNER_SELECTION_BUTTON)).perform(click())
    }

    fun tapViewPagerButton(){
        onView(withId(VIEWPAGER_BUTTON)).perform(click())
    }

}