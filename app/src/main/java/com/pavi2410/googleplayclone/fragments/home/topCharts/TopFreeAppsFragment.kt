package com.pavi2410.googleplayclone.fragments.home.topCharts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pavi2410.googleplayclone.R
import com.pavi2410.googleplayclone.adapters.TopFreeAppsAdapter
import com.pavi2410.googleplayclone.models.TopFreeAppModel
import kotlinx.android.synthetic.main.fragment_top_free_apps.*

class TopFreeAppsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_top_free_apps, container, false)
        configureMainRecyclerView()

        return view
    }

    private fun configureMainRecyclerView() {
        recyclerView = rv_top_app_list

        recyclerView.run {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)

            val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)

            activity?.let {
                ContextCompat.getDrawable(it, R.drawable.line_divider)?.let { drawable ->
                    divider.setDrawable(drawable)
                }
            }

            addItemDecoration(divider)
        }

        loadAdapterData()
    }

    private fun loadAdapterData() {

        val arrayList = arrayListOf(
                TopFreeAppModel("Udacity - Lifelong Learning", "Udacity, Inc.", "28 MB", "4.3", R.drawable.ic_udacity),
                TopFreeAppModel("Gmail", "Google LLC", "20 MB", "EDITOR'S CHOICE", R.drawable.logo_gmail),
                TopFreeAppModel("Slack", "Slack Technologies Inc.", "26 MB", "4.4", R.drawable.logo_slack),
                TopFreeAppModel("LinkedIn", "LinkedIn", "37 MB", "4.2", R.drawable.logo_linkedin),
                TopFreeAppModel("Microsoft To-Do", "Microsoft Corporation", "9.9 MB", "4.0", R.drawable.logo_to_do),
                TopFreeAppModel("WhatsApp Messenger", "WhatsApp Inc.", "5.3 MB", "EDITOR'S CHOICE", R.drawable.logo_whatsapp),
                TopFreeAppModel("Facebook", "Facebook", "12 MB", "4.1", R.drawable.logo_facebook),
                TopFreeAppModel("Twitter", "Twitter, Inc", "39 MB", "4.3", R.drawable.logo_twitter),
                TopFreeAppModel("Code Monk", "Hacker Earth", "6.8 MB", "4.3", R.drawable.logo_code_monk)
        )

        val topFreeAppsAdapter = TopFreeAppsAdapter(arrayList)
        recyclerView.adapter = topFreeAppsAdapter
    }
}
