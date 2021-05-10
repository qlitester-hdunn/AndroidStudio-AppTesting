package com.ui.espresso.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.ui.espresso.R
import com.ui.espresso.models.Person

/**
 * Adapter that provides views for the list
 */
class PersonAdapter(
        var context: Context,
        private var items: ArrayList<Person>

) : BaseAdapter() {

    private val inflater: LayoutInflater

    init {
        this.inflater = LayoutInflater.from(this.context)
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertedView: View? = convertView
        if (convertView == null) {
            convertedView = inflater.inflate(R.layout.item_person, parent, false)
        }

        val personName = convertedView!!.findViewById<View>(R.id.person_name) as TextView
        personName.text = items[position].getName()

        val personAge = convertedView.findViewById<View>(R.id.person_age) as TextView
        personAge.text = "by " + items[position].getAge()

        val personMsg = convertedView.findViewById<View>(R.id.person_messages) as TextView
        personMsg.text = "say " + items[position].getMessages().toString()

        return convertedView
    }

}
