package com.luoyang.myandroidxstudy.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel;
import com.google.gson.JsonObject
import com.luoyang.myandroidxstudy.api.ResponseData
import com.luoyang.myandroidxstudy.net.NetServerEngine

class BoughtViewModel : ViewModel() {
    fun bought(): LiveData<ResponseData<JsonObject>> {
        return NetServerEngine.getInstance().getServer().bought()
    }
}
