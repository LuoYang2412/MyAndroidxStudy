package com.luoyang.myandroidxstudy.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.luoyang.myandroidxstudy.bean.Find;
import com.luoyang.myandroidxstudy.net.NetServerEngine;
import com.luoyang.myandroidxstudy.util.MyCallback;

import java.util.List;

/**
 * @author LuoYang
 */
public class FindViewModel extends ViewModel {
    private MutableLiveData<List<Find>> query;

    MutableLiveData<List<Find>> getQuery() {
        if (null == query) {
            query = new MutableLiveData<>();
        }
        NetServerEngine.getServer().find().enqueue(new MyCallback<>(query));
        return query;
    }
}
