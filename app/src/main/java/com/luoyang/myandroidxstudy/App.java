package com.luoyang.myandroidxstudy;

import android.app.Application;
import com.luoyang.myandroidxstudy.util.ToastUtil;
import timber.log.Timber;

/**
 * @author LuoYang
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        ToastUtil.getInstance().init(this);
    }
}
