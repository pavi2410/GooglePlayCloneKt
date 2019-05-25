package com.pavi2410.googleplayclone.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pavi2410.googleplayclone.R
import com.pavi2410.googleplayclone.models.AllCategoryItemAppModel
import kotlinx.android.synthetic.main.item_all_category.view.*

class AllCategoryItemAppAdapter(private val list: List<AllCategoryItemAppModel>) : RecyclerView.Adapter<AllCategoryItemAppAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_all_category, parent, false))

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(model: AllCategoryItemAppModel) = with(view) {
            tv_all_category_app_name.text = model.appName
            civ_all_category_app_image.setImageResource(model.appImage)
        }
    }
}
