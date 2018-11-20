/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.luoyang.myandroidxstudy.util


import androidx.lifecycle.LiveData
import com.luoyang.myandroidxstudy.api.ResponseData
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.lang.reflect.Type
import java.util.concurrent.atomic.AtomicBoolean

/**
 * A Retrofit adapter that converts the Call into a LiveData of ResponseData.
 * @param <R>
</R> */
class LiveDataCallAdapter<R>(private val responseType: Type) :
    CallAdapter<R, LiveData<ResponseData<R>>> {

    override fun responseType() = responseType

    override fun adapt(call: Call<R>): LiveData<ResponseData<R>> {
        return object : LiveData<ResponseData<R>>() {
            private var started = AtomicBoolean(false)
            override fun onActive() {
                super.onActive()
                if (started.compareAndSet(false, true)) {
                    call.enqueue(object : Callback<R> {
                        override fun onResponse(call: Call<R>, response: Response<R>) {
                            var responseData = ResponseData<R>();
                            if (response.isSuccessful()) {
                                responseData = response.body() as ResponseData<R>
                            } else {
                                try {
                                    responseData.message = (response.errorBody()?.string());
                                } catch (e: IOException) {
                                    e.printStackTrace();
                                }
                                responseData.data = null;
                                responseData.code = response.code();
                            }
                            postValue(responseData);
                        }

                        override fun onFailure(call: Call<R>, throwable: Throwable) {
                            val responseData = ResponseData<R>();
                            responseData.code = 500;
                            responseData.data = null;
                            responseData.message = throwable.message
                            postValue(responseData);
                        }
                    })
                }
            }
        }
    }
}