package com.xiongtao.jetpack.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

//第二种方式：实现LifecycleEventObserver，通过onStateChanged回调获取生命周期状态。
class MyLifecycleObserver2 : LifecycleEventObserver {
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_START -> {
                Log.i("MyLifecycleObserver2", "activity onStart: $event")
            }
            Lifecycle.Event.ON_STOP -> {
                Log.i("MyLifecycleObserver2", "activity onStop: $event")
            }
        }
    }
}