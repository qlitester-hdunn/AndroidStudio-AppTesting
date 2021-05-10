package com.ui.espresso.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ui.espresso.DataAssetsJsonFetch;
import com.ui.espresso.R;
import com.ui.espresso.adapter.PersonAdapter;
import com.ui.espresso.models.Person;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class NamesListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DataAssetsJsonFetch assetFetch;
        assetFetch = new DataAssetsJsonFetch("datanames.json", getApplicationContext());
        String jsonFileString = assetFetch.getJsonDataAsset();

        Log.i("data", jsonFileString);

        Gson gson = new Gson();
        Type listPersonType = new TypeToken<ArrayList<Person>> (){}.getType();

        ArrayList<Person> persons  = gson.fromJson(jsonFileString, listPersonType);
        int index = 0;
        for (Person person : persons) {
            Log.i("data", "> Item " + index + ":\n" + person);
            index +=1;
        }

        setContentView(R.layout.activity_custom_list);

        ListView list = findViewById(R.id.list);
        list.setAdapter(new PersonAdapter(this, persons));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Person person = (Person) parent.getItemAtPosition(position);
                Intent intent = new Intent(NamesListActivity.this, PersonDetailsActivity.class);
                intent.putExtra(PersonDetailsActivity.NAME, person.getName());
                intent.putExtra(PersonDetailsActivity.AGE, person.getAge());
                startActivity(intent);
            }
        });
    }
}
