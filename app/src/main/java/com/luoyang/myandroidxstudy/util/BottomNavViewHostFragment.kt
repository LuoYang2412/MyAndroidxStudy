package com.luoyang.myandroidxstudy.util

import androidx.navigation.Navigator
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.NavHostFragment

class BottomNavViewHostFragment : NavHostFragment() {
    override fun createFragmentNavigator(): Navigator<out FragmentNavigator.Destination> {
        return BottomNavViewFragmentNavigator(requireContext(), childFragmentManager, id)
    }
}