package com.luoyang.myandroidxstudy.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.luoyang.myandroidxstudy.bean.Find
import com.luoyang.myandroidxstudy.net.NetServerEngine
import com.luoyang.myandroidxstudy.util.MyCallback

class FindViewModel : ViewModel() {
    var query = MutableLiveData<List<Find>>()

    fun getQuery() {
        NetServerEngine.instance.mNetServer.find().enqueue(MyCallback(query))
    }

}
