package com.xiongtao.jetpack.lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xiongtao.jetpack.R

class MainActivity1: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity1)
        lifecycle.addObserver(MyLifecycleObserver())
        lifecycle.addObserver(MyLifecycleObserver2())
    }
}