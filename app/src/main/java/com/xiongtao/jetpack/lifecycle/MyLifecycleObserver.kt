package com.xiongtao.jetpack.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

//第一种方式：实现LifecycleObserver，并通过注解的方式获取生命周期状态
class MyLifecycleObserver:LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart(owner: LifecycleOwner){
        Log.i("MyLifecycleObserver", "activity onStart")
    }
}