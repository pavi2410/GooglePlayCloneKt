package com.pavi2410.googleplayclone.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pavi2410.googleplayclone.R
import kotlinx.android.synthetic.main.item_screenshot.view.*

class AppScreenshotsAdapter(private val screenshots: List<String>) : RecyclerView.Adapter<AppScreenshotsAdapter.AppViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            AppViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_screenshot, parent, false))

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        holder.bind(screenshots[position])
    }

    override fun getItemCount() = screenshots.size

    inner class AppViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        private fun getImage(imageName: String, context: Context) =
                context.resources.getIdentifier(imageName, "drawable", context.packageName)

        fun bind(imageName: String) = with(view) {
            Glide.with(context)
                    .load(getImage(imageName, context))
                    .into(iv_screenshot)
        }
    }
}
