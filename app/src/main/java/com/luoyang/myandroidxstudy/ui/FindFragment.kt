package com.luoyang.myandroidxstudy.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.luoyang.myandroidxstudy.R

class FindFragment : Fragment() {

    companion object {
        fun newInstance() = FindFragment()
    }

    private lateinit var viewModel: FindViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.find_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FindViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
