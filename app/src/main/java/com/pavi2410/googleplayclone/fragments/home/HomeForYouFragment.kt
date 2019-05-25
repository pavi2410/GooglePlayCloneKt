package com.pavi2410.googleplayclone.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pavi2410.googleplayclone.R
import com.pavi2410.googleplayclone.adapters.HomeItemAdapter
import com.pavi2410.googleplayclone.models.HomeItemModel
import kotlinx.android.synthetic.main.fragment_for_you.view.*

class HomeForYouFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_for_you, container, false)
        recyclerView = view.for_you_recycler_view
        configureMainRecyclerView()

        return view
    }

    private fun configureMainRecyclerView() {
        recyclerView.run {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        }
        loadMainItemsData()
    }

    private fun loadMainItemsData() {

        val arrayList = arrayListOf(
                HomeItemModel("", "", "special"),
                HomeItemModel("New + Updated Games", "Selected games of the week", "normal"),
                HomeItemModel("Recommended for you", "", "normal"),
                HomeItemModel("Get Stuff Done", "", "normal")
        )

        val homeItemAdapter = HomeItemAdapter(arrayList)
        recyclerView.adapter = homeItemAdapter

    }
}
