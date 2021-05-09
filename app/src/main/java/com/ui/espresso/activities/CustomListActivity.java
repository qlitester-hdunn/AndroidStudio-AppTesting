package com.ui.espresso.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.ui.espresso.Database;
import com.ui.espresso.R;
import com.ui.espresso.adapter.BooksAdapter;
import com.ui.espresso.models.Book;


public class CustomListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(new BooksAdapter(this, Database.ALL_BOOKS));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Book book = (Book) parent.getItemAtPosition(position);
                Intent intent = new Intent(CustomListActivity.this, BookDetailsActivity.class);
                intent.putExtra(BookDetailsActivity.TITLE, book.getTitle());
                intent.putExtra(BookDetailsActivity.AUTHOR, book.getAuthor());
                startActivity(intent);
            }
        });
    }
}
