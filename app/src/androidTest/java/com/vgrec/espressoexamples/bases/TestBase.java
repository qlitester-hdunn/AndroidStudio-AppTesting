package com.vgrec.espressoexamples.bases;

import androidx.test.rule.ActivityTestRule;

import com.vgrec.espressoexamples.activities.MainActivity;

import org.junit.Before;
import org.junit.Rule;

public class TestBase {
    public MainActivity activity;

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() {
        this.activity = rule.getActivity();
    }
}
