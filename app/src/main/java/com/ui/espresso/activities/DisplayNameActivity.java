package com.ui.espresso.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ui.espresso.R;


public class DisplayNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_name);

        String text = getIntent().getStringExtra(EnterNameActivity.NAME);
        TextView greetingTextView = (TextView) findViewById(R.id.greeting_message);
        greetingTextView.setText("Hello " + text + "!");
    }
}
