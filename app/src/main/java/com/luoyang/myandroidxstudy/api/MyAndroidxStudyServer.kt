package com.luoyang.myandroidxstudy.api

import com.google.gson.JsonObject
import com.luoyang.myandroidxstudy.bean.User
import com.luoyang.myandroidxstudy.net.NetConstant
import retrofit2.Call
import retrofit2.http.GET

/**
 * 网络请求服务
 */
interface MyAndroidxStudyServer {
    @GET(NetConstant.QUERY)
    fun query(): Call<ResponseData<JsonObject>>

    @GET(NetConstant.BOUGHT)
    fun bought(): Call<ResponseData<JsonObject>>

    @GET(NetConstant.ME)
    fun getMe(): Call<ResponseData<User>>
}