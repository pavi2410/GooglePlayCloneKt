package com.pavi2410.googleplayclone.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pavi2410.googleplayclone.R
import com.pavi2410.googleplayclone.models.PopularItemAppModel
import kotlinx.android.synthetic.main.item_popular_app.view.*

class PopularItemAppAdapter(private val list: List<PopularItemAppModel>) : RecyclerView.Adapter<PopularItemAppAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_popular_app, parent, false))

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(model: PopularItemAppModel) = with(view) {
            Glide.with(context)
                    .load(model.itemImage)
                    .into(pop_item_image)

            pop_item_header.text = model.itemHeader
            pop_item_sub_header.text = model.itemSubHeader
            tv_card_number.text = model.itemNumber
        }
    }
}
