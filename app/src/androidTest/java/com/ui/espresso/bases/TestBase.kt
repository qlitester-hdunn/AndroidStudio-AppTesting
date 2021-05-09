package com.ui.espresso.bases

import androidx.test.rule.ActivityTestRule
import com.ui.espresso.activities.MainActivity
import org.junit.Before
import org.junit.Rule

open class TestBase {
    var activity: MainActivity? = null

    @Rule
    @JvmField
    var rule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        activity = rule.activity
    }
}
