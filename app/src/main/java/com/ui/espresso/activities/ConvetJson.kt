package com.ui.espresso.activities

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ui.espresso.DataAssetsJsonFetch
import com.ui.espresso.models.Person

object ConvertJson(jsonFileName: String = "datanames.json"){
    val assetFetch = DataAssetsJsonFetch(jsonFileName, applicationContext)
    private val jsonFileString = assetFetch.getJsonDataFromAsset()

    Log.i("data", jsonFileString)

    val gson = Gson()
    val listPersonType = object : TypeToken<ArrayList<Person>>() {}.type

    var persons: ArrayList<Person> = gson.fromJson(jsonFileString, listPersonType)
    persons.forEachIndexed { idx, person -> Log.i("data", "> Item $idx:\n$person") }
}
