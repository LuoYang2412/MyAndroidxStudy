package com.luoyang.myandroidxstudy.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.luoyang.myandroidxstudy.bean.User
import com.luoyang.myandroidxstudy.net.NetServerEngine
import com.luoyang.myandroidxstudy.util.MyCallback

class MeViewModel : ViewModel() {
    var data = MutableLiveData<User>()
    fun meInfo() {
        NetServerEngine.instance.mNetServer.getMe().enqueue(MyCallback(data))
    }
}
