package com.pavi2410.googleplayclone.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pavi2410.googleplayclone.R
import com.pavi2410.googleplayclone.models.TopFreeAppModel
import kotlinx.android.synthetic.main.item_top_free_app.view.*

class TopFreeAppsAdapter(private val list: List<TopFreeAppModel>) : RecyclerView.Adapter<TopFreeAppsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_top_free_app, parent, false))

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position], position)
    }

    override fun getItemCount() = list.size

    inner class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(model: TopFreeAppModel, position: Int) = with(view) {
            Glide.with(context)
                    .load(model.appImage)
                    .into(iv_app_item)

            tv_app_item_number.text = (position + 1).toString()
            tv_app_name.text = model.appName
            tv_app_developer.text = model.appDeveloper
            tv_app_size.text = model.appSize
            tv_app_ratings.text = model.appRating

            if (model.appRating == "EDITOR'S CHOICE") {
                iv_app_rating.visibility = View.GONE
                tv_app_ratings.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_editors_choice, 0, 0, 0)
            }
        }
    }
}
