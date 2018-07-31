package com.samset.kotlinnavigationdrawer

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.android.yana.NavListAdapter
import com.samset.kotlinnavigationdrawer.R.id.drawer_layout
import com.samset.kotlinnavigationdrawer.listeners.OnItemClickListeners

class MainActivity : AppCompatActivity() {
     lateinit var toolbar: Toolbar
     lateinit var recyclerView: RecyclerView
     lateinit var navadapter: NavListAdapter
     lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavigationDrawer()
    }

    private fun setupNavigationDrawer() {
        setSupportActionBar(toolbar)

        setupDrawerToggle()
        val headers = resources.getStringArray(R.array.nav_drawer_labels)
        navadapter = NavListAdapter(headers)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter = navadapter
        navadapter.setListeners(object : OnItemClickListeners {
            override fun onClickItem(view: View, position: Int) {
                drawerLayout.closeDrawers()
                //navigateFragment(position)
            }
        })
    }

    private fun setupDrawerToggle() {
        toolbar.setNavigationOnClickListener {
            if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                drawerLayout.closeDrawer(Gravity.RIGHT)
            } else {
                drawerLayout.openDrawer(Gravity.RIGHT)
            }
        }

        val mDrawerToggle = object : ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            override fun onDrawerClosed(drawerView: View) {
                //drawer_layout.openDrawer(Gravity.LEFT);
                invalidateOptionsMenu() // Creates call to onPrepareOptionsMenu().
            }

            override fun onDrawerOpened(drawerView: View) {
                //drawer_layout.openDrawer(Gravity.RIGHT);
                invalidateOptionsMenu() // Creates call to onPrepareOptionsMenu().
            }
        }
        drawerLayout.addDrawerListener(mDrawerToggle)
        mDrawerToggle.syncState()

    }

}
