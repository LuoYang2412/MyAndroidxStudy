package com.luoyang.myandroidxstudy.net

import com.luoyang.myandroidxstudy.api.MyAndroidxStudyServer
import com.luoyang.myandroidxstudy.util.LiveDataCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 网络接口服务类
 * @author LuoYang 2018-11-17 16:50:07
 */
class NetServerEngine() {
    private lateinit var mNetServer: MyAndroidxStudyServer
    @Volatile
    private lateinit var mInstance: NetServerEngine

    init {
        mNetServer = Retrofit.Builder()
            .baseUrl(NetConstant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
            .create(MyAndroidxStudyServer::class.java)
    }

    companion object {
        fun getInstance() = Holder.instance
    }

    private object Holder {
        val instance = NetServerEngine()
    }

}