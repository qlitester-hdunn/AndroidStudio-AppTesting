package com.ui.espresso.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ui.espresso.DataAssetsJsonFetch
import com.ui.espresso.R
import com.ui.espresso.adapter.PersonAdapter
import com.ui.espresso.models.Person

class NamesListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val assetFetch = DataAssetsJsonFetch("datanames.json", applicationContext)
        val jsonFileString = assetFetch.getJsonDataFromAsset()

        Log.i("data", jsonFileString)

        val gson = Gson()
        val listPersonType = object : TypeToken<ArrayList<Person>>() {}.type

        var persons: ArrayList<Person> = gson.fromJson(jsonFileString, listPersonType)
        persons.forEachIndexed { idx, person -> Log.i("data", "> Item $idx:\n$person") }

        setContentView(R.layout.activity_custom_list)
        val list = findViewById<View>(R.id.list) as ListView
        list.adapter = PersonAdapter(this, persons)
        list.onItemClickListener = OnItemClickListener { parent, view, position, id ->
            val person = parent.getItemAtPosition(position) as Person
            val intent = Intent(this@NamesListActivity, PersonDetailsActivity::class.java)
            intent.putExtra(PersonDetailsActivity.NAME, person.name)
            intent.putExtra(PersonDetailsActivity.AGE, person.age)
            startActivity(intent)
        }
    }
}
