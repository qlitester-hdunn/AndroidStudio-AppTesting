package com.ui.espresso.activities

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ui.espresso.DataAssetsJsonFetch
import com.ui.espresso.models.Person


class ConvertJson(var appContext: Context, var jsonFileName: String = "datanames.json"){

    fun getPersonFromData(): ArrayList<Person> {
        val assetFetch = DataAssetsJsonFetch(this.jsonFileName, this.appContext)
        val jsonFileString: String? = assetFetch.getJsonDataFromAsset()

        Log.i("data", "$this.jsonFileString")

        val gson = Gson()

        val listPersonType = object : TypeToken<ArrayList<Person>>() {}.type

        val persons: ArrayList<Person> = gson.fromJson(jsonFileString, listPersonType)

        persons.forEachIndexed { idx, person -> Log.i("data", "> Item $idx:\n$person") }

        return persons
    }
}
