package com.ajf.bookhub.activity

import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.ajf.bookhub.R
import com.ajf.bookhub.fragment.AboutFragment
import com.ajf.bookhub.fragment.DashboardFragment
import com.ajf.bookhub.fragment.FavoriteFragment
import com.ajf.bookhub.fragment.ProfileFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    // Declaring variables.
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var coordinatorLayout: CoordinatorLayout
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var frameLayout: FrameLayout
    private lateinit var navigationView: NavigationView

    private var previousMenuItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Finding views by ids
        drawerLayout = findViewById(R.id.drawerLayout)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        toolbar = findViewById(R.id.toolbar)
        frameLayout = findViewById(R.id.frameLayout)
        navigationView = findViewById(R.id.navigationView)

        // Calling the toolbar function to setup the and enable toolbar and set the title of the ActionBar.
        setUpToolbar()

        // Adding the default fragment view to be displayed when the app is launched.
        // The current default fragment is Dashboard.
        setDefaultFragmentView()

        // Toggle function for the Navigation Drawer.
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )

        // Adding click functionality to the hamburger icon to open the drawer.
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        // Setting up Navigation view and adding fragment of menu items.
        navigationView.setNavigationItemSelectedListener {

            // These are the ui for the menu items in navigation drawer.
            if (previousMenuItem != null) {
                previousMenuItem?.isChecked = false
            }

            // Checking if the current menu item is selected in the drawer.
            it.isCheckable = true
            it.isChecked = true
            // Changing the current menu item to previous.
            previousMenuItem = it

            // Dashboard Fragment
            when (it.itemId) {
                R.id.dashboard -> {
                    setDefaultFragmentView()
                    drawerLayout.closeDrawers()
                }

                // Favorite Fragment
                R.id.favorite -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, FavoriteFragment())
                        .commit()

                    supportActionBar?.title = "Favorites"
                    drawerLayout.closeDrawers()
                }

                // Profile Fragment
                R.id.profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, ProfileFragment())
                        .commit()

                    supportActionBar?.title = "Profile"
                    drawerLayout.closeDrawers()
                }

                // About Us fragment
                R.id.about -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, AboutFragment())
                        .commit()

                    supportActionBar?.title = "About Us"
                    drawerLayout.closeDrawers()
                }
            }

            return@setNavigationItemSelectedListener true
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        when (supportFragmentManager.findFragmentById(R.id.frameLayout)) {
            !is DashboardFragment -> setDefaultFragmentView()
            else -> super.onBackPressed()
        }
    }

    // OnClicked functionality of navigation menu items for e.g. (Dashboard, Favorite, etc.).
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return super.onOptionsItemSelected(item)
    }

    // Toolbar function to add toolbar to the main activity and setup the title of the ActionBar.
    // Also changing the color of the status bar.
    private fun setUpToolbar() {
        setSupportActionBar(toolbar)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)
        supportActionBar?.title = "Toolbar Title"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    // Function to set the default fragment view to be displayed when the app is launched.
    private fun setDefaultFragmentView() {
        val fragment = DashboardFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.commit()
        supportActionBar?.title = "Dashboard"
        navigationView.setCheckedItem(R.id.dashboard)
    }
}