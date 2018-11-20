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
import com.luoyang.myandroidxstudy.api.ResponseData
import kotlinx.android.synthetic.main.bought_fragment.*
import kotlinx.android.synthetic.main.item_textv.*

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
        val observer = Observer<ResponseData<JsonObject>> {
            when (it.success) {
                true -> textView3.setText(it.data.toString())
                false -> textView.setText(it.message)
            }
        }
        viewModel.bought().observe(this, observer)
    }

}
