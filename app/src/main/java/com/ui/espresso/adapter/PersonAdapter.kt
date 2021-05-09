package com.ui.espresso.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.ui.espresso.R
import com.ui.espresso.models.Book
import com.ui.espresso.models.Person
import java.util.*

/**
 * Adapter that provides views for the list
 */
class PersonAdapter(context: Context?, private val items: ArrayList<Person>) : BaseAdapter() {
    private val inflater: LayoutInflater
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
        var convertView = convertView
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_person, parent, false)
        }
        val personName = convertView.findViewById<View>(R.id.person_name) as TextView
        personName.text = items[position].name
        val personAge = convertView.findViewById<View>(R.id.person_age) as TextView
        personAge.text = "by " + items[position].age
        return convertView
    }

    init {
        inflater = LayoutInflater.from(context)
    }
}
