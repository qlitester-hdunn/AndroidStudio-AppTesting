package com.vgrec.espressoexamples.bases

import android.app.Activity
import android.content.Intent
import androidx.test.rule.ActivityTestRule
import com.vgrec.espressoexamples.activities.CustomListActivity
import org.junit.Before
import org.junit.Rule

open class CustomListActivityBase {
    private var customListActivity: Activity? = null

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(
            CustomListActivity::class.java, true, false)

    @Before
    fun setUp() {
        val intent = Intent()
        customListActivity = activityRule.launchActivity(intent)
    }
}
