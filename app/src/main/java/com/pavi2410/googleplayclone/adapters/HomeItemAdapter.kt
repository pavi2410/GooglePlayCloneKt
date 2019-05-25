package com.pavi2410.googleplayclone.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pavi2410.googleplayclone.R
import com.pavi2410.googleplayclone.models.HomeItemModel
import com.pavi2410.googleplayclone.models.MainItemAppModel
import com.pavi2410.googleplayclone.models.PopularItemAppModel
import kotlinx.android.synthetic.main.item_main.view.*
import kotlinx.android.synthetic.main.item_popular.view.*

class HomeItemAdapter(private val list: List<HomeItemModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            when (viewType) {
                1 -> NormalViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false))
                2 -> PopularViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_popular, parent, false))
            }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (list[position].type) {
            "normal" -> (holder as NormalViewHolder).bind(list[position])
            "special" -> (holder as PopularViewHolder).bind()
        }
    }

    override fun getItemCount() = list.size

    private fun loadNormalList() = arrayListOf(
            MainItemAppModel("Udacity", "4.3", "FREE", R.drawable.ic_udacity),
            MainItemAppModel("Facebook", "4.1", "FREE", R.drawable.logo_facebook),
            MainItemAppModel("Slack", "4.4", "FREE", R.drawable.logo_slack),
            MainItemAppModel("Gmail", "4.3", "FREE", R.drawable.logo_gmail),
            MainItemAppModel("LinkedIn", "4.2", "FREE", R.drawable.logo_linkedin),
            MainItemAppModel("Whatsapp", "4.4", "FREE", R.drawable.logo_whatsapp),
            MainItemAppModel("To do", "4.0", "FREE", R.drawable.logo_to_do),
            MainItemAppModel("Code Monk", "4.3", "FREE", R.drawable.logo_code_monk)
    )

    private fun loadPopularList() = arrayListOf(
            PopularItemAppModel("Awesome Cricket Games", "Enjoy seasonal clones and updates", R.drawable.card_image_1, "1/4"),
            PopularItemAppModel("World Heath Day", "Discover clones for a healthy life", R.drawable.card_image_2, "2/4"),
            PopularItemAppModel("Flat 50% off on clones", "Life stories of clone legends", R.drawable.card_image_3, "3/4"),
            PopularItemAppModel("Clone on Big Screen", "Clones about the sport and players", R.drawable.card_image_4, "4/4")
    )

    inner class NormalViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(model: HomeItemModel) = with(view) {
            header.text = model.header

            if (model.subHeader != "") {
                sub_header.text = model.subHeader
            } else {
                sub_header.isVisible = false
            }

            main_item_app_recycler_view.setHasFixedSize(true)
            main_item_app_recycler_view.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)

            val list = loadNormalList()
            val mainItemAppAdapter = MainItemAppAdapter(list)
            main_item_app_recycler_view.adapter = mainItemAppAdapter
        }
    }

    inner class PopularViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind() = with(view) {
            popular_item_app_recycler_view.setHasFixedSize(true)
            popular_item_app_recycler_view.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)

            val popularList = loadPopularList()
            val popularItemAppAdapter = PopularItemAppAdapter(popularList)
            popular_item_app_recycler_view.adapter = popularItemAppAdapter
        }
    }

    override fun getItemViewType(position: Int) = when (list[position].type) {
        "normal" -> 1
        "special" -> 2
    }
}
