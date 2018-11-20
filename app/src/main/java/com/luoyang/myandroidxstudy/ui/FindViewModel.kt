package com.luoyang.myandroidxstudy.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.google.gson.JsonObject
import com.luoyang.myandroidxstudy.api.ResponseData
import com.luoyang.myandroidxstudy.net.NetServerEngine

class FindViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    val query = MutableLiveData<String>()

    fun getQuery(): LiveData<ResponseData<JsonObject>> {
        val query1 = NetServerEngine.getInstance().getServer().query()
        return query1
    }
}
