package com.xiongtao.jetpack

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import com.xiongtao.jetpack.lifecycle.ApplicationObserver

/**
 * @Description:
 * @Author: 86188
 * @Date: 2023/2/6 17:29
 */
class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationObserver())
    }
}