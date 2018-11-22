package com.luoyang.myandroidxstudy.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.JsonObject
import com.luoyang.myandroidxstudy.net.NetServerEngine
import com.luoyang.myandroidxstudy.util.MyCallback

class BoughtViewModel : ViewModel() {
    var data = MutableLiveData<JsonObject>()
    fun bought() {
        NetServerEngine.instance.mNetServer.bought().enqueue(
            MyCallback(data)
        )
    }
}
