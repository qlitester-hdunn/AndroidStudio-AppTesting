package com.ui.espresso

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import com.ui.espresso.bases.TestBase
import com.ui.espresso.constants.Books
import com.ui.espresso.screens.BookDetailScreen
import com.ui.espresso.screens.MainScreen
import com.ui.espresso.screens.RecyclerViewScreen
import org.junit.Before
import org.junit.Test

/**
 * @author  HDunn, Modified on 4/30/21.
 */
class RecyclerViewTest : TestBase() {
    @Before
    fun navigateToRecyclerView() {
        // From Main navigate to recycler view
        MainScreen.tapRecyclerViewButton()
    }

    @Test
    fun testClickAtPosition() {
        RecyclerViewScreen.book = Books.CLEANCODE
        // Perform a click on first element in the RecyclerView
        RecyclerViewScreen.tapBookAtPosition()

        BookDetailScreen.book = Books.CLEANCODE
        BookDetailScreen.verifyBookTitle
        BookDetailScreen.verifyBookAuthor
    }

    @Test
    fun testClickOnViewInRow() {
        // Perform click on an element with a specific text
        RecyclerViewScreen.book = Books.CLEANCODE
        RecyclerViewScreen.tapBookWithTitle()

        BookDetailScreen.book = Books.CLEANCODE
        BookDetailScreen.verifyBookTitle

    }
}
