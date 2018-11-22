package com.luoyang.myandroidxstudy.net

import com.luoyang.myandroidxstudy.api.MyAndroidxStudyServer
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

/**
 * 网络接口服务类
 * @author LuoYang 2018-11-17 16:50:07
 */
class NetServerEngine private constructor() {
    var mNetServer: MyAndroidxStudyServer

    private object Holder {
        val instance = NetServerEngine()
    }

    companion object {
        val instance by lazy { Holder.instance }
    }

    init {
        mNetServer = Retrofit.Builder()
            .baseUrl(NetConstant.BASE_URL)
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyAndroidxStudyServer::class.java)
    }

    private fun getClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor {
                Timber.tag("网络数据").d(it)
            }.setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }
}