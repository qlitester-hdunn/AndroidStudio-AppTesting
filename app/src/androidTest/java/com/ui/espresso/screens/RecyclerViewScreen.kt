package com.ui.espresso.screens

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.ui.espresso.R
import com.ui.espresso.datamodels.Book

object RecyclerViewScreen {

    var book = Book()

    //Constants-------------------------------------------------------------------------------------
    private const val RECYCLERVIEW = R.id.recyclerView

    //Action methods--------------------------------------------------------------------------------
    fun tapBookAtPosition(){
        onView(withId(RECYCLERVIEW)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

    }

    fun tapBookWithTitle(){
        onView(withId(R.id.recyclerView)).perform(actionOnItem<RecyclerView.ViewHolder>(
                hasDescendant(withText(book.title)), click()))
    }
    //Assertion properties--------------------------------------------------------------------------

}