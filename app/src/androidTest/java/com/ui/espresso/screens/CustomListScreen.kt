package com.ui.espresso.screens

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.ui.espresso.CustomListTest
import com.ui.espresso.R
import com.ui.espresso.constants.Strings
import com.ui.espresso.datamodels.Book
import com.ui.espresso.matchers.CustomMatchers
import com.ui.espresso.matchers.CustomMatchers.withBookId
import org.hamcrest.CoreMatchers


object CustomListScreen {

    var book = Book()

    //Constants-------------------------------------------------------------------------------------
    private const val BOOK_TITLE = R.id.book_title
    private const val BOOK_AUTHOR = R.id.book_author

    //Action methods--------------------------------------------------------------------------------
    fun tapBook(bookId:Int){
        onData(withBookId(bookId)).perform(click())
    }

    fun tapBookPosition(position: Int){
        onData(CoreMatchers.anything()).atPosition(position).perform(click())
    }

    fun tapBookWithTitleAndAuthor(){
        onData(CoreMatchers.allOf(CustomMatchers.withBookTitle(book.title), CustomMatchers.withBookAuthor(book.author))).perform(click())
    }

    //Assertion function--------------------------------------------------------------------------
    val verifyBookTitle
        get() = onView(withId(BOOK_TITLE)).check(matches(withText(book.title)))

    val verifyBookAuthor
        get() = onView(withId(BOOK_AUTHOR)).check(matches(withText(book.author)))
}