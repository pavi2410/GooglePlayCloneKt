package com.pavi2410.googleplayclone.activities

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager

import com.bumptech.glide.Glide
import com.google.android.material.navigation.NavigationView
import com.pavi2410.googleplayclone.R
import com.pavi2410.googleplayclone.adapters.ViewPagerAdapter
import com.pavi2410.googleplayclone.fragments.main.HomeFragment
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = mainViewPager
        setupViewPager(viewPager)

        val tabLayout = tabs
        tabLayout.setupWithViewPager(viewPager)

        val searchView = search_view

        searchView.setOnQueryChangeListener { oldQuery, newQuery ->
            Toast.makeText(this, "oldQuery = $oldQuery, newQuery = $newQuery", Toast.LENGTH_SHORT).show()
        }

        drawer = drawer_layout
        val toggle = ActionBarDrawerToggle(
                this, drawer, null,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = nav_view
        navigationView.itemIconTintList = null

        val profileImageView = navigationView.getHeaderView(0).findViewById<CircleImageView>(R.id.profile_image)
        Glide.with(this)
                .load(R.drawable.profile_image)
                .into(profileImageView)

        searchView.attachNavigationDrawerToMenuButton(drawer)
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager).apply {
            addFragment(HomeFragment(), "Home")
            addFragment(HomeFragment(), "Games")
            addFragment(HomeFragment(), "Movies")
            addFragment(HomeFragment(), "Books")
            addFragment(HomeFragment(), "Music")
        }
        viewPager.adapter = adapter
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
