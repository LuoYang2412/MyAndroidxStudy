package com.luoyang.myandroidxstudy.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.luoyang.myandroidxstudy.databinding.FindFragmentBinding

class FindFragment : Fragment() {

    companion object {
        fun newInstance() = FindFragment()
    }

    private lateinit var viewModel: FindViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FindFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FindViewModel::class.java)
        // TODO: Use the ViewModel
    }
}
