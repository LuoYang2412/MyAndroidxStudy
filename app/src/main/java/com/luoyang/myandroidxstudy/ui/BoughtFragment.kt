package com.luoyang.myandroidxstudy.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.luoyang.myandroidxstudy.R

class BoughtFragment : Fragment() {

    companion object {
        fun newInstance() = BoughtFragment()
    }

    private lateinit var viewModel: BoughtViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bought_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BoughtViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
