package com.luoyang.myandroidxstudy.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.gson.JsonObject
import com.luoyang.myandroidxstudy.R
import kotlinx.android.synthetic.main.bought_fragment.*
import timber.log.Timber

class BoughtFragment : Fragment() {

    companion object {
        fun newInstance() = BoughtFragment()
    }

    private lateinit var viewModel: BoughtViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("创建")
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bought_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BoughtViewModel::class.java)
        val observer = Observer<JsonObject> {
            textView3.text = it.toString()
        }
        viewModel.data.observe(this, observer)
        viewModel.bought()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.bought, menu)
    }
}
