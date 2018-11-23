package com.luoyang.myandroidxstudy

import android.app.Application
import timber.log.Timber

/**
 * Application
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}