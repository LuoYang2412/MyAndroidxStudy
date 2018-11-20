package com.luoyang.myandroidxstudy.net

import com.luoyang.myandroidxstudy.api.MyAndroidxStudyServer
import com.luoyang.myandroidxstudy.api.ResponseData
import com.luoyang.myandroidxstudy.util.LiveDataCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

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
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
            .create(MyAndroidxStudyServer::class.java)
    }

    fun getClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor {
                Timber.tag("网络数据").d(it)
            }.setLevel(HttpLoggingInterceptor.Level.BASIC))
            .build()
    }

    companion object {
        fun getInstance() = Holder.instance
    }

    private object Holder {
        val instance = NetServerEngine()
    }

    fun getServer(): MyAndroidxStudyServer {
        return mNetServer
    }
}