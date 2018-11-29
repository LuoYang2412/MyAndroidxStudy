package com.luoyang.myandroidxstudy.util

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.FragmentNavigator

@Navigator.Name("bottom_fragment")
class BottomNavViewFragmentNavigator(
    context: Context,
    private val manager: FragmentManager,
    private val containerId: Int
) :
    FragmentNavigator(context, manager, containerId) {

    override fun navigate(
        destination: Destination,
        args: Bundle?,
        navOptions: NavOptions?,
        navigatorExtras: Navigator.Extras?
    ) {
//        super.navigate(destination, args, navOptions, navigatorExtras)
        val tag = destination.toString()
        val transaction = manager.beginTransaction()
        val currentFragment = manager.primaryNavigationFragment
        if (currentFragment != null) {
            transaction.hide(currentFragment)
        }
        var fragment = manager.findFragmentByTag(tag)
        if (fragment == null) {
            fragment = destination.createFragment(args)
            transaction.add(containerId, fragment, tag)
        } else {
            transaction.show(fragment)
        }
        transaction.setPrimaryNavigationFragment(fragment)
        transaction.setReorderingAllowed(true)
        transaction.commit()
        dispatchOnNavigatorNavigated(destination.id, Navigator.BACK_STACK_DESTINATION_ADDED)
    }
}