package com.luoyang.myandroidxstudy.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.luoyang.myandroidxstudy.R
import com.luoyang.myandroidxstudy.bean.Find
import kotlinx.android.synthetic.main.find_fragment.*

class FindFragment : Fragment() {

    companion object {
        fun newInstance() = FindFragment()
    }

    private lateinit var viewModel: FindViewModel
    private var adAdapter = object : BaseQuickAdapter<Find, BaseViewHolder>(R.layout.item_find_ad, ArrayList<Find>()) {
        override fun convert(helper: BaseViewHolder?, item: Find?) {
            if (item?.type.equals("AD")) {
                helper?.getView<TextView>(R.id.findAdItem_textView)?.text = item?.text
            }
        }
    }
    private var contentAdapter =
        object : BaseQuickAdapter<Find, BaseViewHolder>(R.layout.item_find_content, ArrayList<Find>()) {
            override fun convert(helper: BaseViewHolder?, item: Find?) {
                if (item?.type.equals("content")) {
                    helper?.getView<TextView>(R.id.findContentItem_textView2)?.text = item?.text
                }
            }
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.find_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FindViewModel::class.java)
        val observer = Observer<List<Find>>() {
            val adList = ArrayList<Find>()
            val contentList = ArrayList<Find>()
            it.iterator().forEach { find ->
                if (find.type.equals("AD")) {
                    adList.add(find)
                } else if (find.type.equals("content")) {
                    contentList.add(find)
                }
            }
            adAdapter.data.clear()
            adAdapter.data.addAll(adList)
            adAdapter.notifyDataSetChanged()
            contentAdapter.data.clear()
            contentAdapter.data.addAll(contentList)
            contentAdapter.notifyDataSetChanged()
        }
        viewModel.query.observe(this, observer)
        findAd_recyclerView.adapter = adAdapter
        findContent_recyclerView.adapter = contentAdapter
        viewModel.getQuery()
        adAdapter.onItemClickListener = BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
            val bundle = Bundle()
            bundle.putString("detail", (adapter.getItem(position) as Find).text)
            Navigation.findNavController(view).navigate(R.id.action_navigation_find_to_detailActivity, bundle)
        }
        contentAdapter.onItemClickListener = BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
            val bundle = Bundle()
            bundle.putString("detail", (adapter.getItem(position) as Find).text)
            Navigation.findNavController(view).navigate(R.id.action_navigation_find_to_detailActivity, bundle)
        }
    }
}
