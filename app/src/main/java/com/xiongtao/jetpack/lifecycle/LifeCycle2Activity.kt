package com.xiongtao.jetpack.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Chronometer
import com.xiongtao.jetpack.R

class LifeCycle2Activity : AppCompatActivity() {
    lateinit var chronometer:MyChronometer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle2)
        chronometer= findViewById<MyChronometer>(R.id.chronometer)
        lifecycle.addObserver(chronometer)
    }


}