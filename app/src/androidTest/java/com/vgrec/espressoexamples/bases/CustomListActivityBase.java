package com.vgrec.espressoexamples.bases;

import android.app.Activity;
import android.content.Intent;

import androidx.test.rule.ActivityTestRule;

import com.vgrec.espressoexamples.activities.CustomListActivity;

import org.junit.Before;
import org.junit.Rule;

public class CustomListActivityBase {
    private Activity customListActivity;

    @Rule
    public ActivityTestRule<CustomListActivity> activityRule = new ActivityTestRule(
            CustomListActivity.class, true, false);
//    {
//        @Override
//        protected Intent getActivityIntent() {
//            InstrumentationRegistry.getTargetContext();
//            Intent intent = new Intent(Intent.ACTION_MAIN);
//            //intent.putExtra("MYKEY", "Hello");
//            return intent;
//        }
//    };

    @Before
    public void setUp(){
        Intent intent = new Intent();
//        intent.putExtra("EXTRA", "Test");
        customListActivity = activityRule.launchActivity(intent);
    }
}
