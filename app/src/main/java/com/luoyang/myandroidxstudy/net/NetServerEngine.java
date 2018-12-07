package com.luoyang.myandroidxstudy.net;

import androidx.annotation.NonNull;
import com.luoyang.myandroidxstudy.api.MyAndroidxStudyServer;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * @author LuoYang
 */
public class NetServerEngine {
    private MyAndroidxStudyServer myAndroidxStudyServer;

    private NetServerEngine() {
        myAndroidxStudyServer = new Retrofit.Builder()
                .baseUrl(NetConstant.BASE_URL)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyAndroidxStudyServer.class);
    }

    private static class NetServerEngineHandle {
        private static final NetServerEngine INSTANCE = new NetServerEngine();
    }

    public static MyAndroidxStudyServer getServer() {
        return NetServerEngineHandle.INSTANCE.myAndroidxStudyServer;
    }

    private OkHttpClient getClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(@NonNull String message) {
                        Timber.tag("网络数据").d(message);
                    }
                })
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }
}
