package com.vgrec.espressoexamples.provider;

import android.content.SearchRecentSuggestionsProvider;

/**
 * @author  HDunn, Modified on 4/30/21.
 */
public class AppRecentSearchesProvider extends SearchRecentSuggestionsProvider {

    public final static String AUTHORITY = "com.vgrec.espressoexamples";
    public final static int MODE = DATABASE_MODE_QUERIES;

    public AppRecentSearchesProvider() {
        setupSuggestions(AUTHORITY, MODE);
    }

}
