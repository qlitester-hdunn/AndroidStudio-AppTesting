package com.ui.espresso

import com.ui.espresso.bases.CustomListActivityBase
import com.ui.espresso.constants.Books
import com.ui.espresso.screens.CustomListScreen
import org.junit.Test

/**
 * @author  HDunn, Modified on 4/30/21.
 */
class CustomListTest : CustomListActivityBase() {
    @Test
    fun testOpenBookById() {
        CustomListScreen.book = Books.JAVACONCURENCY

        // Click on the Book with ID 5
        CustomListScreen.tapBook(5)

        // Check the correct book title is displayed
        CustomListScreen.verifyBookTitle

        // Check the correct author is displayed
        CustomListScreen.verifyBookAuthor
    }

    @Test
    fun testOpenBookByTitleAndAuthor() {
        CustomListScreen.book = Books.JAVACONCURENCY
        // Match a book with a specific title and author name
        CustomListScreen.tapBookWithTitleAndAuthor()
        // Check the correct book title is displayed
        CustomListScreen.verifyBookTitle

        // Check the correct author is displayed
        CustomListScreen.verifyBookAuthor
    }

    @Test
    fun testClickOnBookByPosition() {
        CustomListScreen.book = Books.JAVACONCURENCY

        CustomListScreen.tapBookPosition(5)
        CustomListScreen.verifyBookTitle
        CustomListScreen.verifyBookAuthor
    }

}
