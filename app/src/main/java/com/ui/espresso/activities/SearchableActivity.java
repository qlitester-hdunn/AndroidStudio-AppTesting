package com.ui.espresso.activities;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ui.espresso.Database;
import com.ui.espresso.R;
import com.ui.espresso.provider.AppRecentSearchesProvider;

import java.util.ArrayList;
import java.util.List;


public class SearchableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchable);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setEmptyView(findViewById(R.id.empty_view));

        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            List<String> results = search(query);
            listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, results));
            saveRecentQuery(query);
        }
    }

    private void saveRecentQuery(String query) {
        SearchRecentSuggestions suggestions = new SearchRecentSuggestions(
                this,
                AppRecentSearchesProvider.AUTHORITY,
                AppRecentSearchesProvider.MODE);
        suggestions.saveRecentQuery(query, null);
    }

    private List<String> search(String query) {
        List<String> results = new ArrayList<>();

        for (String record : Database.CITIES) {
            if (record.toLowerCase().startsWith(query.toLowerCase())) {
                results.add(record);
            }
        }

        return results;
    }
}
