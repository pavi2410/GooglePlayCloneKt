package com.pavi2410.googleplayclone.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.pavi2410.googleplayclone.R
import com.pavi2410.googleplayclone.adapters.ViewPagerAdapter
import com.pavi2410.googleplayclone.fragments.home.topCharts.TopFreeAppsFragment
import kotlinx.android.synthetic.main.fragment_top_charts.*

class HomeTopChartsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_top_charts, container, false)

        val viewPager = vp_app_list
        setupViewPager(viewPager)

        val subTabLayout = tl_app_list
        subTabLayout.setupWithViewPager(viewPager)

        return view
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = activity?.supportFragmentManager?.let { ViewPagerAdapter(it) }?.apply {
            addFragment(TopFreeAppsFragment(), "TOP FREE APPS")
            addFragment(TopFreeAppsFragment(), "TOP FREE GAMES")
            addFragment(TopFreeAppsFragment(), "TOP GROSSING")
            addFragment(TopFreeAppsFragment(), "TRENDING")
        }
        viewPager.adapter = adapter
    }
}
