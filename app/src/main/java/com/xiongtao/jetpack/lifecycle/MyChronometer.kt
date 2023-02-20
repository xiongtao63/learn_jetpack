package com.xiongtao.jetpack.lifecycle

import android.content.Context
import android.os.SystemClock
import android.util.AttributeSet
import android.widget.Chronometer
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyChronometer(context: Context?, attrs: AttributeSet?) : Chronometer(context, attrs) ,LifecycleObserver{

    private var elapsedTime: Long = 0

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun startMeter(){
        base = SystemClock.elapsedRealtime() - elapsedTime
        start()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private fun stopMeter(){
        elapsedTime = SystemClock.elapsedRealtime() - base
        stop()
    }
}