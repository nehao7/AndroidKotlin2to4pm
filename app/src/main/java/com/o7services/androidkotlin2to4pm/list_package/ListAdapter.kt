package com.o7services.androidkotlin2to4pm.list_package

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.o7services.androidkotlin2to4pm.R

class ListAdapter(var list : ArrayList<Student>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
       // return 10
    }

    override fun getItem(position: Int): Any {
      //  return ""
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view =LayoutInflater.from(parent?.context)
            .inflate(R.layout.base_item_layout,parent,false)

        var rollNo=view.findViewById<TextView>(R.id.tvRollno)
        rollNo.setText(list[position].rollNo.toString())
        var name=view.findViewById<TextView>(R.id.tvStuName)
        name.setText(list[position].name)
        return view
    }


}

