package com.ui.espresso.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.ui.espresso.R
import com.ui.espresso.RecyclerViewTest
import com.ui.espresso.datamodels.Book

object BookDetailScreen {
    var book = Book()

    //Constants-------------------------------------------------------------------------------------
    private const val BOOK_TITLE = R.id.book_title
    private const val BOOK_AUTHOR = R.id.book_author

    //Action methods--------------------------------------------------------------------------------

    //Assertion properties--------------------------------------------------------------------------
    val verifyBookTitle
        get() = onView(withId(BOOK_TITLE)).check(matches(withText(book.title)))

    val verifyBookAuthor
        get() = onView(withId(BOOK_AUTHOR)).check(matches(withText(book.author)))
}