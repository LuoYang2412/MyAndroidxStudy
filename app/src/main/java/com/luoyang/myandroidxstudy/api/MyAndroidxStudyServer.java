package com.luoyang.myandroidxstudy.api;

import com.google.gson.JsonObject;
import com.luoyang.myandroidxstudy.bean.Find;
import com.luoyang.myandroidxstudy.bean.User;
import com.luoyang.myandroidxstudy.net.NetConstant;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

/**
 * 网络请求服务
 *
 * @author LuoYang
 */
public interface MyAndroidxStudyServer {
    @GET(NetConstant.FIND)
    Call<ResponseData<List<Find>>> find();

    @GET(NetConstant.BOUGHT)
    Call<ResponseData<JsonObject>> bought();

    @GET(NetConstant.ME)
    Call<ResponseData<User>> getMe();
}
