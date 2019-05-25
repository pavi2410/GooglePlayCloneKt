package com.pavi2410.googleplayclone.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pavi2410.googleplayclone.R
import com.pavi2410.googleplayclone.adapters.AllCategoryItemAppAdapter
import com.pavi2410.googleplayclone.adapters.TopCategoryItemAppAdapter
import com.pavi2410.googleplayclone.models.AllCategoryItemAppModel
import com.pavi2410.googleplayclone.models.TopCategoryItemAppModel
import kotlinx.android.synthetic.main.fragment_categories.*
import kotlinx.android.synthetic.main.fragment_categories.view.*

class HomeCategoriesFragment : Fragment() {

    private lateinit var topCategoriesRecyclerView: RecyclerView
    private lateinit var allCategoriesRecyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_categories, container, false)
        topCategoriesRecyclerView = view.rv_top_categories
        allCategoriesRecyclerView = view.rv_all_categories
        configureRecyclerViews()

        return view
    }

    private fun configureRecyclerViews() {
        topCategoriesRecyclerView.setHasFixedSize(true)
        val horizontalLayoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        topCategoriesRecyclerView.layoutManager = horizontalLayoutManager

        allCategoriesRecyclerView.setHasFixedSize(true)
        val verticalLayoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        allCategoriesRecyclerView.layoutManager = verticalLayoutManager

        loadDataAndSetAdapter()
    }

    private fun loadDataAndSetAdapter() {
        val topCategoryItemAppModelsList = arrayListOf(
                TopCategoryItemAppModel("Photography", R.drawable.camera),
                TopCategoryItemAppModel("Family", R.drawable.family),
                TopCategoryItemAppModel("Airtel", R.drawable.access_point_network),
                TopCategoryItemAppModel("Music & Audio", R.drawable.music),
                TopCategoryItemAppModel("Entertainment", R.drawable.gamepad)
        )
        topCategoriesRecyclerView.adapter = TopCategoryItemAppAdapter(topCategoryItemAppModelsList)

        val allCategoryItemAppModelsList = arrayListOf(
                AllCategoryItemAppModel("Art & Design", R.drawable.brush),
                AllCategoryItemAppModel("Auto & Vehicles", R.drawable.car),
                AllCategoryItemAppModel("Beauty", R.drawable.spotlight_beam),
                AllCategoryItemAppModel("Books & Reference", R.drawable.book_open),
                AllCategoryItemAppModel("Business", R.drawable.domain),
                AllCategoryItemAppModel("Comics", R.drawable.thought_bubble),
                AllCategoryItemAppModel("Communication", R.drawable.forum),
                AllCategoryItemAppModel("Dating", R.drawable.clover),
                AllCategoryItemAppModel("Education", R.drawable.mailbox),
                AllCategoryItemAppModel("Entertainment", R.drawable.gamepad)
        )
        allCategoriesRecyclerView.adapter = AllCategoryItemAppAdapter(allCategoryItemAppModelsList)
    }
}
