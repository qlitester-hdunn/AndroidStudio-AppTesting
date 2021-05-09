package com.ui.espresso.activities

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ui.espresso.R

class PersonDetailsActivity : AppCompatActivity() {
    companion object {
        const val NAME = "name"
        const val AGE = "age"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_details)
        val name = findViewById<View>(R.id.person_name) as TextView
        val age = findViewById<View>(R.id.person_age) as TextView
        name.text = intent.getStringExtra(NAME)
        age.text = intent.getStringExtra(AGE)
    }
}
