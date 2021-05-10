package com.ui.espresso.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.ui.espresso.R;
import com.ui.espresso.adapter.PersonAdapter;
import com.ui.espresso.models.Person;

import java.util.ArrayList;


public class NamesListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ConvertJson convertFetchedData =  new ConvertJson(getApplicationContext(), "datanames.json");
        ArrayList<Person> persons = convertFetchedData.getPersonFromData();

        setContentView(R.layout.activity_custom_list);

        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(new PersonAdapter(this, persons));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)  {
                Person person = (Person) parent.getItemAtPosition(position);
                Intent intent = new Intent(NamesListActivity.this,
                        PersonDetailsActivity.class);
                intent.putExtra(PersonDetailsActivity.NAME, person.getName());
                intent.putExtra(PersonDetailsActivity.AGE, person.getAge());
                intent.putExtra(PersonDetailsActivity.MSG, person.getMessages().toString());
                startActivity(intent);
            }
        });
    }
}
