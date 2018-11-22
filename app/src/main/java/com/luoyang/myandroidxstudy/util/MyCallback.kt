package com.luoyang.myandroidxstudy.util

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.luoyang.myandroidxstudy.api.ResponseData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

/**
 * 网络请求回调处理
 */
class MyCallback<T> : Callback<ResponseData<T>> {

    private lateinit var data: MutableLiveData<T>

    constructor(data: MutableLiveData<T>) {
        this.data = data
    }

    override fun onResponse(call: Call<ResponseData<T>>, response: Response<ResponseData<T>>) {
        if (response.isSuccessful) {
            val mResponseData = response.body()
            if (mResponseData!!.success) {
                data.value = mResponseData.data
            } else {
                Timber.tag("网络数据错误").e(mResponseData.message)
            }
        }
    }

    override fun onFailure(call: Call<ResponseData<T>>, t: Throwable) {
        Timber.tag("网络错误").e(t)
    }
}
