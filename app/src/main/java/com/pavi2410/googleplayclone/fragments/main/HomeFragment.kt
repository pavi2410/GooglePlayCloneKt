package com.pavi2410.googleplayclone.fragments.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.pavi2410.googleplayclone.R
import com.pavi2410.googleplayclone.adapters.ViewPagerAdapter
import com.pavi2410.googleplayclone.fragments.home.HomeCategoriesFragment
import com.pavi2410.googleplayclone.fragments.home.HomeForYouFragment
import com.pavi2410.googleplayclone.fragments.home.HomeTopChartsFragment
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private lateinit var subTabLayout: TabLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val viewPager = view.homeViewPager
        setupViewPager(viewPager)

        subTabLayout = view.sub_tabs
        subTabLayout.setupWithViewPager(viewPager)
        setupTabIcons()

        return view
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = activity?.supportFragmentManager?.let { ViewPagerAdapter(it) }?.apply {
            addFragment(HomeForYouFragment(), "For You")
            addFragment(HomeTopChartsFragment(), "Top Charts")
            addFragment(HomeCategoriesFragment(), "Categories")
            addFragment(HomeForYouFragment(), "Genres")
            addFragment(HomeTopChartsFragment(), "Editor's Choice")
        }
        viewPager.adapter = adapter
    }

    private fun setupTabIcons() {
        subTabLayout.getTabAt(0)?.customView = createTab(text = R.string.tab_one, icon = R.drawable.ic_explorer)
        subTabLayout.getTabAt(1)?.customView = createTab(text = R.string.tab_two, icon = R.drawable.ic_star)
        subTabLayout.getTabAt(2)?.customView = createTab(text = R.string.tab_three, icon = R.drawable.ic_category)
        subTabLayout.getTabAt(3)?.customView = createTab(text = R.string.tab_four, icon = R.drawable.ic_circle_star)
        subTabLayout.getTabAt(4)?.customView = createTab(text = R.string.tab_five, icon = R.drawable.ic_verified)
    }

    private fun createTab(@StringRes text: Int, @DrawableRes icon: Int): TextView {
        val textView = LayoutInflater.from(context).inflate(R.layout.custom_sub_tab, null) as TextView
        textView.setText(text)
        textView.setCompoundDrawablesWithIntrinsicBounds(0, icon, 0, 0)
        return textView
    }
}
