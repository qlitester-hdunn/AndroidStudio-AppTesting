package com.vgrec.espressoexamples.matchers

import android.view.View
import android.widget.AdapterView
import androidx.core.util.Preconditions
import androidx.test.espresso.matcher.BoundedMatcher
import com.vgrec.espressoexamples.models.Book
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher

/**
 * @author  HDunn, Modified on 4/30/21.
 */
object CustomMatchers {
    /**
     * Finds the AdapterView and let another Matcher interrogate the data within it.
     */
    fun withAdaptedData(dataMatcher: BoundedMatcher<Any?, String?>): TypeSafeMatcher<View?> {
        return object : TypeSafeMatcher<View?>() {
            override fun describeTo(description: Description) {
                description.appendText("with class name: ")
                dataMatcher!!.describeTo(description)
            }

            public override fun matchesSafely(view: View?): Boolean {
                if (view !is AdapterView<*>) {
                    return false
                }
                val adapter = view.adapter
                for (i in 0 until adapter.count) {
                    if (dataMatcher!!.matches(adapter.getItem(i))) {
                        return true
                    }
                }
                return false
            }
        }
    }

    /**
     * Matches an item from an AdapterView with a specific String.
     * (The items in AdapterView should be strings)
     */
    fun withItemContent(expectedText: String?): BoundedMatcher<Any?, String?> {
        Preconditions.checkNotNull(expectedText)
        return withItemContent(Matchers.equalTo(expectedText))
    }

    fun withItemContent(itemTextMatcher: Matcher<String?>): BoundedMatcher<Any?, String?> {
        Preconditions.checkNotNull(itemTextMatcher)
        return object : BoundedMatcher<Any?, String?>(String::class.java) {
            public override fun matchesSafely(text: String?): Boolean {
                return itemTextMatcher.matches(text)
            }

            override fun describeTo(description: Description) {
                description.appendText("with item content: ")
                itemTextMatcher.describeTo(description)
            }
        }
    }

    /**
     * Matches a Book with a specific ID
     */
    fun withBookId(bookId: Int): BoundedMatcher<Any?, Book> {
        return object : BoundedMatcher<Any?, Book>(Book::class.java) {
            override fun matchesSafely(book: Book): Boolean {
                return bookId == book.id
            }

            override fun describeTo(description: Description) {
                description.appendText("with id: $bookId")
            }
        }
    }

    /**
     * Matches a Book with a specific title
     */
    fun withBookTitle(bookTitle: String): BoundedMatcher<Any?, Book> {
        return object : BoundedMatcher<Any?, Book>(Book::class.java) {
            override fun matchesSafely(book: Book): Boolean {
                return bookTitle == book.title
            }

            override fun describeTo(description: Description) {
                description.appendText("with id: $bookTitle")
            }
        }
    }

    /**
     * Matches a Book with a specific author name
     */
    fun withBookAuthor(bookAuthor: String): BoundedMatcher<Any?, Book> {
        return object : BoundedMatcher<Any?, Book>(Book::class.java) {
            override fun matchesSafely(book: Book): Boolean {
                return bookAuthor == book.author
            }

            override fun describeTo(description: Description) {
                description.appendText("with id: $bookAuthor")
            }
        }
    }
}
