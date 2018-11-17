package com.luoyang.myandroidxstudy.ui

import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ActionMenuView
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.luoyang.myandroidxstudy.R
import com.luoyang.myandroidxstudy.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_toolbar.*

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
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setSupportActionBar(toolbar)

        bottom_navigation.itemIconTintList = null
        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val navHostFragment = navHost_fragment as NavHostFragment
        navController = navHostFragment.navController;
        NavigationUI.setupWithNavController(bottom_navigation, navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.find, menu)
        val searchView = menu?.findItem(R.id.menu_search)?.actionView as SearchView
        searchView.setIconifiedByDefault(false)
        searchView.queryHint = resources.getString(R.string.search)
        ViewCompat.setBackground(searchView, resources.getDrawable(R.drawable.edit_search_bg))
        val layoutParams = ActionMenuView.LayoutParams(window.decorView.width, ActionMenuView.LayoutParams.WRAP_CONTENT)
        layoutParams.gravity = Gravity.CENTER
        searchView.layoutParams = layoutParams
        return super.onCreateOptionsMenu(menu)
    }
}
