package com.luoyang.myandroidxstudy.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.JsonObject
import com.luoyang.myandroidxstudy.net.NetServerEngine
import com.luoyang.myandroidxstudy.util.MyCallback

class FindViewModel : ViewModel() {
    var query = MutableLiveData<JsonObject>()

    fun getQuery() {
        NetServerEngine.instance.mNetServer.query().enqueue(
            MyCallback(query)
        )
    }

}
