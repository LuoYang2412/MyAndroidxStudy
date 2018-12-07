package com.luoyang.myandroidxstudy.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.luoyang.myandroidxstudy.bean.User;
import com.luoyang.myandroidxstudy.net.NetServerEngine;
import com.luoyang.myandroidxstudy.util.MyCallback;

/**
 * @author LuoYang
 */
public class MeViewModel extends ViewModel {
    private MutableLiveData<User> data;

    public MutableLiveData<User> getData() {
        if (data == null) {
            data = new MutableLiveData<>();
        }
        NetServerEngine.getServer().getMe().enqueue(new MyCallback<>(data));
        return data;
    }
}
