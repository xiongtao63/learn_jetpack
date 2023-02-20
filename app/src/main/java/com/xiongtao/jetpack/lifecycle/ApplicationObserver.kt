package com.xiongtao.jetpack.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * @Description:
 * @Author: 86188
 * @Date: 2023/2/6 17:31
 */
class ApplicationObserver : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun onCreate(){
        Log.e("======","onCreate")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun onStart(){
        Log.e("======","onStart")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun onResume(){
        Log.e("======","onResume")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private fun onPause(){
        Log.e("======","onPause")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private fun onStop(){
        Log.e("======","onStop")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy(){
        Log.e("======","onDestroy")
    }
}