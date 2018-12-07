package com.luoyang.myandroidxstudy.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.google.gson.JsonObject;
import com.luoyang.myandroidxstudy.net.NetServerEngine;
import com.luoyang.myandroidxstudy.util.MyCallback;

/**
 * @author LuoYang
 */
public class BoughtViewModel extends ViewModel {
    private MutableLiveData<JsonObject> data;

    public MutableLiveData<JsonObject> getData() {
        if (data == null) {
            data = new MutableLiveData<>();
        }
        NetServerEngine.getServer().bought().enqueue(new MyCallback<>(data));
        return data;
    }
}
