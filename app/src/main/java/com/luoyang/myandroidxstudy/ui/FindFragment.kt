package com.luoyang.myandroidxstudy.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.gson.JsonObject
import com.luoyang.myandroidxstudy.api.ResponseData
import com.luoyang.myandroidxstudy.databinding.FindFragmentBinding
import kotlinx.android.synthetic.main.find_fragment.*

class FindFragment : Fragment() {

    companion object {
        fun newInstance() = FindFragment()
    }

    private lateinit var viewModel: FindViewModel
    private lateinit var binding: FindFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FindFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FindViewModel::class.java)
        val observer = Observer<ResponseData<JsonObject>>() {
            when (it.success) {
                true -> binding.query = it.data.toString()
                false -> binding.query = it.message
            }
        }
        viewModel.getQuery().observe(this, observer)
    }
}
