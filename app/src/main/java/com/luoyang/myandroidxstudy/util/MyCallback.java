package com.luoyang.myandroidxstudy.util;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.luoyang.myandroidxstudy.api.ResponseData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * 网络请求回调
 *
 * @param <T>
 * @author LuoYang
 */
public class MyCallback<T> implements Callback<ResponseData<T>> {

    private MutableLiveData<T> data;

    public MyCallback(MutableLiveData<T> data) {
        this.data = data;
    }

    @Override
    public void onResponse(@NonNull Call<ResponseData<T>> call, @NonNull Response<ResponseData<T>> response) {
        if (response.isSuccessful()) {
            ResponseData<T> body = response.body();
            if (body != null && body.getSuccess()) {
                data.postValue(body.getData());
            } else {
                if (body != null) {
                    Timber.tag("网络数据错误").e(body.getMessage());
                }
                ToastUtil.getInstance().show("网络数据错误");
            }
        }
    }

    @Override
    public void onFailure(@NonNull Call<ResponseData<T>> call, @NonNull Throwable t) {
        Timber.tag("网络错误").e(t);
        ToastUtil.getInstance().show("网络错误");
    }
}
