package com.ui.espresso.screens

import android.widget.AdapterView
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.ui.espresso.R
import com.ui.espresso.constants.Strings
import com.ui.espresso.datamodels.Book
import com.ui.espresso.matchers.CustomMatchers.withBookTitle
import com.ui.espresso.matchers.CustomMatchers.withBookAuthor
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.allOf

object ViewPagerScreen {
    var book = Book()

    //Constants-------------------------------------------------------------------------------------
    private const val PAGER = R.id.pager
    private const val HEADER_TEXT = R.id.header_text

    //Matchers--------------------------------------------------------------------------------------
    private val bookMatcher
        get() = allOf(withBookTitle(book.title), withBookAuthor(book.author))

    //Action methods--------------------------------------------------------------------------------
    fun swipePagerLeft(){
        onView(withId(PAGER)).perform(swipeLeft())
    }

    fun tapNewButton(){
        onView(withText(Strings.NEW)).perform(click())
    }

    fun tapBook(){
        onData(bookMatcher).inAdapterView(allOf(isAssignableFrom(AdapterView::class.java),
                isDisplayed())).perform(click())
    }

    //Assertion properties--------------------------------------------------------------------------
    val verifyAllBooksText
        get() = onView(allOf(withId(HEADER_TEXT), isDisplayed())).check(matches(withText(
                Strings.ALL_BOOKS)))

}