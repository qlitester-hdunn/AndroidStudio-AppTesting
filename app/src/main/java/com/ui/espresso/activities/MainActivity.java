package com.ui.espresso.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ui.espresso.R;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListener(R.id.type_text_button, EnterNameActivity.class);
        setListener(R.id.spinner_selection_button, SpinnerSelectionActivity.class);
        setListener(R.id.custom_list_adapter_button, CustomListActivity.class);
        setListener(R.id.person_list_adapter_button, NamesListActivity.class);
        setListener(R.id.search_view_button, SearchViewActivity.class);
        setListener(R.id.action_bar_button, ActionBarExampleActivity.class);
        setListener(R.id.viewpager_button, ViewPagerActivity.class);
        setListener(R.id.dialogs_button, DialogExampleActivity.class);
        setListener(R.id.recycler_view_button, RecyclerViewActivity.class);
        setListener(R.id.pickers_button, DateTimePickerActivity.class);
    }

    private <T extends AppCompatActivity> void setListener(int buttonResId, final Class<T> activity) {
        findViewById(buttonResId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, activity));
            }
        });
    }
}
