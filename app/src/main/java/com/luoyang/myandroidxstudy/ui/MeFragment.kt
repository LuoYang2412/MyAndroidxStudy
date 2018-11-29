package com.luoyang.myandroidxstudy.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.luoyang.myandroidxstudy.R
import kotlinx.android.synthetic.main.me_fragment.*

class MeFragment : Fragment() {

    companion object {
        fun newInstance() = MeFragment()
    }

    private lateinit var viewModel: MeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.me_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MeViewModel::class.java)
        viewModel.data.observe(this, Observer {
            textView4.text = it.name
            textView5.text = it.age.toString()
        })
        viewModel.meInfo()

        textView4.setOnClickListener {
            val args = DetailFragmentArgs.Builder("我的信息").build().toBundle()
            Navigation.findNavController(it).navigate(R.id.action_navigation_me_to_detailFragment3, args)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.me, menu)
    }
}
