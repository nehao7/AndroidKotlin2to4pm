package com.o7services.androidkotlin2to4pm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecylerAdapter(var list : ArrayList<Student>):RecyclerView.Adapter<RecylerAdapter.Viewholder>(){
    class Viewholder (var view: View):RecyclerView.ViewHolder(view){
        var name=view.findViewById<TextView>(R.id.tvStuName)
        var update=view.findViewById<Button>(R.id.btnUpdate)
        var delete=view.findViewById<Button>(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        var view= LayoutInflater.from(parent.context).inflate(R.layout.base_item_layout,parent,false)
        return Viewholder(view)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.apply {
        name.setText(list[position].name)
        }
    }
}