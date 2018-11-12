package com.luoyang.myandroidxstudy.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.luoyang.myandroidxstudy.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_find -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_bought -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_me -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.itemIconTintList = null
        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val navHostFragment = navHost_fragment as NavHostFragment
        navController = navHostFragment.navController;
        NavigationUI.setupWithNavController(bottom_navigation, navController)
        val findToolBarView = layoutInflater.inflate(R.layout.view_find_toolbar, toolbar, false)
        setTopBar(findToolBarView)
    }

    private fun setTopBar(toolBarVeiw: View) {
        toolbar.addView(toolBarVeiw)
        setSupportActionBar(toolbar)
    }
}
