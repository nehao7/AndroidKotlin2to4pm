package com.o7services.androidkotlin2to4pm.firebase

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.o7services.androidkotlin2to4pm.databinding.CategoryListItemBinding


class CategoriesListAdapter(var context: Context, var arrayList: ArrayList<CategoriesListModel>):RecyclerView.Adapter<CategoriesListAdapter.ViewHolder>() {

    class ViewHolder(var binding: CategoryListItemBinding):RecyclerView.ViewHolder(binding.root) {


    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding=CategoryListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            binding.tvcategory.setText(arrayList[position].categoryName)



        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

//    interface imageSetting {
//        fun setImage(position: Int,imageView: ImageView)
//    }
}