package com.luoyang.myandroidxstudy.api

import androidx.lifecycle.LiveData
import com.google.gson.JsonObject
import com.luoyang.myandroidxstudy.net.NetConstant
import retrofit2.http.GET

interface MyAndroidxStudyServer {
    @GET(NetConstant.QUERY)
    fun query(): LiveData<ResponseData<JsonObject>>

    @GET(NetConstant.BOUGHT)
    fun bought(): LiveData<ResponseData<JsonObject>>
}