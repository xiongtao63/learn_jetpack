package com.xiongtao.jetpack.lifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xiongtao.jetpack.R

class LifeCycle3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle3)
    }

    fun startGps(view: android.view.View) {
        startService(Intent(this,MyLocationService::class.java))
    }
    fun stopGps(view: android.view.View) {
        stopService(Intent(this,MyLocationService::class.java))
    }
}