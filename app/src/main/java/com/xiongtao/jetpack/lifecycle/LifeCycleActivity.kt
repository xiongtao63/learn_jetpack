package com.xiongtao.jetpack.lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xiongtao.jetpack.R

class LifeCycleActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        lifecycle.addObserver(MyLifecycleObserver())
        lifecycle.addObserver(MyLifecycleObserver2())
    }
}