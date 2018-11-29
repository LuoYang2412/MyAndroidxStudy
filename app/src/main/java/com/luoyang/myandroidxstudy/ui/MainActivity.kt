package com.luoyang.myandroidxstudy.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.luoyang.myandroidxstudy.R
import com.luoyang.myandroidxstudy.util.ToastUtil
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_toolbar.*

class MainActivity : AppCompatActivity() {
    private lateinit var currentFragment: NavHostFragment
    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_find -> {
                    supportFragmentManager.beginTransaction().hide(currentFragment).show(navHost_fragment_find).commit()
                    currentFragment = navHost_fragment_find as NavHostFragment
                    NavigationUI.setupWithNavController(toolbar, currentFragment.navController)
                    invalidateOptionsMenu()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_bought -> {
                    supportFragmentManager.beginTransaction().hide(currentFragment).show(navHost_fragment_bought)
                        .commit()
                    currentFragment = navHost_fragment_bought as NavHostFragment
                    NavigationUI.setupWithNavController(toolbar, currentFragment.navController)
                    invalidateOptionsMenu()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_me -> {
                    supportFragmentManager.beginTransaction().hide(currentFragment).show(navHost_fragment_me).commit()
                    currentFragment = navHost_fragment_me as NavHostFragment
                    NavigationUI.setupWithNavController(toolbar, currentFragment.navController)
                    invalidateOptionsMenu()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        bottom_navigation.itemIconTintList = null
        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        supportFragmentManager.beginTransaction().hide(navHost_fragment_bought).commit()
        supportFragmentManager.beginTransaction().hide(navHost_fragment_me).commit()
        supportFragmentManager.beginTransaction().show(navHost_fragment_find).commit()
        currentFragment = navHost_fragment_find as NavHostFragment

        NavigationUI.setupWithNavController(toolbar, currentFragment.navController)
    }

    internal var oneTime = 0L
    override fun onBackPressed() {
        val fragment = currentFragment.childFragmentManager.primaryNavigationFragment
        if (fragment is FindFragment || fragment is BoughtFragment || fragment is MeFragment) {
            val towTime = System.currentTimeMillis()
            if (towTime - oneTime < 1000) {
                super.onBackPressed()
            } else {
                ToastUtil.show("再按一次退出")
                oneTime = towTime
            }
        } else {
            currentFragment.navController.navigateUp()
        }
    }
}
