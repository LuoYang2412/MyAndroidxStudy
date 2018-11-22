package com.luoyang.myandroidxstudy.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.gson.JsonObject
import com.luoyang.myandroidxstudy.R
import kotlinx.android.synthetic.main.find_fragment.*

class FindFragment : Fragment() {

    companion object {
        fun newInstance() = FindFragment()
    }

    private lateinit var viewModel: FindViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.find_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FindViewModel::class.java)
        val observer = Observer<JsonObject>() {
            textView2.text = it.toString()
        }
        viewModel.query.observe(this, observer)
        viewModel.getQuery()
    }
}
