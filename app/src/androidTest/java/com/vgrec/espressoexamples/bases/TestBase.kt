package com.vgrec.espressoexamples.bases

import androidx.test.rule.ActivityTestRule
import com.vgrec.espressoexamples.activities.MainActivity
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
