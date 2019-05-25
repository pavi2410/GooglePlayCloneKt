package com.pavi2410.googleplayclone.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pavi2410.googleplayclone.R
import com.pavi2410.googleplayclone.activities.AppActivity
import com.pavi2410.googleplayclone.models.MainItemAppModel
import kotlinx.android.synthetic.main.item_main_app.view.*

class MainItemAppAdapter(private val list: List<MainItemAppModel>) : RecyclerView.Adapter<MainItemAppAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_main_app, parent, false))

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(model: MainItemAppModel) = with(view) {
            Glide.with(context)
                    .load(model.appImage)
                    .into(iv_app_image)

            tv_app_name.text = model.appName
            tv_app_rating.text = model.appRating

            cardViewLayout.setOnClickListener {
                val intent = Intent(context, AppActivity::class.java)
                context.startActivity(intent)
            }
        }
    }
}
