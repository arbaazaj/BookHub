package com.ajf.bookhub

import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var coordinatorLayout: CoordinatorLayout
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var frameLayout: FrameLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        toolbar = findViewById(R.id.toolbar)
        frameLayout = findViewById(R.id.frameLayout)
        navigationView = findViewById(R.id.navigationView)

        setUpToolbar()

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.dashboard -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, DashboardFragment())
                        .addToBackStack("Dashboard")
                        .commit()

                    drawerLayout.closeDrawers()
                }

                R.id.favorite -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, FavoriteFragment())
                        .addToBackStack("Favorites")
                        .commit()

                    drawerLayout.closeDrawers()
                }

                R.id.profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, ProfileFragment())
                        .addToBackStack("Profile")
                        .commit()

                    drawerLayout.closeDrawers()
                }

                R.id.about -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, AboutFragment())
                        .addToBackStack("About")
                        .commit()

                    drawerLayout.closeDrawers()
                }
            }

            return@setNavigationItemSelectedListener true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setUpToolbar() {
        setSupportActionBar(toolbar)
        window.statusBarColor = ContextCompat.getColor(this, R.color.primaryColorDark)
        supportActionBar?.title = "Toolbar Title"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}