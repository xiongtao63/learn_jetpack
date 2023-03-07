package com.xiongtao.livedata_demo.lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xiongtao.livedata_demo.R

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-03-06 16:05
 */
class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 观察者 == MyLocationListener
        // 1.主线流程，支线流程不管（防止淹死源码）
        // 2.支线流程
//        lifecycle.addObserver(MyLocationListener())
    }

    override fun onResume() {
        super.onResume()

        // CREATE --->  START  ---> RESUME
        // lifecycle.addObserver(MyLocationListener())

        // onCreate  onStart  onResume
//        lifecycle.addObserver(MyLocationListener())
    }

    override fun onStop() {
        super.onStop()
        // initial -> create 要执行onCreate
        /*
        addObsever()的时候是初始状态
          后面只执行了onDestroyed()
          所以是onCreate和onDestroyed
        */
        // onCreate  onStop
        lifecycle.addObserver(MyLocationListener())
    }
}