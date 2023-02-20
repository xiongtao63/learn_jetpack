package com.xiongtao.jetpack.lifecycle

import android.util.Log
import androidx.lifecycle.LifecycleService


class MyLocationService : LifecycleService() {
    init {
        Log.e("========","MyLocationService")
        var observer = MyLocationObserver(this)
        lifecycle.addObserver(observer)
    }

}