package com.xiongtao.jetpack.lifecycle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.xiongtao.jetpack.R

class LifeCycleActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        lifecycle.addObserver(MyLifecycleObserver())
        lifecycle.addObserver(MyLifecycleObserver2())

        goToActivity(R.id.bt1, LifeCycle2Activity::class.java)
//        goToActivity(R.id.bt1, LifeCycle1Activity::class.java)
        goToActivity(R.id.bt2, LifeCycle3Activity::class.java)
    }

    private fun <T> goToActivity(resId:Int, clazz: Class<T>){
        findViewById<Button>(resId).setOnClickListener {
            val intent = Intent(applicationContext, clazz)
            startActivity(intent)
        }
    }
}