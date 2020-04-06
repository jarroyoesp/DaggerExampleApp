package com.jarroyo.daggerexampleapplication.ui.home

import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import com.jarroyo.daggerexampleapplication.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : DaggerAppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        configNavigation()
    }

    private fun configNavigation() {
        var navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, activity_home_drawer_layout)
        NavigationUI.setupWithNavController(activity_home_navigationview, navController)
        activity_home_navigationview.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.drawer_home_posts -> {
                Navigation.findNavController(this, R.id.nav_host_fragment ).navigate(R.id.home_navigation_post)
            }

            R.id.drawer_home_profile -> {
                Navigation.findNavController(this, R.id.nav_host_fragment ).navigate(R.id.home_navigation_profile)

            }
        }
        item.setChecked(true)
        activity_home_drawer_layout.closeDrawer(GravityCompat.START)

        return true
    }
}
